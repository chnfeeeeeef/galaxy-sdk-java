/**
 * Copyright 2015, Xiaomi.
 * All rights reserved.
 * Author: yongxing@xiaomi.com
 */

package com.xiaomi.infra.galaxy.talos.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import com.google.common.base.Preconditions;
import libthrift091.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaomi.infra.galaxy.rpc.thrift.Credential;
import com.xiaomi.infra.galaxy.talos.admin.TalosAdmin;
import com.xiaomi.infra.galaxy.talos.client.Constants;
import com.xiaomi.infra.galaxy.talos.client.ScheduleInfoCache;
import com.xiaomi.infra.galaxy.talos.client.TalosClientFactory;
import com.xiaomi.infra.galaxy.talos.client.TopicAbnormalCallback;
import com.xiaomi.infra.galaxy.talos.client.Utils;
import com.xiaomi.infra.galaxy.talos.thrift.DescribeTopicRequest;
import com.xiaomi.infra.galaxy.talos.thrift.Message;
import com.xiaomi.infra.galaxy.talos.thrift.MessageType;
import com.xiaomi.infra.galaxy.talos.thrift.Topic;
import com.xiaomi.infra.galaxy.talos.thrift.TopicTalosResourceName;

public class TalosProducer {

  private class CheckPartitionTask implements Runnable {
    @Override
    public void run() {
      Topic topic;
      try {
        topic = talosAdmin.describeTopic(new DescribeTopicRequest(topicName));
      } catch (Throwable throwable) {
        LOG.error("Exception in CheckPartitionTask: ", throwable);
        if (Utils.isTopicNotExist(throwable)) {
          disableProducer(throwable);
        }
        return;
      }

      if (!topicTalosResourceName.equals(
          topic.getTopicInfo().getTopicTalosResourceName())) {
        String errMsg = "The topic: " +
            topicTalosResourceName.getTopicTalosResourceName() +
            " not exist. It might have been deleted. " +
            "The putMessage threads will be cancel.";
        LOG.error(errMsg);
        // cancel the putMessage thread
        disableProducer(new Throwable(errMsg));
        return;
      }

      int topicPartitionNum = topic.getTopicAttribute().getPartitionNumber();
      if (partitionNumber < topicPartitionNum) {
        // increase partitionSender (not allow decreasing)
        adjustPartitionSender(topicPartitionNum);
        // update partitionNumber
        setPartitionNumber(topicPartitionNum);
      }
    }

  } // CheckPartitionTask

  private enum PRODUCER_STATE {
    ACTIVE,
    DISABLED,
    SHUTDOWN,
  }

  private static final Logger LOG = LoggerFactory.getLogger(TalosProducer.class);
  private final int partitionKeyMinLen = Constants.TALOS_PARTITION_KEY_LENGTH_MINIMAL;
  private final int partitionKeyMaxLen = Constants.TALOS_PARTITION_KEY_LENGTH_MAXIMAL;
  private static final AtomicLong requestId = new AtomicLong(1);
  private static final Object globalLock = new Object();

  private AtomicReference<PRODUCER_STATE> producerState;
  private Partitioner partitioner;
  private TopicAbnormalCallback topicAbnormalCallback;
  private UserMessageCallback userMessageCallback;
  private TalosProducerConfig talosProducerConfig;
  private long updatePartitionIdInterval;
  private long lastUpdatePartitionIdTime;
  private long updatePartitionIdMsgNumber;
  private long lastAddMsgNumber;
  private Random random;
  private int maxBufferedMsgNumber;
  private int maxBufferedMsgBytes;
  private BufferedMessageCount bufferedCount;
  private String clientId;
  private TalosClientFactory talosClientFactory;
  private TalosAdmin talosAdmin;
  private ScheduleInfoCache scheduleInfoCache;

  private String topicName;
  private int partitionNumber;
  private int curPartitionId;
  private TopicTalosResourceName topicTalosResourceName;

  private ExecutorService messageCallbackExecutors;
  private ScheduledExecutorService partitionCheckExecutor;
  private Future partitionCheckFuture;
  private final Map<Integer, PartitionSender> partitionSenderMap =
      new ConcurrentHashMap<Integer, PartitionSender>();

  public TalosProducer(TalosProducerConfig producerConfig,
      TopicTalosResourceName topicTalosResourceName,
      TopicAbnormalCallback topicAbnormalCallback,
      UserMessageCallback userMessageCallback) throws TException {
    this(producerConfig, new Credential(),
        topicTalosResourceName, new SimplePartitioner(),
        topicAbnormalCallback, userMessageCallback);
  }

  public TalosProducer(TalosProducerConfig producerConfig, Credential credential,
      TopicTalosResourceName topicTalosResourceName,
      TopicAbnormalCallback topicAbnormalCallback,
      UserMessageCallback userMessageCallback) throws TException {
    this(producerConfig, credential,
        topicTalosResourceName, new SimplePartitioner(),
        topicAbnormalCallback, userMessageCallback);
  }

  public TalosProducer(TalosProducerConfig producerConfig, Credential credential,
      TopicTalosResourceName topicTalosResourceName, Partitioner partitioner,
      TopicAbnormalCallback topicAbnormalCallback,
      UserMessageCallback userMessageCallback) throws TException {
    producerState = new AtomicReference<PRODUCER_STATE>(PRODUCER_STATE.ACTIVE);
    this.partitioner = partitioner;
    this.topicAbnormalCallback = topicAbnormalCallback;
    this.userMessageCallback = userMessageCallback;
    talosProducerConfig = producerConfig;
    updatePartitionIdInterval = talosProducerConfig.getUpdatePartitionIdInterval();
    lastUpdatePartitionIdTime = System.currentTimeMillis();
    updatePartitionIdMsgNumber = talosProducerConfig.getUpdatePartitionMsgNum();
    lastAddMsgNumber = 0;
    random = new Random();
    maxBufferedMsgNumber = talosProducerConfig.getMaxBufferedMsgNumber();
    maxBufferedMsgBytes = talosProducerConfig.getMaxBufferedMsgBytes();
    bufferedCount = new BufferedMessageCount(maxBufferedMsgNumber, maxBufferedMsgBytes);
    clientId = Utils.generateClientId();
    talosClientFactory = new TalosClientFactory(talosProducerConfig, credential);
    talosAdmin = new TalosAdmin(talosClientFactory);
    this.scheduleInfoCache = ScheduleInfoCache.getScheduleInfoCache(topicTalosResourceName,
        producerConfig, talosClientFactory.newMessageClient(), talosClientFactory);
    checkAndGetTopicInfo(topicTalosResourceName);

    messageCallbackExecutors = Executors.newFixedThreadPool(
        talosProducerConfig.getThreadPoolsize());
    partitionCheckExecutor = Executors.newSingleThreadScheduledExecutor();
    initPartitionSender();
    initCheckPartitionTask();
    LOG.info("Init a producer for topic: " +
        topicTalosResourceName.getTopicTalosResourceName() +
        ", partitions: " + partitionNumber);
  }

  // for test
  public TalosProducer(TalosProducerConfig producerConfig,
      TopicTalosResourceName topicTalosResourceName, TalosAdmin talosAdmin,
      TalosClientFactory talosClientFactory,
      PartitionSender partitionSender,
      TopicAbnormalCallback topicAbnormalCallback,
      UserMessageCallback userMessageCallback) throws TException {
    producerState = new AtomicReference<PRODUCER_STATE>(PRODUCER_STATE.ACTIVE);
    partitioner = new SimplePartitioner();
    this.topicAbnormalCallback = topicAbnormalCallback;
    this.userMessageCallback = userMessageCallback;
    this.talosProducerConfig = producerConfig;
    updatePartitionIdInterval = talosProducerConfig.getUpdatePartitionIdInterval();
    lastUpdatePartitionIdTime = System.currentTimeMillis();
    updatePartitionIdMsgNumber = talosProducerConfig.getUpdatePartitionMsgNum();
    lastAddMsgNumber = 0;
    random = new Random();
    maxBufferedMsgNumber = talosProducerConfig.getMaxBufferedMsgNumber();
    maxBufferedMsgBytes = talosProducerConfig.getMaxBufferedMsgBytes();
    bufferedCount = new BufferedMessageCount(maxBufferedMsgNumber, maxBufferedMsgBytes);
    this.topicTalosResourceName = topicTalosResourceName;
    clientId = Utils.generateClientId();
    this.talosClientFactory = talosClientFactory;
    this.talosAdmin = talosAdmin;
    this.scheduleInfoCache = ScheduleInfoCache.getScheduleInfoCache(topicTalosResourceName,
        producerConfig, talosClientFactory.newMessageClient(), talosClientFactory);
    checkAndGetTopicInfo(topicTalosResourceName);
    messageCallbackExecutors = Executors.newFixedThreadPool(
        talosProducerConfig.getThreadPoolsize());
    partitionCheckExecutor = Executors.newSingleThreadScheduledExecutor();
    initPartitionSender();
    initCheckPartitionTask();
    LOG.info("Init a producer for topic: " +
        topicTalosResourceName.getTopicTalosResourceName() +
        ", partitions: " + partitionNumber);
  }

  public synchronized void addUserMessage(List<Message> msgList, long timeoutMillis)
      throws ProducerNotActiveException, AddMessageTimeoutException {
    // check producer state
    if (!isActive()) {
      throw new ProducerNotActiveException("Producer is not active, " +
          "current state: " + producerState);
    }

    // check total buffered message number
    while (bufferedCount.isFull()) {
      synchronized (globalLock) {
        try {
          LOG.info("too many buffered messages, globalLock is active." +
              " message number: " + bufferedCount.getBufferedMsgNumber() +
              ", message bytes:  " + bufferedCount.getBufferedMsgBytes());

          long startWaitTime = System.currentTimeMillis();
          globalLock.wait(timeoutMillis);
          // judging wait exit by 'timeout' or 'notify'
          if (System.currentTimeMillis() - startWaitTime >= timeoutMillis) {
            throw new AddMessageTimeoutException("Producer buffer is full and " +
                "addUserMessage timeout by: " + timeoutMillis + " millis");
          }
        } catch (InterruptedException e) {
          LOG.error("addUserMessage global lock wait is interrupt.", e);
        }
      } // release global lock but no notify
    }

    doAddUserMessage(msgList);
  }

  public synchronized void addUserMessage(List<Message> msgList)
      throws ProducerNotActiveException {
    // check producer state
    if (!isActive()) {
      throw new ProducerNotActiveException("Producer is not active, " +
          "current state: " + producerState);
    }

    // check total buffered message number
    while (bufferedCount.isFull()) {
      synchronized (globalLock) {
        try {
          LOG.info("too many buffered messages, globalLock is active." +
              " message number: " + bufferedCount.getBufferedMsgNumber() +
              ", message bytes:  " + bufferedCount.getBufferedMsgBytes());
          globalLock.wait();
        } catch (InterruptedException e) {
          LOG.error("addUserMessage global lock wait is interrupt.", e);
        }
      } // release global lock but no notify
    } // while

    doAddUserMessage(msgList);
  }

  private synchronized void doAddUserMessage(List<Message> msgList) {
    // user can optionally set 'partitionKey' and 'sequenceNumber' when construct Message
    Map<Integer, List<UserMessage>> partitionBufferMap =
        new HashMap<Integer, List<UserMessage>>();
    int currentPartitionId;

    // check/update curPartitionId
    synchronized (this) {
      if (shouldUpdatePartition()) {
        curPartitionId = (curPartitionId + 1) % partitionNumber;
        lastUpdatePartitionIdTime = System.currentTimeMillis();
        lastAddMsgNumber = 0;
      }
      currentPartitionId = curPartitionId;
      lastAddMsgNumber += msgList.size();
    }

    partitionBufferMap.put(currentPartitionId, new ArrayList<UserMessage>());

    for (Message message : msgList) {
      // set timestamp and messageType if not set;
      Utils.updateMessage(message, MessageType.BINARY);
      Utils.updateMessage(message, MessageType.BINARY);
      // check data validity
      Utils.checkMessageValidity(message);

      // check partitionKey setting and validity
      if (!message.isSetPartitionKey()) {
        // straightforward put to cur partitionId queue
        partitionBufferMap.get(currentPartitionId).add(new UserMessage(message));
      } else {
        checkMessagePartitionKeyValidity(message.getPartitionKey());
        // construct UserMessage and dispatch to buffer by partitionId
        int partitionId = getPartitionId(message.getPartitionKey());
        if (!partitionBufferMap.containsKey(partitionId)) {
          partitionBufferMap.put(partitionId, new ArrayList<UserMessage>());
        }
        partitionBufferMap.get(partitionId).add(new UserMessage(message));
      }

    }

    // add to partitionSender
    for (Map.Entry<Integer, List<UserMessage>> entry : partitionBufferMap.entrySet()) {
      int partitionId = entry.getKey();
      Preconditions.checkArgument(partitionSenderMap.containsKey(partitionId));
      partitionSenderMap.get(partitionId).addMessage(entry.getValue());
    }
  }

  // cancel the putMessage threads and checkPartitionTask
  // when topic not exist during producer running
  private synchronized void disableProducer(Throwable throwable) {
    if (!isActive()) {
      return;
    }

    producerState.set(PRODUCER_STATE.DISABLED);
    stopAndWait();
    topicAbnormalCallback.abnormalHandler(topicTalosResourceName, throwable);
  }

  public synchronized void shutdown() {
    if (!isActive()) {
      return;
    }

    producerState.set(PRODUCER_STATE.SHUTDOWN);
    stopAndWait();
  }

  private void stopAndWait() {
    for (Map.Entry<Integer, PartitionSender> entry : partitionSenderMap.entrySet()) {
      entry.getValue().shutdown();
    }
    partitionCheckFuture.cancel(false);
    partitionCheckExecutor.shutdownNow();
    messageCallbackExecutors.shutdownNow();
    scheduleInfoCache.shutDown();
  }

  public boolean isActive() {
    return producerState.get() == PRODUCER_STATE.ACTIVE;
  }

  public boolean isDisabled() {
    return producerState.get() == PRODUCER_STATE.DISABLED;
  }

  public boolean isShutdowned() {
    return producerState.get() == PRODUCER_STATE.SHUTDOWN;
  }

  private synchronized boolean shouldUpdatePartition() {
    return (System.currentTimeMillis() - lastUpdatePartitionIdTime >=
        updatePartitionIdInterval) || (lastAddMsgNumber >=
        updatePartitionIdMsgNumber);
  }

  private synchronized void checkAndGetTopicInfo(
      TopicTalosResourceName topicTalosResourceName) throws TException {
    topicName = Utils.getTopicNameByResourceName(
        topicTalosResourceName.getTopicTalosResourceName());
    Topic topic = talosAdmin.describeTopic(new DescribeTopicRequest(topicName));

    if (!topicTalosResourceName.equals(
        topic.getTopicInfo().getTopicTalosResourceName())) {
      throw new IllegalArgumentException("The topic: " +
          topicTalosResourceName.getTopicTalosResourceName() + " not found");
    }
    partitionNumber = topic.getTopicAttribute().getPartitionNumber();
    curPartitionId = random.nextInt(partitionNumber);
    this.topicTalosResourceName = topicTalosResourceName;
  }

  private synchronized void initPartitionSender() {
    for (int partitionId = 0; partitionId < partitionNumber; ++partitionId) {
      createPartitionSender(partitionId);
    }
  }

  private synchronized void adjustPartitionSender(int newPartitionNum) {
    // Note: we do not allow and process 'newPartitionNum < partitionNumber'
    for (int partitionId = partitionNumber; partitionId < newPartitionNum;
         ++partitionId) {
      createPartitionSender(partitionId);
    }
    LOG.info("Adjust partitionSender and partitionNumber from: " +
        partitionNumber + " to: " + newPartitionNum);
  }

  private synchronized void createPartitionSender(int partitionId) {
    PartitionSender partitionSender = new PartitionSender(partitionId,
        topicName, topicTalosResourceName, requestId, clientId,
        talosProducerConfig, talosClientFactory.newMessageClient(),
        userMessageCallback, messageCallbackExecutors, globalLock, this);
    partitionSenderMap.put(partitionId, partitionSender);
  }

  private synchronized void initCheckPartitionTask() {
    // check and update partition number every 3 minutes by default
    partitionCheckFuture = partitionCheckExecutor.scheduleAtFixedRate(
        new CheckPartitionTask(), talosProducerConfig.getCheckPartitionInterval(),
        talosProducerConfig.getCheckPartitionInterval(), TimeUnit.MILLISECONDS);
  }

  private int getPartitionId(String partitionKey) {
    return partitioner.partition(partitionKey, partitionNumber);
  }

  private String generatePartitionKey() {
    return UUID.randomUUID().toString();
  }

  private synchronized void setPartitionNumber(int partitionNumber) {
    this.partitionNumber = partitionNumber;
  }

  private void checkMessagePartitionKeyValidity(String partitionKey) {
    Preconditions.checkNotNull(partitionKey);
    if (partitionKey.length() < partitionKeyMinLen ||
        partitionKey.length() > partitionKeyMaxLen) {
      throw new IllegalArgumentException("Invalid partition key which length " +
          "must be at least " + partitionKeyMinLen + " and at most " +
          partitionKeyMinLen + ", got " + partitionKey.length());
    }
  }

  protected void increaseBufferedCount(int incrementNumber,
      int incrementBytes) {
    bufferedCount.increase(incrementNumber, incrementBytes);
  }

  protected void decreaseBufferedCount(int decrementNumber,
      int decrementBytes) {
    bufferedCount.descrease(decrementNumber, decrementBytes);
  }

}
