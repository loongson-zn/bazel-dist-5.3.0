// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/devtools/remoteexecution/v1test/remote_execution.proto

package com.google.devtools.remoteexecution.v1test;

/**
 * <pre>
 * A request message for
 * [ActionCache.GetActionResult][google.devtools.remoteexecution.v1test.ActionCache.GetActionResult].
 * </pre>
 *
 * Protobuf type {@code google.devtools.remoteexecution.v1test.GetActionResultRequest}
 */
public final class GetActionResultRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.devtools.remoteexecution.v1test.GetActionResultRequest)
    GetActionResultRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetActionResultRequest.newBuilder() to construct.
  private GetActionResultRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetActionResultRequest() {
    instanceName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetActionResultRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetActionResultRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            java.lang.String s = input.readStringRequireUtf8();

            instanceName_ = s;
            break;
          }
          case 18: {
            com.google.devtools.remoteexecution.v1test.Digest.Builder subBuilder = null;
            if (actionDigest_ != null) {
              subBuilder = actionDigest_.toBuilder();
            }
            actionDigest_ = input.readMessage(com.google.devtools.remoteexecution.v1test.Digest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(actionDigest_);
              actionDigest_ = subBuilder.buildPartial();
            }

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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_GetActionResultRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_GetActionResultRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.devtools.remoteexecution.v1test.GetActionResultRequest.class, com.google.devtools.remoteexecution.v1test.GetActionResultRequest.Builder.class);
  }

  public static final int INSTANCE_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object instanceName_;
  /**
   * <pre>
   * The instance of the execution system to operate against. A server may
   * support multiple instances of the execution system (with their own workers,
   * storage, caches, etc.). The server MAY require use of this field to select
   * between them in an implementation-defined fashion, otherwise it can be
   * omitted.
   * </pre>
   *
   * <code>string instance_name = 1;</code>
   * @return The instanceName.
   */
  @java.lang.Override
  public java.lang.String getInstanceName() {
    java.lang.Object ref = instanceName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      instanceName_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The instance of the execution system to operate against. A server may
   * support multiple instances of the execution system (with their own workers,
   * storage, caches, etc.). The server MAY require use of this field to select
   * between them in an implementation-defined fashion, otherwise it can be
   * omitted.
   * </pre>
   *
   * <code>string instance_name = 1;</code>
   * @return The bytes for instanceName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getInstanceNameBytes() {
    java.lang.Object ref = instanceName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      instanceName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACTION_DIGEST_FIELD_NUMBER = 2;
  private com.google.devtools.remoteexecution.v1test.Digest actionDigest_;
  /**
   * <pre>
   * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
   * whose result is requested.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
   * @return Whether the actionDigest field is set.
   */
  @java.lang.Override
  public boolean hasActionDigest() {
    return actionDigest_ != null;
  }
  /**
   * <pre>
   * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
   * whose result is requested.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
   * @return The actionDigest.
   */
  @java.lang.Override
  public com.google.devtools.remoteexecution.v1test.Digest getActionDigest() {
    return actionDigest_ == null ? com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : actionDigest_;
  }
  /**
   * <pre>
   * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
   * whose result is requested.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
   */
  @java.lang.Override
  public com.google.devtools.remoteexecution.v1test.DigestOrBuilder getActionDigestOrBuilder() {
    return getActionDigest();
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
    if (!getInstanceNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, instanceName_);
    }
    if (actionDigest_ != null) {
      output.writeMessage(2, getActionDigest());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getInstanceNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, instanceName_);
    }
    if (actionDigest_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getActionDigest());
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
    if (!(obj instanceof com.google.devtools.remoteexecution.v1test.GetActionResultRequest)) {
      return super.equals(obj);
    }
    com.google.devtools.remoteexecution.v1test.GetActionResultRequest other = (com.google.devtools.remoteexecution.v1test.GetActionResultRequest) obj;

    if (!getInstanceName()
        .equals(other.getInstanceName())) return false;
    if (hasActionDigest() != other.hasActionDigest()) return false;
    if (hasActionDigest()) {
      if (!getActionDigest()
          .equals(other.getActionDigest())) return false;
    }
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
    hash = (37 * hash) + INSTANCE_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getInstanceName().hashCode();
    if (hasActionDigest()) {
      hash = (37 * hash) + ACTION_DIGEST_FIELD_NUMBER;
      hash = (53 * hash) + getActionDigest().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest parseFrom(
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
  public static Builder newBuilder(com.google.devtools.remoteexecution.v1test.GetActionResultRequest prototype) {
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
   * <pre>
   * A request message for
   * [ActionCache.GetActionResult][google.devtools.remoteexecution.v1test.ActionCache.GetActionResult].
   * </pre>
   *
   * Protobuf type {@code google.devtools.remoteexecution.v1test.GetActionResultRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.devtools.remoteexecution.v1test.GetActionResultRequest)
      com.google.devtools.remoteexecution.v1test.GetActionResultRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_GetActionResultRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_GetActionResultRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.devtools.remoteexecution.v1test.GetActionResultRequest.class, com.google.devtools.remoteexecution.v1test.GetActionResultRequest.Builder.class);
    }

    // Construct using com.google.devtools.remoteexecution.v1test.GetActionResultRequest.newBuilder()
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
      instanceName_ = "";

      if (actionDigestBuilder_ == null) {
        actionDigest_ = null;
      } else {
        actionDigest_ = null;
        actionDigestBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_GetActionResultRequest_descriptor;
    }

    @java.lang.Override
    public com.google.devtools.remoteexecution.v1test.GetActionResultRequest getDefaultInstanceForType() {
      return com.google.devtools.remoteexecution.v1test.GetActionResultRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.devtools.remoteexecution.v1test.GetActionResultRequest build() {
      com.google.devtools.remoteexecution.v1test.GetActionResultRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.devtools.remoteexecution.v1test.GetActionResultRequest buildPartial() {
      com.google.devtools.remoteexecution.v1test.GetActionResultRequest result = new com.google.devtools.remoteexecution.v1test.GetActionResultRequest(this);
      result.instanceName_ = instanceName_;
      if (actionDigestBuilder_ == null) {
        result.actionDigest_ = actionDigest_;
      } else {
        result.actionDigest_ = actionDigestBuilder_.build();
      }
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
      if (other instanceof com.google.devtools.remoteexecution.v1test.GetActionResultRequest) {
        return mergeFrom((com.google.devtools.remoteexecution.v1test.GetActionResultRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.devtools.remoteexecution.v1test.GetActionResultRequest other) {
      if (other == com.google.devtools.remoteexecution.v1test.GetActionResultRequest.getDefaultInstance()) return this;
      if (!other.getInstanceName().isEmpty()) {
        instanceName_ = other.instanceName_;
        onChanged();
      }
      if (other.hasActionDigest()) {
        mergeActionDigest(other.getActionDigest());
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
      com.google.devtools.remoteexecution.v1test.GetActionResultRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.devtools.remoteexecution.v1test.GetActionResultRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object instanceName_ = "";
    /**
     * <pre>
     * The instance of the execution system to operate against. A server may
     * support multiple instances of the execution system (with their own workers,
     * storage, caches, etc.). The server MAY require use of this field to select
     * between them in an implementation-defined fashion, otherwise it can be
     * omitted.
     * </pre>
     *
     * <code>string instance_name = 1;</code>
     * @return The instanceName.
     */
    public java.lang.String getInstanceName() {
      java.lang.Object ref = instanceName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        instanceName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The instance of the execution system to operate against. A server may
     * support multiple instances of the execution system (with their own workers,
     * storage, caches, etc.). The server MAY require use of this field to select
     * between them in an implementation-defined fashion, otherwise it can be
     * omitted.
     * </pre>
     *
     * <code>string instance_name = 1;</code>
     * @return The bytes for instanceName.
     */
    public com.google.protobuf.ByteString
        getInstanceNameBytes() {
      java.lang.Object ref = instanceName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        instanceName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The instance of the execution system to operate against. A server may
     * support multiple instances of the execution system (with their own workers,
     * storage, caches, etc.). The server MAY require use of this field to select
     * between them in an implementation-defined fashion, otherwise it can be
     * omitted.
     * </pre>
     *
     * <code>string instance_name = 1;</code>
     * @param value The instanceName to set.
     * @return This builder for chaining.
     */
    public Builder setInstanceName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      instanceName_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The instance of the execution system to operate against. A server may
     * support multiple instances of the execution system (with their own workers,
     * storage, caches, etc.). The server MAY require use of this field to select
     * between them in an implementation-defined fashion, otherwise it can be
     * omitted.
     * </pre>
     *
     * <code>string instance_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearInstanceName() {
      
      instanceName_ = getDefaultInstance().getInstanceName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The instance of the execution system to operate against. A server may
     * support multiple instances of the execution system (with their own workers,
     * storage, caches, etc.). The server MAY require use of this field to select
     * between them in an implementation-defined fashion, otherwise it can be
     * omitted.
     * </pre>
     *
     * <code>string instance_name = 1;</code>
     * @param value The bytes for instanceName to set.
     * @return This builder for chaining.
     */
    public Builder setInstanceNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      instanceName_ = value;
      onChanged();
      return this;
    }

    private com.google.devtools.remoteexecution.v1test.Digest actionDigest_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder> actionDigestBuilder_;
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     * @return Whether the actionDigest field is set.
     */
    public boolean hasActionDigest() {
      return actionDigestBuilder_ != null || actionDigest_ != null;
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     * @return The actionDigest.
     */
    public com.google.devtools.remoteexecution.v1test.Digest getActionDigest() {
      if (actionDigestBuilder_ == null) {
        return actionDigest_ == null ? com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : actionDigest_;
      } else {
        return actionDigestBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     */
    public Builder setActionDigest(com.google.devtools.remoteexecution.v1test.Digest value) {
      if (actionDigestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        actionDigest_ = value;
        onChanged();
      } else {
        actionDigestBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     */
    public Builder setActionDigest(
        com.google.devtools.remoteexecution.v1test.Digest.Builder builderForValue) {
      if (actionDigestBuilder_ == null) {
        actionDigest_ = builderForValue.build();
        onChanged();
      } else {
        actionDigestBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     */
    public Builder mergeActionDigest(com.google.devtools.remoteexecution.v1test.Digest value) {
      if (actionDigestBuilder_ == null) {
        if (actionDigest_ != null) {
          actionDigest_ =
            com.google.devtools.remoteexecution.v1test.Digest.newBuilder(actionDigest_).mergeFrom(value).buildPartial();
        } else {
          actionDigest_ = value;
        }
        onChanged();
      } else {
        actionDigestBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     */
    public Builder clearActionDigest() {
      if (actionDigestBuilder_ == null) {
        actionDigest_ = null;
        onChanged();
      } else {
        actionDigest_ = null;
        actionDigestBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     */
    public com.google.devtools.remoteexecution.v1test.Digest.Builder getActionDigestBuilder() {
      
      onChanged();
      return getActionDigestFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     */
    public com.google.devtools.remoteexecution.v1test.DigestOrBuilder getActionDigestOrBuilder() {
      if (actionDigestBuilder_ != null) {
        return actionDigestBuilder_.getMessageOrBuilder();
      } else {
        return actionDigest_ == null ?
            com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : actionDigest_;
      }
    }
    /**
     * <pre>
     * The digest of the [Action][google.devtools.remoteexecution.v1test.Action]
     * whose result is requested.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest action_digest = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder> 
        getActionDigestFieldBuilder() {
      if (actionDigestBuilder_ == null) {
        actionDigestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder>(
                getActionDigest(),
                getParentForChildren(),
                isClean());
        actionDigest_ = null;
      }
      return actionDigestBuilder_;
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


    // @@protoc_insertion_point(builder_scope:google.devtools.remoteexecution.v1test.GetActionResultRequest)
  }

  // @@protoc_insertion_point(class_scope:google.devtools.remoteexecution.v1test.GetActionResultRequest)
  private static final com.google.devtools.remoteexecution.v1test.GetActionResultRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.devtools.remoteexecution.v1test.GetActionResultRequest();
  }

  public static com.google.devtools.remoteexecution.v1test.GetActionResultRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetActionResultRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetActionResultRequest>() {
    @java.lang.Override
    public GetActionResultRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetActionResultRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetActionResultRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetActionResultRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.devtools.remoteexecution.v1test.GetActionResultRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

