/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xiaomi.infra.galaxy.emq.thrift;

import libthrift091.scheme.IScheme;
import libthrift091.scheme.SchemeFactory;
import libthrift091.scheme.StandardScheme;

import libthrift091.scheme.TupleScheme;
import libthrift091.protocol.TTupleProtocol;
import libthrift091.protocol.TProtocolException;
import libthrift091.EncodingUtils;
import libthrift091.TException;
import libthrift091.async.AsyncMethodCallback;
import libthrift091.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2016-3-17")
public class CreateQueueRequest implements libthrift091.TBase<CreateQueueRequest, CreateQueueRequest._Fields>, java.io.Serializable, Cloneable, Comparable<CreateQueueRequest> {
  private static final libthrift091.protocol.TStruct STRUCT_DESC = new libthrift091.protocol.TStruct("CreateQueueRequest");

  private static final libthrift091.protocol.TField QUEUE_NAME_FIELD_DESC = new libthrift091.protocol.TField("queueName", libthrift091.protocol.TType.STRING, (short)1);
  private static final libthrift091.protocol.TField QUEUE_ATTRIBUTE_FIELD_DESC = new libthrift091.protocol.TField("queueAttribute", libthrift091.protocol.TType.STRUCT, (short)2);
  private static final libthrift091.protocol.TField QUEUE_QUOTA_FIELD_DESC = new libthrift091.protocol.TField("queueQuota", libthrift091.protocol.TType.STRUCT, (short)3);
  private static final libthrift091.protocol.TField DEAD_LETTER_QUEUE_FIELD_DESC = new libthrift091.protocol.TField("deadLetterQueue", libthrift091.protocol.TType.BOOL, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CreateQueueRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CreateQueueRequestTupleSchemeFactory());
  }

  /**
   * The queue name;
   * 
   */
  public String queueName; // required
  /**
   * The queue attribute;
   * 
   */
  public QueueAttribute queueAttribute; // optional
  /**
   * The queue quota, including space quota, read qps, and write qps;
   * 
   */
  public QueueQuota queueQuota; // optional
  /**
   * Set the queue be a dead letter queue or not;
   * 
   */
  public boolean deadLetterQueue; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements libthrift091.TFieldIdEnum {
    /**
     * The queue name;
     * 
     */
    QUEUE_NAME((short)1, "queueName"),
    /**
     * The queue attribute;
     * 
     */
    QUEUE_ATTRIBUTE((short)2, "queueAttribute"),
    /**
     * The queue quota, including space quota, read qps, and write qps;
     * 
     */
    QUEUE_QUOTA((short)3, "queueQuota"),
    /**
     * Set the queue be a dead letter queue or not;
     * 
     */
    DEAD_LETTER_QUEUE((short)4, "deadLetterQueue");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // QUEUE_NAME
          return QUEUE_NAME;
        case 2: // QUEUE_ATTRIBUTE
          return QUEUE_ATTRIBUTE;
        case 3: // QUEUE_QUOTA
          return QUEUE_QUOTA;
        case 4: // DEAD_LETTER_QUEUE
          return DEAD_LETTER_QUEUE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __DEADLETTERQUEUE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.QUEUE_ATTRIBUTE,_Fields.QUEUE_QUOTA,_Fields.DEAD_LETTER_QUEUE};
  public static final Map<_Fields, libthrift091.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, libthrift091.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, libthrift091.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUEUE_NAME, new libthrift091.meta_data.FieldMetaData("queueName", libthrift091.TFieldRequirementType.REQUIRED, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING)));
    tmpMap.put(_Fields.QUEUE_ATTRIBUTE, new libthrift091.meta_data.FieldMetaData("queueAttribute", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.StructMetaData(libthrift091.protocol.TType.STRUCT, QueueAttribute.class)));
    tmpMap.put(_Fields.QUEUE_QUOTA, new libthrift091.meta_data.FieldMetaData("queueQuota", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.StructMetaData(libthrift091.protocol.TType.STRUCT, QueueQuota.class)));
    tmpMap.put(_Fields.DEAD_LETTER_QUEUE, new libthrift091.meta_data.FieldMetaData("deadLetterQueue", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    libthrift091.meta_data.FieldMetaData.addStructMetaDataMap(CreateQueueRequest.class, metaDataMap);
  }

  public CreateQueueRequest() {
  }

  public CreateQueueRequest(
    String queueName)
  {
    this();
    this.queueName = queueName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CreateQueueRequest(CreateQueueRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetQueueName()) {
      this.queueName = other.queueName;
    }
    if (other.isSetQueueAttribute()) {
      this.queueAttribute = new QueueAttribute(other.queueAttribute);
    }
    if (other.isSetQueueQuota()) {
      this.queueQuota = new QueueQuota(other.queueQuota);
    }
    this.deadLetterQueue = other.deadLetterQueue;
  }

  public CreateQueueRequest deepCopy() {
    return new CreateQueueRequest(this);
  }

  @Override
  public void clear() {
    this.queueName = null;
    this.queueAttribute = null;
    this.queueQuota = null;
    setDeadLetterQueueIsSet(false);
    this.deadLetterQueue = false;
  }

  /**
   * The queue name;
   * 
   */
  public String getQueueName() {
    return this.queueName;
  }

  /**
   * The queue name;
   * 
   */
  public CreateQueueRequest setQueueName(String queueName) {
    this.queueName = queueName;
    return this;
  }

  public void unsetQueueName() {
    this.queueName = null;
  }

  /** Returns true if field queueName is set (has been assigned a value) and false otherwise */
  public boolean isSetQueueName() {
    return this.queueName != null;
  }

  public void setQueueNameIsSet(boolean value) {
    if (!value) {
      this.queueName = null;
    }
  }

  /**
   * The queue attribute;
   * 
   */
  public QueueAttribute getQueueAttribute() {
    return this.queueAttribute;
  }

  /**
   * The queue attribute;
   * 
   */
  public CreateQueueRequest setQueueAttribute(QueueAttribute queueAttribute) {
    this.queueAttribute = queueAttribute;
    return this;
  }

  public void unsetQueueAttribute() {
    this.queueAttribute = null;
  }

  /** Returns true if field queueAttribute is set (has been assigned a value) and false otherwise */
  public boolean isSetQueueAttribute() {
    return this.queueAttribute != null;
  }

  public void setQueueAttributeIsSet(boolean value) {
    if (!value) {
      this.queueAttribute = null;
    }
  }

  /**
   * The queue quota, including space quota, read qps, and write qps;
   * 
   */
  public QueueQuota getQueueQuota() {
    return this.queueQuota;
  }

  /**
   * The queue quota, including space quota, read qps, and write qps;
   * 
   */
  public CreateQueueRequest setQueueQuota(QueueQuota queueQuota) {
    this.queueQuota = queueQuota;
    return this;
  }

  public void unsetQueueQuota() {
    this.queueQuota = null;
  }

  /** Returns true if field queueQuota is set (has been assigned a value) and false otherwise */
  public boolean isSetQueueQuota() {
    return this.queueQuota != null;
  }

  public void setQueueQuotaIsSet(boolean value) {
    if (!value) {
      this.queueQuota = null;
    }
  }

  /**
   * Set the queue be a dead letter queue or not;
   * 
   */
  public boolean isDeadLetterQueue() {
    return this.deadLetterQueue;
  }

  /**
   * Set the queue be a dead letter queue or not;
   * 
   */
  public CreateQueueRequest setDeadLetterQueue(boolean deadLetterQueue) {
    this.deadLetterQueue = deadLetterQueue;
    setDeadLetterQueueIsSet(true);
    return this;
  }

  public void unsetDeadLetterQueue() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DEADLETTERQUEUE_ISSET_ID);
  }

  /** Returns true if field deadLetterQueue is set (has been assigned a value) and false otherwise */
  public boolean isSetDeadLetterQueue() {
    return EncodingUtils.testBit(__isset_bitfield, __DEADLETTERQUEUE_ISSET_ID);
  }

  public void setDeadLetterQueueIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DEADLETTERQUEUE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUEUE_NAME:
      if (value == null) {
        unsetQueueName();
      } else {
        setQueueName((String)value);
      }
      break;

    case QUEUE_ATTRIBUTE:
      if (value == null) {
        unsetQueueAttribute();
      } else {
        setQueueAttribute((QueueAttribute)value);
      }
      break;

    case QUEUE_QUOTA:
      if (value == null) {
        unsetQueueQuota();
      } else {
        setQueueQuota((QueueQuota)value);
      }
      break;

    case DEAD_LETTER_QUEUE:
      if (value == null) {
        unsetDeadLetterQueue();
      } else {
        setDeadLetterQueue((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUEUE_NAME:
      return getQueueName();

    case QUEUE_ATTRIBUTE:
      return getQueueAttribute();

    case QUEUE_QUOTA:
      return getQueueQuota();

    case DEAD_LETTER_QUEUE:
      return Boolean.valueOf(isDeadLetterQueue());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUEUE_NAME:
      return isSetQueueName();
    case QUEUE_ATTRIBUTE:
      return isSetQueueAttribute();
    case QUEUE_QUOTA:
      return isSetQueueQuota();
    case DEAD_LETTER_QUEUE:
      return isSetDeadLetterQueue();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CreateQueueRequest)
      return this.equals((CreateQueueRequest)that);
    return false;
  }

  public boolean equals(CreateQueueRequest that) {
    if (that == null)
      return false;

    boolean this_present_queueName = true && this.isSetQueueName();
    boolean that_present_queueName = true && that.isSetQueueName();
    if (this_present_queueName || that_present_queueName) {
      if (!(this_present_queueName && that_present_queueName))
        return false;
      if (!this.queueName.equals(that.queueName))
        return false;
    }

    boolean this_present_queueAttribute = true && this.isSetQueueAttribute();
    boolean that_present_queueAttribute = true && that.isSetQueueAttribute();
    if (this_present_queueAttribute || that_present_queueAttribute) {
      if (!(this_present_queueAttribute && that_present_queueAttribute))
        return false;
      if (!this.queueAttribute.equals(that.queueAttribute))
        return false;
    }

    boolean this_present_queueQuota = true && this.isSetQueueQuota();
    boolean that_present_queueQuota = true && that.isSetQueueQuota();
    if (this_present_queueQuota || that_present_queueQuota) {
      if (!(this_present_queueQuota && that_present_queueQuota))
        return false;
      if (!this.queueQuota.equals(that.queueQuota))
        return false;
    }

    boolean this_present_deadLetterQueue = true && this.isSetDeadLetterQueue();
    boolean that_present_deadLetterQueue = true && that.isSetDeadLetterQueue();
    if (this_present_deadLetterQueue || that_present_deadLetterQueue) {
      if (!(this_present_deadLetterQueue && that_present_deadLetterQueue))
        return false;
      if (this.deadLetterQueue != that.deadLetterQueue)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_queueName = true && (isSetQueueName());
    list.add(present_queueName);
    if (present_queueName)
      list.add(queueName);

    boolean present_queueAttribute = true && (isSetQueueAttribute());
    list.add(present_queueAttribute);
    if (present_queueAttribute)
      list.add(queueAttribute);

    boolean present_queueQuota = true && (isSetQueueQuota());
    list.add(present_queueQuota);
    if (present_queueQuota)
      list.add(queueQuota);

    boolean present_deadLetterQueue = true && (isSetDeadLetterQueue());
    list.add(present_deadLetterQueue);
    if (present_deadLetterQueue)
      list.add(deadLetterQueue);

    return list.hashCode();
  }

  @Override
  public int compareTo(CreateQueueRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetQueueName()).compareTo(other.isSetQueueName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueueName()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.queueName, other.queueName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQueueAttribute()).compareTo(other.isSetQueueAttribute());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueueAttribute()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.queueAttribute, other.queueAttribute);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQueueQuota()).compareTo(other.isSetQueueQuota());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueueQuota()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.queueQuota, other.queueQuota);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeadLetterQueue()).compareTo(other.isSetDeadLetterQueue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeadLetterQueue()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.deadLetterQueue, other.deadLetterQueue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(libthrift091.protocol.TProtocol iprot) throws libthrift091.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(libthrift091.protocol.TProtocol oprot) throws libthrift091.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CreateQueueRequest(");
    boolean first = true;

    sb.append("queueName:");
    if (this.queueName == null) {
      sb.append("null");
    } else {
      sb.append(this.queueName);
    }
    first = false;
    if (isSetQueueAttribute()) {
      if (!first) sb.append(", ");
      sb.append("queueAttribute:");
      if (this.queueAttribute == null) {
        sb.append("null");
      } else {
        sb.append(this.queueAttribute);
      }
      first = false;
    }
    if (isSetQueueQuota()) {
      if (!first) sb.append(", ");
      sb.append("queueQuota:");
      if (this.queueQuota == null) {
        sb.append("null");
      } else {
        sb.append(this.queueQuota);
      }
      first = false;
    }
    if (isSetDeadLetterQueue()) {
      if (!first) sb.append(", ");
      sb.append("deadLetterQueue:");
      sb.append(this.deadLetterQueue);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws libthrift091.TException {
    // check for required fields
    if (queueName == null) {
      throw new libthrift091.protocol.TProtocolException("Required field 'queueName' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (queueAttribute != null) {
      queueAttribute.validate();
    }
    if (queueQuota != null) {
      queueQuota.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new libthrift091.protocol.TCompactProtocol(new libthrift091.transport.TIOStreamTransport(out)));
    } catch (libthrift091.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new libthrift091.protocol.TCompactProtocol(new libthrift091.transport.TIOStreamTransport(in)));
    } catch (libthrift091.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CreateQueueRequestStandardSchemeFactory implements SchemeFactory {
    public CreateQueueRequestStandardScheme getScheme() {
      return new CreateQueueRequestStandardScheme();
    }
  }

  private static class CreateQueueRequestStandardScheme extends StandardScheme<CreateQueueRequest> {

    public void read(libthrift091.protocol.TProtocol iprot, CreateQueueRequest struct) throws libthrift091.TException {
      libthrift091.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == libthrift091.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUEUE_NAME
            if (schemeField.type == libthrift091.protocol.TType.STRING) {
              struct.queueName = iprot.readString();
              struct.setQueueNameIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // QUEUE_ATTRIBUTE
            if (schemeField.type == libthrift091.protocol.TType.STRUCT) {
              struct.queueAttribute = new QueueAttribute();
              struct.queueAttribute.read(iprot);
              struct.setQueueAttributeIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // QUEUE_QUOTA
            if (schemeField.type == libthrift091.protocol.TType.STRUCT) {
              struct.queueQuota = new QueueQuota();
              struct.queueQuota.read(iprot);
              struct.setQueueQuotaIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DEAD_LETTER_QUEUE
            if (schemeField.type == libthrift091.protocol.TType.BOOL) {
              struct.deadLetterQueue = iprot.readBool();
              struct.setDeadLetterQueueIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(libthrift091.protocol.TProtocol oprot, CreateQueueRequest struct) throws libthrift091.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.queueName != null) {
        oprot.writeFieldBegin(QUEUE_NAME_FIELD_DESC);
        oprot.writeString(struct.queueName);
        oprot.writeFieldEnd();
      }
      if (struct.queueAttribute != null) {
        if (struct.isSetQueueAttribute()) {
          oprot.writeFieldBegin(QUEUE_ATTRIBUTE_FIELD_DESC);
          struct.queueAttribute.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.queueQuota != null) {
        if (struct.isSetQueueQuota()) {
          oprot.writeFieldBegin(QUEUE_QUOTA_FIELD_DESC);
          struct.queueQuota.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetDeadLetterQueue()) {
        oprot.writeFieldBegin(DEAD_LETTER_QUEUE_FIELD_DESC);
        oprot.writeBool(struct.deadLetterQueue);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CreateQueueRequestTupleSchemeFactory implements SchemeFactory {
    public CreateQueueRequestTupleScheme getScheme() {
      return new CreateQueueRequestTupleScheme();
    }
  }

  private static class CreateQueueRequestTupleScheme extends TupleScheme<CreateQueueRequest> {

    @Override
    public void write(libthrift091.protocol.TProtocol prot, CreateQueueRequest struct) throws libthrift091.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.queueName);
      BitSet optionals = new BitSet();
      if (struct.isSetQueueAttribute()) {
        optionals.set(0);
      }
      if (struct.isSetQueueQuota()) {
        optionals.set(1);
      }
      if (struct.isSetDeadLetterQueue()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetQueueAttribute()) {
        struct.queueAttribute.write(oprot);
      }
      if (struct.isSetQueueQuota()) {
        struct.queueQuota.write(oprot);
      }
      if (struct.isSetDeadLetterQueue()) {
        oprot.writeBool(struct.deadLetterQueue);
      }
    }

    @Override
    public void read(libthrift091.protocol.TProtocol prot, CreateQueueRequest struct) throws libthrift091.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.queueName = iprot.readString();
      struct.setQueueNameIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.queueAttribute = new QueueAttribute();
        struct.queueAttribute.read(iprot);
        struct.setQueueAttributeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.queueQuota = new QueueQuota();
        struct.queueQuota.read(iprot);
        struct.setQueueQuotaIsSet(true);
      }
      if (incoming.get(2)) {
        struct.deadLetterQueue = iprot.readBool();
        struct.setDeadLetterQueueIsSet(true);
      }
    }
  }

}

