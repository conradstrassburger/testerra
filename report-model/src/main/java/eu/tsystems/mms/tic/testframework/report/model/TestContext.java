// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

/**
 * Protobuf type {@code data.TestContext}
 */
public  final class TestContext extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:data.TestContext)
    TestContextOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TestContext.newBuilder() to construct.
  private TestContext(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TestContext() {
    classContextIds_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    suiteContextId_ = "";
    executionContextId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TestContext();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TestContext(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            eu.tsystems.mms.tic.testframework.report.model.ContextValues.Builder subBuilder = null;
            if (contextValues_ != null) {
              subBuilder = contextValues_.toBuilder();
            }
            contextValues_ = input.readMessage(eu.tsystems.mms.tic.testframework.report.model.ContextValues.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(contextValues_);
              contextValues_ = subBuilder.buildPartial();
            }

            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              classContextIds_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            classContextIds_.add(s);
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();

            suiteContextId_ = s;
            break;
          }
          case 66: {
            java.lang.String s = input.readStringRequireUtf8();

            executionContextId_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        classContextIds_ = classContextIds_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_TestContext_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_TestContext_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            eu.tsystems.mms.tic.testframework.report.model.TestContext.class, eu.tsystems.mms.tic.testframework.report.model.TestContext.Builder.class);
  }

  public static final int CONTEXT_VALUES_FIELD_NUMBER = 1;
  private eu.tsystems.mms.tic.testframework.report.model.ContextValues contextValues_;
  /**
   * <code>.data.ContextValues context_values = 1;</code>
   * @return Whether the contextValues field is set.
   */
  public boolean hasContextValues() {
    return contextValues_ != null;
  }
  /**
   * <code>.data.ContextValues context_values = 1;</code>
   * @return The contextValues.
   */
  public eu.tsystems.mms.tic.testframework.report.model.ContextValues getContextValues() {
    return contextValues_ == null ? eu.tsystems.mms.tic.testframework.report.model.ContextValues.getDefaultInstance() : contextValues_;
  }
  /**
   * <code>.data.ContextValues context_values = 1;</code>
   */
  public eu.tsystems.mms.tic.testframework.report.model.ContextValuesOrBuilder getContextValuesOrBuilder() {
    return getContextValues();
  }

  public static final int CLASS_CONTEXT_IDS_FIELD_NUMBER = 6;
  private com.google.protobuf.LazyStringList classContextIds_;
  /**
   * <code>repeated string class_context_ids = 6;</code>
   * @return A list containing the classContextIds.
   */
  public com.google.protobuf.ProtocolStringList
      getClassContextIdsList() {
    return classContextIds_;
  }
  /**
   * <code>repeated string class_context_ids = 6;</code>
   * @return The count of classContextIds.
   */
  public int getClassContextIdsCount() {
    return classContextIds_.size();
  }
  /**
   * <code>repeated string class_context_ids = 6;</code>
   * @param index The index of the element to return.
   * @return The classContextIds at the given index.
   */
  public java.lang.String getClassContextIds(int index) {
    return classContextIds_.get(index);
  }
  /**
   * <code>repeated string class_context_ids = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the classContextIds at the given index.
   */
  public com.google.protobuf.ByteString
      getClassContextIdsBytes(int index) {
    return classContextIds_.getByteString(index);
  }

  public static final int SUITE_CONTEXT_ID_FIELD_NUMBER = 7;
  private volatile java.lang.Object suiteContextId_;
  /**
   * <code>string suite_context_id = 7;</code>
   * @return The suiteContextId.
   */
  public java.lang.String getSuiteContextId() {
    java.lang.Object ref = suiteContextId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      suiteContextId_ = s;
      return s;
    }
  }
  /**
   * <code>string suite_context_id = 7;</code>
   * @return The bytes for suiteContextId.
   */
  public com.google.protobuf.ByteString
      getSuiteContextIdBytes() {
    java.lang.Object ref = suiteContextId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      suiteContextId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EXECUTION_CONTEXT_ID_FIELD_NUMBER = 8;
  private volatile java.lang.Object executionContextId_;
  /**
   * <code>string execution_context_id = 8;</code>
   * @return The executionContextId.
   */
  public java.lang.String getExecutionContextId() {
    java.lang.Object ref = executionContextId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      executionContextId_ = s;
      return s;
    }
  }
  /**
   * <code>string execution_context_id = 8;</code>
   * @return The bytes for executionContextId.
   */
  public com.google.protobuf.ByteString
      getExecutionContextIdBytes() {
    java.lang.Object ref = executionContextId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      executionContextId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (contextValues_ != null) {
      output.writeMessage(1, getContextValues());
    }
    for (int i = 0; i < classContextIds_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, classContextIds_.getRaw(i));
    }
    if (!getSuiteContextIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, suiteContextId_);
    }
    if (!getExecutionContextIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 8, executionContextId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (contextValues_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getContextValues());
    }
    {
      int dataSize = 0;
      for (int i = 0; i < classContextIds_.size(); i++) {
        dataSize += computeStringSizeNoTag(classContextIds_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getClassContextIdsList().size();
    }
    if (!getSuiteContextIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, suiteContextId_);
    }
    if (!getExecutionContextIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, executionContextId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof eu.tsystems.mms.tic.testframework.report.model.TestContext)) {
      return super.equals(obj);
    }
    eu.tsystems.mms.tic.testframework.report.model.TestContext other = (eu.tsystems.mms.tic.testframework.report.model.TestContext) obj;

    if (hasContextValues() != other.hasContextValues()) return false;
    if (hasContextValues()) {
      if (!getContextValues()
          .equals(other.getContextValues())) return false;
    }
    if (!getClassContextIdsList()
        .equals(other.getClassContextIdsList())) return false;
    if (!getSuiteContextId()
        .equals(other.getSuiteContextId())) return false;
    if (!getExecutionContextId()
        .equals(other.getExecutionContextId())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasContextValues()) {
      hash = (37 * hash) + CONTEXT_VALUES_FIELD_NUMBER;
      hash = (53 * hash) + getContextValues().hashCode();
    }
    if (getClassContextIdsCount() > 0) {
      hash = (37 * hash) + CLASS_CONTEXT_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getClassContextIdsList().hashCode();
    }
    hash = (37 * hash) + SUITE_CONTEXT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSuiteContextId().hashCode();
    hash = (37 * hash) + EXECUTION_CONTEXT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getExecutionContextId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.TestContext parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(eu.tsystems.mms.tic.testframework.report.model.TestContext prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code data.TestContext}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:data.TestContext)
      eu.tsystems.mms.tic.testframework.report.model.TestContextOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_TestContext_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_TestContext_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              eu.tsystems.mms.tic.testframework.report.model.TestContext.class, eu.tsystems.mms.tic.testframework.report.model.TestContext.Builder.class);
    }

    // Construct using eu.tsystems.mms.tic.testframework.report.model.TestContext.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (contextValuesBuilder_ == null) {
        contextValues_ = null;
      } else {
        contextValues_ = null;
        contextValuesBuilder_ = null;
      }
      classContextIds_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      suiteContextId_ = "";

      executionContextId_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_TestContext_descriptor;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.TestContext getDefaultInstanceForType() {
      return eu.tsystems.mms.tic.testframework.report.model.TestContext.getDefaultInstance();
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.TestContext build() {
      eu.tsystems.mms.tic.testframework.report.model.TestContext result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.TestContext buildPartial() {
      eu.tsystems.mms.tic.testframework.report.model.TestContext result = new eu.tsystems.mms.tic.testframework.report.model.TestContext(this);
      int from_bitField0_ = bitField0_;
      if (contextValuesBuilder_ == null) {
        result.contextValues_ = contextValues_;
      } else {
        result.contextValues_ = contextValuesBuilder_.build();
      }
      if (((bitField0_ & 0x00000001) != 0)) {
        classContextIds_ = classContextIds_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.classContextIds_ = classContextIds_;
      result.suiteContextId_ = suiteContextId_;
      result.executionContextId_ = executionContextId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof eu.tsystems.mms.tic.testframework.report.model.TestContext) {
        return mergeFrom((eu.tsystems.mms.tic.testframework.report.model.TestContext)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(eu.tsystems.mms.tic.testframework.report.model.TestContext other) {
      if (other == eu.tsystems.mms.tic.testframework.report.model.TestContext.getDefaultInstance()) return this;
      if (other.hasContextValues()) {
        mergeContextValues(other.getContextValues());
      }
      if (!other.classContextIds_.isEmpty()) {
        if (classContextIds_.isEmpty()) {
          classContextIds_ = other.classContextIds_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureClassContextIdsIsMutable();
          classContextIds_.addAll(other.classContextIds_);
        }
        onChanged();
      }
      if (!other.getSuiteContextId().isEmpty()) {
        suiteContextId_ = other.suiteContextId_;
        onChanged();
      }
      if (!other.getExecutionContextId().isEmpty()) {
        executionContextId_ = other.executionContextId_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      eu.tsystems.mms.tic.testframework.report.model.TestContext parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (eu.tsystems.mms.tic.testframework.report.model.TestContext) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private eu.tsystems.mms.tic.testframework.report.model.ContextValues contextValues_;
    private com.google.protobuf.SingleFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.ContextValues, eu.tsystems.mms.tic.testframework.report.model.ContextValues.Builder, eu.tsystems.mms.tic.testframework.report.model.ContextValuesOrBuilder> contextValuesBuilder_;
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     * @return Whether the contextValues field is set.
     */
    public boolean hasContextValues() {
      return contextValuesBuilder_ != null || contextValues_ != null;
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     * @return The contextValues.
     */
    public eu.tsystems.mms.tic.testframework.report.model.ContextValues getContextValues() {
      if (contextValuesBuilder_ == null) {
        return contextValues_ == null ? eu.tsystems.mms.tic.testframework.report.model.ContextValues.getDefaultInstance() : contextValues_;
      } else {
        return contextValuesBuilder_.getMessage();
      }
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     */
    public Builder setContextValues(eu.tsystems.mms.tic.testframework.report.model.ContextValues value) {
      if (contextValuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        contextValues_ = value;
        onChanged();
      } else {
        contextValuesBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     */
    public Builder setContextValues(
        eu.tsystems.mms.tic.testframework.report.model.ContextValues.Builder builderForValue) {
      if (contextValuesBuilder_ == null) {
        contextValues_ = builderForValue.build();
        onChanged();
      } else {
        contextValuesBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     */
    public Builder mergeContextValues(eu.tsystems.mms.tic.testframework.report.model.ContextValues value) {
      if (contextValuesBuilder_ == null) {
        if (contextValues_ != null) {
          contextValues_ =
            eu.tsystems.mms.tic.testframework.report.model.ContextValues.newBuilder(contextValues_).mergeFrom(value).buildPartial();
        } else {
          contextValues_ = value;
        }
        onChanged();
      } else {
        contextValuesBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     */
    public Builder clearContextValues() {
      if (contextValuesBuilder_ == null) {
        contextValues_ = null;
        onChanged();
      } else {
        contextValues_ = null;
        contextValuesBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.ContextValues.Builder getContextValuesBuilder() {
      
      onChanged();
      return getContextValuesFieldBuilder().getBuilder();
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.ContextValuesOrBuilder getContextValuesOrBuilder() {
      if (contextValuesBuilder_ != null) {
        return contextValuesBuilder_.getMessageOrBuilder();
      } else {
        return contextValues_ == null ?
            eu.tsystems.mms.tic.testframework.report.model.ContextValues.getDefaultInstance() : contextValues_;
      }
    }
    /**
     * <code>.data.ContextValues context_values = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.ContextValues, eu.tsystems.mms.tic.testframework.report.model.ContextValues.Builder, eu.tsystems.mms.tic.testframework.report.model.ContextValuesOrBuilder> 
        getContextValuesFieldBuilder() {
      if (contextValuesBuilder_ == null) {
        contextValuesBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            eu.tsystems.mms.tic.testframework.report.model.ContextValues, eu.tsystems.mms.tic.testframework.report.model.ContextValues.Builder, eu.tsystems.mms.tic.testframework.report.model.ContextValuesOrBuilder>(
                getContextValues(),
                getParentForChildren(),
                isClean());
        contextValues_ = null;
      }
      return contextValuesBuilder_;
    }

    private com.google.protobuf.LazyStringList classContextIds_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureClassContextIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        classContextIds_ = new com.google.protobuf.LazyStringArrayList(classContextIds_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @return A list containing the classContextIds.
     */
    public com.google.protobuf.ProtocolStringList
        getClassContextIdsList() {
      return classContextIds_.getUnmodifiableView();
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @return The count of classContextIds.
     */
    public int getClassContextIdsCount() {
      return classContextIds_.size();
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @param index The index of the element to return.
     * @return The classContextIds at the given index.
     */
    public java.lang.String getClassContextIds(int index) {
      return classContextIds_.get(index);
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @param index The index of the value to return.
     * @return The bytes of the classContextIds at the given index.
     */
    public com.google.protobuf.ByteString
        getClassContextIdsBytes(int index) {
      return classContextIds_.getByteString(index);
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @param index The index to set the value at.
     * @param value The classContextIds to set.
     * @return This builder for chaining.
     */
    public Builder setClassContextIds(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureClassContextIdsIsMutable();
      classContextIds_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @param value The classContextIds to add.
     * @return This builder for chaining.
     */
    public Builder addClassContextIds(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureClassContextIdsIsMutable();
      classContextIds_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @param values The classContextIds to add.
     * @return This builder for chaining.
     */
    public Builder addAllClassContextIds(
        java.lang.Iterable<java.lang.String> values) {
      ensureClassContextIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, classContextIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearClassContextIds() {
      classContextIds_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string class_context_ids = 6;</code>
     * @param value The bytes of the classContextIds to add.
     * @return This builder for chaining.
     */
    public Builder addClassContextIdsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureClassContextIdsIsMutable();
      classContextIds_.add(value);
      onChanged();
      return this;
    }

    private java.lang.Object suiteContextId_ = "";
    /**
     * <code>string suite_context_id = 7;</code>
     * @return The suiteContextId.
     */
    public java.lang.String getSuiteContextId() {
      java.lang.Object ref = suiteContextId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        suiteContextId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string suite_context_id = 7;</code>
     * @return The bytes for suiteContextId.
     */
    public com.google.protobuf.ByteString
        getSuiteContextIdBytes() {
      java.lang.Object ref = suiteContextId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        suiteContextId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string suite_context_id = 7;</code>
     * @param value The suiteContextId to set.
     * @return This builder for chaining.
     */
    public Builder setSuiteContextId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      suiteContextId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string suite_context_id = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearSuiteContextId() {
      
      suiteContextId_ = getDefaultInstance().getSuiteContextId();
      onChanged();
      return this;
    }
    /**
     * <code>string suite_context_id = 7;</code>
     * @param value The bytes for suiteContextId to set.
     * @return This builder for chaining.
     */
    public Builder setSuiteContextIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      suiteContextId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object executionContextId_ = "";
    /**
     * <code>string execution_context_id = 8;</code>
     * @return The executionContextId.
     */
    public java.lang.String getExecutionContextId() {
      java.lang.Object ref = executionContextId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        executionContextId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string execution_context_id = 8;</code>
     * @return The bytes for executionContextId.
     */
    public com.google.protobuf.ByteString
        getExecutionContextIdBytes() {
      java.lang.Object ref = executionContextId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        executionContextId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string execution_context_id = 8;</code>
     * @param value The executionContextId to set.
     * @return This builder for chaining.
     */
    public Builder setExecutionContextId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      executionContextId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string execution_context_id = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearExecutionContextId() {
      
      executionContextId_ = getDefaultInstance().getExecutionContextId();
      onChanged();
      return this;
    }
    /**
     * <code>string execution_context_id = 8;</code>
     * @param value The bytes for executionContextId to set.
     * @return This builder for chaining.
     */
    public Builder setExecutionContextIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      executionContextId_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:data.TestContext)
  }

  // @@protoc_insertion_point(class_scope:data.TestContext)
  private static final eu.tsystems.mms.tic.testframework.report.model.TestContext DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new eu.tsystems.mms.tic.testframework.report.model.TestContext();
  }

  public static eu.tsystems.mms.tic.testframework.report.model.TestContext getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TestContext>
      PARSER = new com.google.protobuf.AbstractParser<TestContext>() {
    @java.lang.Override
    public TestContext parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TestContext(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TestContext> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TestContext> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public eu.tsystems.mms.tic.testframework.report.model.TestContext getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
