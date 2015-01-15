/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xiaomi.infra.galaxy.sds.thrift;

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
public class AuthenticationConstants {

  /**
   * 登录方式是否支持签名
   */
  public static final Map<UserType,Boolean> SIGNATURE_SUPPORT = new HashMap<UserType,Boolean>();
  static {
    SIGNATURE_SUPPORT.put(com.xiaomi.infra.galaxy.sds.thrift.UserType.DEV_XIAOMI_SSO, false);
    SIGNATURE_SUPPORT.put(com.xiaomi.infra.galaxy.sds.thrift.UserType.DEV_XIAOMI, true);
    SIGNATURE_SUPPORT.put(com.xiaomi.infra.galaxy.sds.thrift.UserType.APP_SECRET, true);
    SIGNATURE_SUPPORT.put(com.xiaomi.infra.galaxy.sds.thrift.UserType.APP_ACCESS_TOKEN, true);
    SIGNATURE_SUPPORT.put(com.xiaomi.infra.galaxy.sds.thrift.UserType.APP_XIAOMI_SSO, false);
    SIGNATURE_SUPPORT.put(com.xiaomi.infra.galaxy.sds.thrift.UserType.APP_ANONYMOUS, false);
  }

}
