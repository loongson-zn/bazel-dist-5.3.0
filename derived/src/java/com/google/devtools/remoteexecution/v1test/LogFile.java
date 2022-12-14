// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/devtools/remoteexecution/v1test/remote_execution.proto

package com.google.devtools.remoteexecution.v1test;

/**
 * <pre>
 * A `LogFile` is a log stored in the CAS.
 * </pre>
 *
 * Protobuf type {@code google.devtools.remoteexecution.v1test.LogFile}
 */
public final class LogFile extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.devtools.remoteexecution.v1test.LogFile)
    LogFileOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LogFile.newBuilder() to construct.
  private LogFile(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LogFile() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new LogFile();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LogFile(
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
            com.google.devtools.remoteexecution.v1test.Digest.Builder subBuilder = null;
            if (digest_ != null) {
              subBuilder = digest_.toBuilder();
            }
            digest_ = input.readMessage(com.google.devtools.remoteexecution.v1test.Digest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(digest_);
              digest_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            humanReadable_ = input.readBool();
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
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_LogFile_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_LogFile_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.devtools.remoteexecution.v1test.LogFile.class, com.google.devtools.remoteexecution.v1test.LogFile.Builder.class);
  }

  public static final int DIGEST_FIELD_NUMBER = 1;
  private com.google.devtools.remoteexecution.v1test.Digest digest_;
  /**
   * <pre>
   * The digest of the log contents.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
   * @return Whether the digest field is set.
   */
  @java.lang.Override
  public boolean hasDigest() {
    return digest_ != null;
  }
  /**
   * <pre>
   * The digest of the log contents.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
   * @return The digest.
   */
  @java.lang.Override
  public com.google.devtools.remoteexecution.v1test.Digest getDigest() {
    return digest_ == null ? com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : digest_;
  }
  /**
   * <pre>
   * The digest of the log contents.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
   */
  @java.lang.Override
  public com.google.devtools.remoteexecution.v1test.DigestOrBuilder getDigestOrBuilder() {
    return getDigest();
  }

  public static final int HUMAN_READABLE_FIELD_NUMBER = 2;
  private boolean humanReadable_;
  /**
   * <pre>
   * This is a hint as to the purpose of the log, and is set to true if the log
   * is human-readable text that can be usefully displayed to a user, and false
   * otherwise. For instance, if a command-line client wishes to print the
   * server logs to the terminal for a failed action, this allows it to avoid
   * displaying a binary file.
   * </pre>
   *
   * <code>bool human_readable = 2;</code>
   * @return The humanReadable.
   */
  @java.lang.Override
  public boolean getHumanReadable() {
    return humanReadable_;
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
    if (digest_ != null) {
      output.writeMessage(1, getDigest());
    }
    if (humanReadable_ != false) {
      output.writeBool(2, humanReadable_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (digest_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getDigest());
    }
    if (humanReadable_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, humanReadable_);
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
    if (!(obj instanceof com.google.devtools.remoteexecution.v1test.LogFile)) {
      return super.equals(obj);
    }
    com.google.devtools.remoteexecution.v1test.LogFile other = (com.google.devtools.remoteexecution.v1test.LogFile) obj;

    if (hasDigest() != other.hasDigest()) return false;
    if (hasDigest()) {
      if (!getDigest()
          .equals(other.getDigest())) return false;
    }
    if (getHumanReadable()
        != other.getHumanReadable()) return false;
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
    if (hasDigest()) {
      hash = (37 * hash) + DIGEST_FIELD_NUMBER;
      hash = (53 * hash) + getDigest().hashCode();
    }
    hash = (37 * hash) + HUMAN_READABLE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getHumanReadable());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.LogFile parseFrom(
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
  public static Builder newBuilder(com.google.devtools.remoteexecution.v1test.LogFile prototype) {
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
   * A `LogFile` is a log stored in the CAS.
   * </pre>
   *
   * Protobuf type {@code google.devtools.remoteexecution.v1test.LogFile}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.devtools.remoteexecution.v1test.LogFile)
      com.google.devtools.remoteexecution.v1test.LogFileOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_LogFile_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_LogFile_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.devtools.remoteexecution.v1test.LogFile.class, com.google.devtools.remoteexecution.v1test.LogFile.Builder.class);
    }

    // Construct using com.google.devtools.remoteexecution.v1test.LogFile.newBuilder()
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
      if (digestBuilder_ == null) {
        digest_ = null;
      } else {
        digest_ = null;
        digestBuilder_ = null;
      }
      humanReadable_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_LogFile_descriptor;
    }

    @java.lang.Override
    public com.google.devtools.remoteexecution.v1test.LogFile getDefaultInstanceForType() {
      return com.google.devtools.remoteexecution.v1test.LogFile.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.devtools.remoteexecution.v1test.LogFile build() {
      com.google.devtools.remoteexecution.v1test.LogFile result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.devtools.remoteexecution.v1test.LogFile buildPartial() {
      com.google.devtools.remoteexecution.v1test.LogFile result = new com.google.devtools.remoteexecution.v1test.LogFile(this);
      if (digestBuilder_ == null) {
        result.digest_ = digest_;
      } else {
        result.digest_ = digestBuilder_.build();
      }
      result.humanReadable_ = humanReadable_;
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
      if (other instanceof com.google.devtools.remoteexecution.v1test.LogFile) {
        return mergeFrom((com.google.devtools.remoteexecution.v1test.LogFile)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.devtools.remoteexecution.v1test.LogFile other) {
      if (other == com.google.devtools.remoteexecution.v1test.LogFile.getDefaultInstance()) return this;
      if (other.hasDigest()) {
        mergeDigest(other.getDigest());
      }
      if (other.getHumanReadable() != false) {
        setHumanReadable(other.getHumanReadable());
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
      com.google.devtools.remoteexecution.v1test.LogFile parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.devtools.remoteexecution.v1test.LogFile) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.devtools.remoteexecution.v1test.Digest digest_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder> digestBuilder_;
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     * @return Whether the digest field is set.
     */
    public boolean hasDigest() {
      return digestBuilder_ != null || digest_ != null;
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     * @return The digest.
     */
    public com.google.devtools.remoteexecution.v1test.Digest getDigest() {
      if (digestBuilder_ == null) {
        return digest_ == null ? com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : digest_;
      } else {
        return digestBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     */
    public Builder setDigest(com.google.devtools.remoteexecution.v1test.Digest value) {
      if (digestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        digest_ = value;
        onChanged();
      } else {
        digestBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     */
    public Builder setDigest(
        com.google.devtools.remoteexecution.v1test.Digest.Builder builderForValue) {
      if (digestBuilder_ == null) {
        digest_ = builderForValue.build();
        onChanged();
      } else {
        digestBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     */
    public Builder mergeDigest(com.google.devtools.remoteexecution.v1test.Digest value) {
      if (digestBuilder_ == null) {
        if (digest_ != null) {
          digest_ =
            com.google.devtools.remoteexecution.v1test.Digest.newBuilder(digest_).mergeFrom(value).buildPartial();
        } else {
          digest_ = value;
        }
        onChanged();
      } else {
        digestBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     */
    public Builder clearDigest() {
      if (digestBuilder_ == null) {
        digest_ = null;
        onChanged();
      } else {
        digest_ = null;
        digestBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.Digest.Builder getDigestBuilder() {
      
      onChanged();
      return getDigestFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.DigestOrBuilder getDigestOrBuilder() {
      if (digestBuilder_ != null) {
        return digestBuilder_.getMessageOrBuilder();
      } else {
        return digest_ == null ?
            com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : digest_;
      }
    }
    /**
     * <pre>
     * The digest of the log contents.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest digest = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder> 
        getDigestFieldBuilder() {
      if (digestBuilder_ == null) {
        digestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder>(
                getDigest(),
                getParentForChildren(),
                isClean());
        digest_ = null;
      }
      return digestBuilder_;
    }

    private boolean humanReadable_ ;
    /**
     * <pre>
     * This is a hint as to the purpose of the log, and is set to true if the log
     * is human-readable text that can be usefully displayed to a user, and false
     * otherwise. For instance, if a command-line client wishes to print the
     * server logs to the terminal for a failed action, this allows it to avoid
     * displaying a binary file.
     * </pre>
     *
     * <code>bool human_readable = 2;</code>
     * @return The humanReadable.
     */
    @java.lang.Override
    public boolean getHumanReadable() {
      return humanReadable_;
    }
    /**
     * <pre>
     * This is a hint as to the purpose of the log, and is set to true if the log
     * is human-readable text that can be usefully displayed to a user, and false
     * otherwise. For instance, if a command-line client wishes to print the
     * server logs to the terminal for a failed action, this allows it to avoid
     * displaying a binary file.
     * </pre>
     *
     * <code>bool human_readable = 2;</code>
     * @param value The humanReadable to set.
     * @return This builder for chaining.
     */
    public Builder setHumanReadable(boolean value) {
      
      humanReadable_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * This is a hint as to the purpose of the log, and is set to true if the log
     * is human-readable text that can be usefully displayed to a user, and false
     * otherwise. For instance, if a command-line client wishes to print the
     * server logs to the terminal for a failed action, this allows it to avoid
     * displaying a binary file.
     * </pre>
     *
     * <code>bool human_readable = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearHumanReadable() {
      
      humanReadable_ = false;
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


    // @@protoc_insertion_point(builder_scope:google.devtools.remoteexecution.v1test.LogFile)
  }

  // @@protoc_insertion_point(class_scope:google.devtools.remoteexecution.v1test.LogFile)
  private static final com.google.devtools.remoteexecution.v1test.LogFile DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.devtools.remoteexecution.v1test.LogFile();
  }

  public static com.google.devtools.remoteexecution.v1test.LogFile getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogFile>
      PARSER = new com.google.protobuf.AbstractParser<LogFile>() {
    @java.lang.Override
    public LogFile parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LogFile(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LogFile> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LogFile> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.devtools.remoteexecution.v1test.LogFile getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

