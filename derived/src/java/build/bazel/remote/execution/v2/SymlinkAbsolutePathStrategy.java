// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: build/bazel/remote/execution/v2/remote_execution.proto

package build.bazel.remote.execution.v2;

/**
 * <pre>
 * Describes how the server treats absolute symlink targets.
 * </pre>
 *
 * Protobuf type {@code build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy}
 */
public final class SymlinkAbsolutePathStrategy extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy)
    SymlinkAbsolutePathStrategyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SymlinkAbsolutePathStrategy.newBuilder() to construct.
  private SymlinkAbsolutePathStrategy(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SymlinkAbsolutePathStrategy() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SymlinkAbsolutePathStrategy();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SymlinkAbsolutePathStrategy(
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
    return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_SymlinkAbsolutePathStrategy_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_SymlinkAbsolutePathStrategy_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.class, build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.Builder.class);
  }

  /**
   * Protobuf enum {@code build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.Value}
   */
  public enum Value
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * Invalid value.
     * </pre>
     *
     * <code>UNKNOWN = 0;</code>
     */
    UNKNOWN(0),
    /**
     * <pre>
     * Server will return an `INVALID_ARGUMENT` on input symlinks with absolute
     * targets.
     * If an action tries to create an output symlink with an absolute target, a
     * `FAILED_PRECONDITION` will be returned.
     * </pre>
     *
     * <code>DISALLOWED = 1;</code>
     */
    DISALLOWED(1),
    /**
     * <pre>
     * Server will allow symlink targets to escape the input root tree, possibly
     * resulting in non-hermetic builds.
     * </pre>
     *
     * <code>ALLOWED = 2;</code>
     */
    ALLOWED(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     * Invalid value.
     * </pre>
     *
     * <code>UNKNOWN = 0;</code>
     */
    public static final int UNKNOWN_VALUE = 0;
    /**
     * <pre>
     * Server will return an `INVALID_ARGUMENT` on input symlinks with absolute
     * targets.
     * If an action tries to create an output symlink with an absolute target, a
     * `FAILED_PRECONDITION` will be returned.
     * </pre>
     *
     * <code>DISALLOWED = 1;</code>
     */
    public static final int DISALLOWED_VALUE = 1;
    /**
     * <pre>
     * Server will allow symlink targets to escape the input root tree, possibly
     * resulting in non-hermetic builds.
     * </pre>
     *
     * <code>ALLOWED = 2;</code>
     */
    public static final int ALLOWED_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Value valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Value forNumber(int value) {
      switch (value) {
        case 0: return UNKNOWN;
        case 1: return DISALLOWED;
        case 2: return ALLOWED;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Value>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Value> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Value>() {
            public Value findValueByNumber(int number) {
              return Value.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.getDescriptor().getEnumTypes().get(0);
    }

    private static final Value[] VALUES = values();

    public static Value valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Value(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.Value)
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
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy)) {
      return super.equals(obj);
    }
    build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy other = (build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy) obj;

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
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parseFrom(
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
  public static Builder newBuilder(build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy prototype) {
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
   * Describes how the server treats absolute symlink targets.
   * </pre>
   *
   * Protobuf type {@code build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy)
      build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_SymlinkAbsolutePathStrategy_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_SymlinkAbsolutePathStrategy_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.class, build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.Builder.class);
    }

    // Construct using build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.newBuilder()
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
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_SymlinkAbsolutePathStrategy_descriptor;
    }

    @java.lang.Override
    public build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy getDefaultInstanceForType() {
      return build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.getDefaultInstance();
    }

    @java.lang.Override
    public build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy build() {
      build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy buildPartial() {
      build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy result = new build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy(this);
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
      if (other instanceof build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy) {
        return mergeFrom((build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy other) {
      if (other == build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy.getDefaultInstance()) return this;
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
      build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
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


    // @@protoc_insertion_point(builder_scope:build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy)
  }

  // @@protoc_insertion_point(class_scope:build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy)
  private static final build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy();
  }

  public static build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SymlinkAbsolutePathStrategy>
      PARSER = new com.google.protobuf.AbstractParser<SymlinkAbsolutePathStrategy>() {
    @java.lang.Override
    public SymlinkAbsolutePathStrategy parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SymlinkAbsolutePathStrategy(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SymlinkAbsolutePathStrategy> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SymlinkAbsolutePathStrategy> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public build.bazel.remote.execution.v2.SymlinkAbsolutePathStrategy getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

