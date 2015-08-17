/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xiaomi.infra.galaxy.emr.thrift;

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-8-5")
public class JobDetail implements libthrift091.TBase<JobDetail, JobDetail._Fields>, java.io.Serializable, Cloneable, Comparable<JobDetail> {
  private static final libthrift091.protocol.TStruct STRUCT_DESC = new libthrift091.protocol.TStruct("JobDetail");

  private static final libthrift091.protocol.TField JOB_ID_FIELD_DESC = new libthrift091.protocol.TField("jobId", libthrift091.protocol.TType.STRING, (short)1);
  private static final libthrift091.protocol.TField NAME_FIELD_DESC = new libthrift091.protocol.TField("name", libthrift091.protocol.TType.STRING, (short)2);
  private static final libthrift091.protocol.TField JAR_FIELD_DESC = new libthrift091.protocol.TField("jar", libthrift091.protocol.TType.STRING, (short)3);
  private static final libthrift091.protocol.TField JAR_MAIN_CLASS_FIELD_DESC = new libthrift091.protocol.TField("jarMainClass", libthrift091.protocol.TType.STRING, (short)4);
  private static final libthrift091.protocol.TField JAR_ARGS_FIELD_DESC = new libthrift091.protocol.TField("jarArgs", libthrift091.protocol.TType.LIST, (short)5);
  private static final libthrift091.protocol.TField JAR_PROPERTIES_FIELD_DESC = new libthrift091.protocol.TField("jarProperties", libthrift091.protocol.TType.MAP, (short)6);
  private static final libthrift091.protocol.TField JOB_STATUS_FIELD_DESC = new libthrift091.protocol.TField("jobStatus", libthrift091.protocol.TType.STRUCT, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new JobDetailStandardSchemeFactory());
    schemes.put(TupleScheme.class, new JobDetailTupleSchemeFactory());
  }

  public String jobId; // required
  public String name; // optional
  public String jar; // optional
  public String jarMainClass; // optional
  public List<String> jarArgs; // optional
  public Map<String,String> jarProperties; // optional
  public Status jobStatus; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements libthrift091.TFieldIdEnum {
    JOB_ID((short)1, "jobId"),
    NAME((short)2, "name"),
    JAR((short)3, "jar"),
    JAR_MAIN_CLASS((short)4, "jarMainClass"),
    JAR_ARGS((short)5, "jarArgs"),
    JAR_PROPERTIES((short)6, "jarProperties"),
    JOB_STATUS((short)7, "jobStatus");

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
        case 1: // JOB_ID
          return JOB_ID;
        case 2: // NAME
          return NAME;
        case 3: // JAR
          return JAR;
        case 4: // JAR_MAIN_CLASS
          return JAR_MAIN_CLASS;
        case 5: // JAR_ARGS
          return JAR_ARGS;
        case 6: // JAR_PROPERTIES
          return JAR_PROPERTIES;
        case 7: // JOB_STATUS
          return JOB_STATUS;
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
  private static final _Fields optionals[] = {_Fields.NAME,_Fields.JAR,_Fields.JAR_MAIN_CLASS,_Fields.JAR_ARGS,_Fields.JAR_PROPERTIES,_Fields.JOB_STATUS};
  public static final Map<_Fields, libthrift091.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, libthrift091.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, libthrift091.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JOB_ID, new libthrift091.meta_data.FieldMetaData("jobId", libthrift091.TFieldRequirementType.REQUIRED, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME, new libthrift091.meta_data.FieldMetaData("name", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING)));
    tmpMap.put(_Fields.JAR, new libthrift091.meta_data.FieldMetaData("jar", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING)));
    tmpMap.put(_Fields.JAR_MAIN_CLASS, new libthrift091.meta_data.FieldMetaData("jarMainClass", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING)));
    tmpMap.put(_Fields.JAR_ARGS, new libthrift091.meta_data.FieldMetaData("jarArgs", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.ListMetaData(libthrift091.protocol.TType.LIST, 
            new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING))));
    tmpMap.put(_Fields.JAR_PROPERTIES, new libthrift091.meta_data.FieldMetaData("jarProperties", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.MapMetaData(libthrift091.protocol.TType.MAP, 
            new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING), 
            new libthrift091.meta_data.FieldValueMetaData(libthrift091.protocol.TType.STRING))));
    tmpMap.put(_Fields.JOB_STATUS, new libthrift091.meta_data.FieldMetaData("jobStatus", libthrift091.TFieldRequirementType.OPTIONAL, 
        new libthrift091.meta_data.StructMetaData(libthrift091.protocol.TType.STRUCT, Status.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    libthrift091.meta_data.FieldMetaData.addStructMetaDataMap(JobDetail.class, metaDataMap);
  }

  public JobDetail() {
  }

  public JobDetail(
    String jobId)
  {
    this();
    this.jobId = jobId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public JobDetail(JobDetail other) {
    if (other.isSetJobId()) {
      this.jobId = other.jobId;
    }
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetJar()) {
      this.jar = other.jar;
    }
    if (other.isSetJarMainClass()) {
      this.jarMainClass = other.jarMainClass;
    }
    if (other.isSetJarArgs()) {
      List<String> __this__jarArgs = new ArrayList<String>(other.jarArgs);
      this.jarArgs = __this__jarArgs;
    }
    if (other.isSetJarProperties()) {
      Map<String,String> __this__jarProperties = new HashMap<String,String>(other.jarProperties);
      this.jarProperties = __this__jarProperties;
    }
    if (other.isSetJobStatus()) {
      this.jobStatus = new Status(other.jobStatus);
    }
  }

  public JobDetail deepCopy() {
    return new JobDetail(this);
  }

  @Override
  public void clear() {
    this.jobId = null;
    this.name = null;
    this.jar = null;
    this.jarMainClass = null;
    this.jarArgs = null;
    this.jarProperties = null;
    this.jobStatus = null;
  }

  public String getJobId() {
    return this.jobId;
  }

  public JobDetail setJobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

  public void unsetJobId() {
    this.jobId = null;
  }

  /** Returns true if field jobId is set (has been assigned a value) and false otherwise */
  public boolean isSetJobId() {
    return this.jobId != null;
  }

  public void setJobIdIsSet(boolean value) {
    if (!value) {
      this.jobId = null;
    }
  }

  public String getName() {
    return this.name;
  }

  public JobDetail setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getJar() {
    return this.jar;
  }

  public JobDetail setJar(String jar) {
    this.jar = jar;
    return this;
  }

  public void unsetJar() {
    this.jar = null;
  }

  /** Returns true if field jar is set (has been assigned a value) and false otherwise */
  public boolean isSetJar() {
    return this.jar != null;
  }

  public void setJarIsSet(boolean value) {
    if (!value) {
      this.jar = null;
    }
  }

  public String getJarMainClass() {
    return this.jarMainClass;
  }

  public JobDetail setJarMainClass(String jarMainClass) {
    this.jarMainClass = jarMainClass;
    return this;
  }

  public void unsetJarMainClass() {
    this.jarMainClass = null;
  }

  /** Returns true if field jarMainClass is set (has been assigned a value) and false otherwise */
  public boolean isSetJarMainClass() {
    return this.jarMainClass != null;
  }

  public void setJarMainClassIsSet(boolean value) {
    if (!value) {
      this.jarMainClass = null;
    }
  }

  public int getJarArgsSize() {
    return (this.jarArgs == null) ? 0 : this.jarArgs.size();
  }

  public java.util.Iterator<String> getJarArgsIterator() {
    return (this.jarArgs == null) ? null : this.jarArgs.iterator();
  }

  public void addToJarArgs(String elem) {
    if (this.jarArgs == null) {
      this.jarArgs = new ArrayList<String>();
    }
    this.jarArgs.add(elem);
  }

  public List<String> getJarArgs() {
    return this.jarArgs;
  }

  public JobDetail setJarArgs(List<String> jarArgs) {
    this.jarArgs = jarArgs;
    return this;
  }

  public void unsetJarArgs() {
    this.jarArgs = null;
  }

  /** Returns true if field jarArgs is set (has been assigned a value) and false otherwise */
  public boolean isSetJarArgs() {
    return this.jarArgs != null;
  }

  public void setJarArgsIsSet(boolean value) {
    if (!value) {
      this.jarArgs = null;
    }
  }

  public int getJarPropertiesSize() {
    return (this.jarProperties == null) ? 0 : this.jarProperties.size();
  }

  public void putToJarProperties(String key, String val) {
    if (this.jarProperties == null) {
      this.jarProperties = new HashMap<String,String>();
    }
    this.jarProperties.put(key, val);
  }

  public Map<String,String> getJarProperties() {
    return this.jarProperties;
  }

  public JobDetail setJarProperties(Map<String,String> jarProperties) {
    this.jarProperties = jarProperties;
    return this;
  }

  public void unsetJarProperties() {
    this.jarProperties = null;
  }

  /** Returns true if field jarProperties is set (has been assigned a value) and false otherwise */
  public boolean isSetJarProperties() {
    return this.jarProperties != null;
  }

  public void setJarPropertiesIsSet(boolean value) {
    if (!value) {
      this.jarProperties = null;
    }
  }

  public Status getJobStatus() {
    return this.jobStatus;
  }

  public JobDetail setJobStatus(Status jobStatus) {
    this.jobStatus = jobStatus;
    return this;
  }

  public void unsetJobStatus() {
    this.jobStatus = null;
  }

  /** Returns true if field jobStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetJobStatus() {
    return this.jobStatus != null;
  }

  public void setJobStatusIsSet(boolean value) {
    if (!value) {
      this.jobStatus = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case JOB_ID:
      if (value == null) {
        unsetJobId();
      } else {
        setJobId((String)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case JAR:
      if (value == null) {
        unsetJar();
      } else {
        setJar((String)value);
      }
      break;

    case JAR_MAIN_CLASS:
      if (value == null) {
        unsetJarMainClass();
      } else {
        setJarMainClass((String)value);
      }
      break;

    case JAR_ARGS:
      if (value == null) {
        unsetJarArgs();
      } else {
        setJarArgs((List<String>)value);
      }
      break;

    case JAR_PROPERTIES:
      if (value == null) {
        unsetJarProperties();
      } else {
        setJarProperties((Map<String,String>)value);
      }
      break;

    case JOB_STATUS:
      if (value == null) {
        unsetJobStatus();
      } else {
        setJobStatus((Status)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case JOB_ID:
      return getJobId();

    case NAME:
      return getName();

    case JAR:
      return getJar();

    case JAR_MAIN_CLASS:
      return getJarMainClass();

    case JAR_ARGS:
      return getJarArgs();

    case JAR_PROPERTIES:
      return getJarProperties();

    case JOB_STATUS:
      return getJobStatus();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case JOB_ID:
      return isSetJobId();
    case NAME:
      return isSetName();
    case JAR:
      return isSetJar();
    case JAR_MAIN_CLASS:
      return isSetJarMainClass();
    case JAR_ARGS:
      return isSetJarArgs();
    case JAR_PROPERTIES:
      return isSetJarProperties();
    case JOB_STATUS:
      return isSetJobStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof JobDetail)
      return this.equals((JobDetail)that);
    return false;
  }

  public boolean equals(JobDetail that) {
    if (that == null)
      return false;

    boolean this_present_jobId = true && this.isSetJobId();
    boolean that_present_jobId = true && that.isSetJobId();
    if (this_present_jobId || that_present_jobId) {
      if (!(this_present_jobId && that_present_jobId))
        return false;
      if (!this.jobId.equals(that.jobId))
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_jar = true && this.isSetJar();
    boolean that_present_jar = true && that.isSetJar();
    if (this_present_jar || that_present_jar) {
      if (!(this_present_jar && that_present_jar))
        return false;
      if (!this.jar.equals(that.jar))
        return false;
    }

    boolean this_present_jarMainClass = true && this.isSetJarMainClass();
    boolean that_present_jarMainClass = true && that.isSetJarMainClass();
    if (this_present_jarMainClass || that_present_jarMainClass) {
      if (!(this_present_jarMainClass && that_present_jarMainClass))
        return false;
      if (!this.jarMainClass.equals(that.jarMainClass))
        return false;
    }

    boolean this_present_jarArgs = true && this.isSetJarArgs();
    boolean that_present_jarArgs = true && that.isSetJarArgs();
    if (this_present_jarArgs || that_present_jarArgs) {
      if (!(this_present_jarArgs && that_present_jarArgs))
        return false;
      if (!this.jarArgs.equals(that.jarArgs))
        return false;
    }

    boolean this_present_jarProperties = true && this.isSetJarProperties();
    boolean that_present_jarProperties = true && that.isSetJarProperties();
    if (this_present_jarProperties || that_present_jarProperties) {
      if (!(this_present_jarProperties && that_present_jarProperties))
        return false;
      if (!this.jarProperties.equals(that.jarProperties))
        return false;
    }

    boolean this_present_jobStatus = true && this.isSetJobStatus();
    boolean that_present_jobStatus = true && that.isSetJobStatus();
    if (this_present_jobStatus || that_present_jobStatus) {
      if (!(this_present_jobStatus && that_present_jobStatus))
        return false;
      if (!this.jobStatus.equals(that.jobStatus))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_jobId = true && (isSetJobId());
    list.add(present_jobId);
    if (present_jobId)
      list.add(jobId);

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_jar = true && (isSetJar());
    list.add(present_jar);
    if (present_jar)
      list.add(jar);

    boolean present_jarMainClass = true && (isSetJarMainClass());
    list.add(present_jarMainClass);
    if (present_jarMainClass)
      list.add(jarMainClass);

    boolean present_jarArgs = true && (isSetJarArgs());
    list.add(present_jarArgs);
    if (present_jarArgs)
      list.add(jarArgs);

    boolean present_jarProperties = true && (isSetJarProperties());
    list.add(present_jarProperties);
    if (present_jarProperties)
      list.add(jarProperties);

    boolean present_jobStatus = true && (isSetJobStatus());
    list.add(present_jobStatus);
    if (present_jobStatus)
      list.add(jobStatus);

    return list.hashCode();
  }

  @Override
  public int compareTo(JobDetail other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetJobId()).compareTo(other.isSetJobId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJobId()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.jobId, other.jobId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJar()).compareTo(other.isSetJar());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJar()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.jar, other.jar);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJarMainClass()).compareTo(other.isSetJarMainClass());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJarMainClass()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.jarMainClass, other.jarMainClass);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJarArgs()).compareTo(other.isSetJarArgs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJarArgs()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.jarArgs, other.jarArgs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJarProperties()).compareTo(other.isSetJarProperties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJarProperties()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.jarProperties, other.jarProperties);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJobStatus()).compareTo(other.isSetJobStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJobStatus()) {
      lastComparison = libthrift091.TBaseHelper.compareTo(this.jobStatus, other.jobStatus);
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
    StringBuilder sb = new StringBuilder("JobDetail(");
    boolean first = true;

    sb.append("jobId:");
    if (this.jobId == null) {
      sb.append("null");
    } else {
      sb.append(this.jobId);
    }
    first = false;
    if (isSetName()) {
      if (!first) sb.append(", ");
      sb.append("name:");
      if (this.name == null) {
        sb.append("null");
      } else {
        sb.append(this.name);
      }
      first = false;
    }
    if (isSetJar()) {
      if (!first) sb.append(", ");
      sb.append("jar:");
      if (this.jar == null) {
        sb.append("null");
      } else {
        sb.append(this.jar);
      }
      first = false;
    }
    if (isSetJarMainClass()) {
      if (!first) sb.append(", ");
      sb.append("jarMainClass:");
      if (this.jarMainClass == null) {
        sb.append("null");
      } else {
        sb.append(this.jarMainClass);
      }
      first = false;
    }
    if (isSetJarArgs()) {
      if (!first) sb.append(", ");
      sb.append("jarArgs:");
      if (this.jarArgs == null) {
        sb.append("null");
      } else {
        sb.append(this.jarArgs);
      }
      first = false;
    }
    if (isSetJarProperties()) {
      if (!first) sb.append(", ");
      sb.append("jarProperties:");
      if (this.jarProperties == null) {
        sb.append("null");
      } else {
        sb.append(this.jarProperties);
      }
      first = false;
    }
    if (isSetJobStatus()) {
      if (!first) sb.append(", ");
      sb.append("jobStatus:");
      if (this.jobStatus == null) {
        sb.append("null");
      } else {
        sb.append(this.jobStatus);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws libthrift091.TException {
    // check for required fields
    if (jobId == null) {
      throw new libthrift091.protocol.TProtocolException("Required field 'jobId' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (jobStatus != null) {
      jobStatus.validate();
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
      read(new libthrift091.protocol.TCompactProtocol(new libthrift091.transport.TIOStreamTransport(in)));
    } catch (libthrift091.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class JobDetailStandardSchemeFactory implements SchemeFactory {
    public JobDetailStandardScheme getScheme() {
      return new JobDetailStandardScheme();
    }
  }

  private static class JobDetailStandardScheme extends StandardScheme<JobDetail> {

    public void read(libthrift091.protocol.TProtocol iprot, JobDetail struct) throws libthrift091.TException {
      libthrift091.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == libthrift091.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // JOB_ID
            if (schemeField.type == libthrift091.protocol.TType.STRING) {
              struct.jobId = iprot.readString();
              struct.setJobIdIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == libthrift091.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // JAR
            if (schemeField.type == libthrift091.protocol.TType.STRING) {
              struct.jar = iprot.readString();
              struct.setJarIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // JAR_MAIN_CLASS
            if (schemeField.type == libthrift091.protocol.TType.STRING) {
              struct.jarMainClass = iprot.readString();
              struct.setJarMainClassIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // JAR_ARGS
            if (schemeField.type == libthrift091.protocol.TType.LIST) {
              {
                libthrift091.protocol.TList _list66 = iprot.readListBegin();
                struct.jarArgs = new ArrayList<String>(_list66.size);
                String _elem67;
                for (int _i68 = 0; _i68 < _list66.size; ++_i68)
                {
                  _elem67 = iprot.readString();
                  struct.jarArgs.add(_elem67);
                }
                iprot.readListEnd();
              }
              struct.setJarArgsIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // JAR_PROPERTIES
            if (schemeField.type == libthrift091.protocol.TType.MAP) {
              {
                libthrift091.protocol.TMap _map69 = iprot.readMapBegin();
                struct.jarProperties = new HashMap<String,String>(2*_map69.size);
                String _key70;
                String _val71;
                for (int _i72 = 0; _i72 < _map69.size; ++_i72)
                {
                  _key70 = iprot.readString();
                  _val71 = iprot.readString();
                  struct.jarProperties.put(_key70, _val71);
                }
                iprot.readMapEnd();
              }
              struct.setJarPropertiesIsSet(true);
            } else { 
              libthrift091.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // JOB_STATUS
            if (schemeField.type == libthrift091.protocol.TType.STRUCT) {
              struct.jobStatus = new Status();
              struct.jobStatus.read(iprot);
              struct.setJobStatusIsSet(true);
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

    public void write(libthrift091.protocol.TProtocol oprot, JobDetail struct) throws libthrift091.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.jobId != null) {
        oprot.writeFieldBegin(JOB_ID_FIELD_DESC);
        oprot.writeString(struct.jobId);
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        if (struct.isSetName()) {
          oprot.writeFieldBegin(NAME_FIELD_DESC);
          oprot.writeString(struct.name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jar != null) {
        if (struct.isSetJar()) {
          oprot.writeFieldBegin(JAR_FIELD_DESC);
          oprot.writeString(struct.jar);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jarMainClass != null) {
        if (struct.isSetJarMainClass()) {
          oprot.writeFieldBegin(JAR_MAIN_CLASS_FIELD_DESC);
          oprot.writeString(struct.jarMainClass);
          oprot.writeFieldEnd();
        }
      }
      if (struct.jarArgs != null) {
        if (struct.isSetJarArgs()) {
          oprot.writeFieldBegin(JAR_ARGS_FIELD_DESC);
          {
            oprot.writeListBegin(new libthrift091.protocol.TList(libthrift091.protocol.TType.STRING, struct.jarArgs.size()));
            for (String _iter73 : struct.jarArgs)
            {
              oprot.writeString(_iter73);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.jarProperties != null) {
        if (struct.isSetJarProperties()) {
          oprot.writeFieldBegin(JAR_PROPERTIES_FIELD_DESC);
          {
            oprot.writeMapBegin(new libthrift091.protocol.TMap(libthrift091.protocol.TType.STRING, libthrift091.protocol.TType.STRING, struct.jarProperties.size()));
            for (Map.Entry<String, String> _iter74 : struct.jarProperties.entrySet())
            {
              oprot.writeString(_iter74.getKey());
              oprot.writeString(_iter74.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.jobStatus != null) {
        if (struct.isSetJobStatus()) {
          oprot.writeFieldBegin(JOB_STATUS_FIELD_DESC);
          struct.jobStatus.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class JobDetailTupleSchemeFactory implements SchemeFactory {
    public JobDetailTupleScheme getScheme() {
      return new JobDetailTupleScheme();
    }
  }

  private static class JobDetailTupleScheme extends TupleScheme<JobDetail> {

    @Override
    public void write(libthrift091.protocol.TProtocol prot, JobDetail struct) throws libthrift091.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.jobId);
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetJar()) {
        optionals.set(1);
      }
      if (struct.isSetJarMainClass()) {
        optionals.set(2);
      }
      if (struct.isSetJarArgs()) {
        optionals.set(3);
      }
      if (struct.isSetJarProperties()) {
        optionals.set(4);
      }
      if (struct.isSetJobStatus()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetJar()) {
        oprot.writeString(struct.jar);
      }
      if (struct.isSetJarMainClass()) {
        oprot.writeString(struct.jarMainClass);
      }
      if (struct.isSetJarArgs()) {
        {
          oprot.writeI32(struct.jarArgs.size());
          for (String _iter75 : struct.jarArgs)
          {
            oprot.writeString(_iter75);
          }
        }
      }
      if (struct.isSetJarProperties()) {
        {
          oprot.writeI32(struct.jarProperties.size());
          for (Map.Entry<String, String> _iter76 : struct.jarProperties.entrySet())
          {
            oprot.writeString(_iter76.getKey());
            oprot.writeString(_iter76.getValue());
          }
        }
      }
      if (struct.isSetJobStatus()) {
        struct.jobStatus.write(oprot);
      }
    }

    @Override
    public void read(libthrift091.protocol.TProtocol prot, JobDetail struct) throws libthrift091.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.jobId = iprot.readString();
      struct.setJobIdIsSet(true);
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.jar = iprot.readString();
        struct.setJarIsSet(true);
      }
      if (incoming.get(2)) {
        struct.jarMainClass = iprot.readString();
        struct.setJarMainClassIsSet(true);
      }
      if (incoming.get(3)) {
        {
          libthrift091.protocol.TList _list77 = new libthrift091.protocol.TList(libthrift091.protocol.TType.STRING, iprot.readI32());
          struct.jarArgs = new ArrayList<String>(_list77.size);
          String _elem78;
          for (int _i79 = 0; _i79 < _list77.size; ++_i79)
          {
            _elem78 = iprot.readString();
            struct.jarArgs.add(_elem78);
          }
        }
        struct.setJarArgsIsSet(true);
      }
      if (incoming.get(4)) {
        {
          libthrift091.protocol.TMap _map80 = new libthrift091.protocol.TMap(libthrift091.protocol.TType.STRING, libthrift091.protocol.TType.STRING, iprot.readI32());
          struct.jarProperties = new HashMap<String,String>(2*_map80.size);
          String _key81;
          String _val82;
          for (int _i83 = 0; _i83 < _map80.size; ++_i83)
          {
            _key81 = iprot.readString();
            _val82 = iprot.readString();
            struct.jarProperties.put(_key81, _val82);
          }
        }
        struct.setJarPropertiesIsSet(true);
      }
      if (incoming.get(5)) {
        struct.jobStatus = new Status();
        struct.jobStatus.read(iprot);
        struct.setJobStatusIsSet(true);
      }
    }
  }

}
