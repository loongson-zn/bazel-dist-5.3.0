// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: build/bazel/remote/execution/v2/remote_execution.proto

package build.bazel.remote.execution.v2;

/**
 * <pre>
 * A response message for
 * [ContentAddressableStorage.GetTree][build.bazel.remote.execution.v2.ContentAddressableStorage.GetTree].
 * </pre>
 *
 * Protobuf type {@code build.bazel.remote.execution.v2.GetTreeResponse}
 */
public final class GetTreeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:build.bazel.remote.execution.v2.GetTreeResponse)
    GetTreeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetTreeResponse.newBuilder() to construct.
  private GetTreeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetTreeResponse() {
    directories_ = java.util.Collections.emptyList();
    nextPageToken_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetTreeResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetTreeResponse(
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              directories_ = new java.util.ArrayList<build.bazel.remote.execution.v2.Directory>();
              mutable_bitField0_ |= 0x00000001;
            }
            directories_.add(
                input.readMessage(build.bazel.remote.execution.v2.Directory.parser(), extensionRegistry));
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            nextPageToken_ = s;
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
        directories_ = java.util.Collections.unmodifiableList(directories_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_GetTreeResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_GetTreeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            build.bazel.remote.execution.v2.GetTreeResponse.class, build.bazel.remote.execution.v2.GetTreeResponse.Builder.class);
  }

  public static final int DIRECTORIES_FIELD_NUMBER = 1;
  private java.util.List<build.bazel.remote.execution.v2.Directory> directories_;
  /**
   * <pre>
   * The directories descended from the requested root.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
   */
  @java.lang.Override
  public java.util.List<build.bazel.remote.execution.v2.Directory> getDirectoriesList() {
    return directories_;
  }
  /**
   * <pre>
   * The directories descended from the requested root.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends build.bazel.remote.execution.v2.DirectoryOrBuilder> 
      getDirectoriesOrBuilderList() {
    return directories_;
  }
  /**
   * <pre>
   * The directories descended from the requested root.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
   */
  @java.lang.Override
  public int getDirectoriesCount() {
    return directories_.size();
  }
  /**
   * <pre>
   * The directories descended from the requested root.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
   */
  @java.lang.Override
  public build.bazel.remote.execution.v2.Directory getDirectories(int index) {
    return directories_.get(index);
  }
  /**
   * <pre>
   * The directories descended from the requested root.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
   */
  @java.lang.Override
  public build.bazel.remote.execution.v2.DirectoryOrBuilder getDirectoriesOrBuilder(
      int index) {
    return directories_.get(index);
  }

  public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
  private volatile java.lang.Object nextPageToken_;
  /**
   * <pre>
   * If present, signifies that there are more results which the client can
   * retrieve by passing this as the page_token in a subsequent
   * [request][build.bazel.remote.execution.v2.GetTreeRequest].
   * If empty, signifies that this is the last page of results.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The nextPageToken.
   */
  @java.lang.Override
  public java.lang.String getNextPageToken() {
    java.lang.Object ref = nextPageToken_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nextPageToken_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * If present, signifies that there are more results which the client can
   * retrieve by passing this as the page_token in a subsequent
   * [request][build.bazel.remote.execution.v2.GetTreeRequest].
   * If empty, signifies that this is the last page of results.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The bytes for nextPageToken.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNextPageTokenBytes() {
    java.lang.Object ref = nextPageToken_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nextPageToken_ = b;
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
    for (int i = 0; i < directories_.size(); i++) {
      output.writeMessage(1, directories_.get(i));
    }
    if (!getNextPageTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, nextPageToken_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < directories_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, directories_.get(i));
    }
    if (!getNextPageTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, nextPageToken_);
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
    if (!(obj instanceof build.bazel.remote.execution.v2.GetTreeResponse)) {
      return super.equals(obj);
    }
    build.bazel.remote.execution.v2.GetTreeResponse other = (build.bazel.remote.execution.v2.GetTreeResponse) obj;

    if (!getDirectoriesList()
        .equals(other.getDirectoriesList())) return false;
    if (!getNextPageToken()
        .equals(other.getNextPageToken())) return false;
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
    if (getDirectoriesCount() > 0) {
      hash = (37 * hash) + DIRECTORIES_FIELD_NUMBER;
      hash = (53 * hash) + getDirectoriesList().hashCode();
    }
    hash = (37 * hash) + NEXT_PAGE_TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getNextPageToken().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static build.bazel.remote.execution.v2.GetTreeResponse parseFrom(
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
  public static Builder newBuilder(build.bazel.remote.execution.v2.GetTreeResponse prototype) {
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
   * A response message for
   * [ContentAddressableStorage.GetTree][build.bazel.remote.execution.v2.ContentAddressableStorage.GetTree].
   * </pre>
   *
   * Protobuf type {@code build.bazel.remote.execution.v2.GetTreeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:build.bazel.remote.execution.v2.GetTreeResponse)
      build.bazel.remote.execution.v2.GetTreeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_GetTreeResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_GetTreeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              build.bazel.remote.execution.v2.GetTreeResponse.class, build.bazel.remote.execution.v2.GetTreeResponse.Builder.class);
    }

    // Construct using build.bazel.remote.execution.v2.GetTreeResponse.newBuilder()
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
        getDirectoriesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (directoriesBuilder_ == null) {
        directories_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        directoriesBuilder_.clear();
      }
      nextPageToken_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return build.bazel.remote.execution.v2.RemoteExecutionProto.internal_static_build_bazel_remote_execution_v2_GetTreeResponse_descriptor;
    }

    @java.lang.Override
    public build.bazel.remote.execution.v2.GetTreeResponse getDefaultInstanceForType() {
      return build.bazel.remote.execution.v2.GetTreeResponse.getDefaultInstance();
    }

    @java.lang.Override
    public build.bazel.remote.execution.v2.GetTreeResponse build() {
      build.bazel.remote.execution.v2.GetTreeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public build.bazel.remote.execution.v2.GetTreeResponse buildPartial() {
      build.bazel.remote.execution.v2.GetTreeResponse result = new build.bazel.remote.execution.v2.GetTreeResponse(this);
      int from_bitField0_ = bitField0_;
      if (directoriesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          directories_ = java.util.Collections.unmodifiableList(directories_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.directories_ = directories_;
      } else {
        result.directories_ = directoriesBuilder_.build();
      }
      result.nextPageToken_ = nextPageToken_;
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
      if (other instanceof build.bazel.remote.execution.v2.GetTreeResponse) {
        return mergeFrom((build.bazel.remote.execution.v2.GetTreeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(build.bazel.remote.execution.v2.GetTreeResponse other) {
      if (other == build.bazel.remote.execution.v2.GetTreeResponse.getDefaultInstance()) return this;
      if (directoriesBuilder_ == null) {
        if (!other.directories_.isEmpty()) {
          if (directories_.isEmpty()) {
            directories_ = other.directories_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDirectoriesIsMutable();
            directories_.addAll(other.directories_);
          }
          onChanged();
        }
      } else {
        if (!other.directories_.isEmpty()) {
          if (directoriesBuilder_.isEmpty()) {
            directoriesBuilder_.dispose();
            directoriesBuilder_ = null;
            directories_ = other.directories_;
            bitField0_ = (bitField0_ & ~0x00000001);
            directoriesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDirectoriesFieldBuilder() : null;
          } else {
            directoriesBuilder_.addAllMessages(other.directories_);
          }
        }
      }
      if (!other.getNextPageToken().isEmpty()) {
        nextPageToken_ = other.nextPageToken_;
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
      build.bazel.remote.execution.v2.GetTreeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (build.bazel.remote.execution.v2.GetTreeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<build.bazel.remote.execution.v2.Directory> directories_ =
      java.util.Collections.emptyList();
    private void ensureDirectoriesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        directories_ = new java.util.ArrayList<build.bazel.remote.execution.v2.Directory>(directories_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        build.bazel.remote.execution.v2.Directory, build.bazel.remote.execution.v2.Directory.Builder, build.bazel.remote.execution.v2.DirectoryOrBuilder> directoriesBuilder_;

    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public java.util.List<build.bazel.remote.execution.v2.Directory> getDirectoriesList() {
      if (directoriesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(directories_);
      } else {
        return directoriesBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public int getDirectoriesCount() {
      if (directoriesBuilder_ == null) {
        return directories_.size();
      } else {
        return directoriesBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public build.bazel.remote.execution.v2.Directory getDirectories(int index) {
      if (directoriesBuilder_ == null) {
        return directories_.get(index);
      } else {
        return directoriesBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder setDirectories(
        int index, build.bazel.remote.execution.v2.Directory value) {
      if (directoriesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDirectoriesIsMutable();
        directories_.set(index, value);
        onChanged();
      } else {
        directoriesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder setDirectories(
        int index, build.bazel.remote.execution.v2.Directory.Builder builderForValue) {
      if (directoriesBuilder_ == null) {
        ensureDirectoriesIsMutable();
        directories_.set(index, builderForValue.build());
        onChanged();
      } else {
        directoriesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder addDirectories(build.bazel.remote.execution.v2.Directory value) {
      if (directoriesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDirectoriesIsMutable();
        directories_.add(value);
        onChanged();
      } else {
        directoriesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder addDirectories(
        int index, build.bazel.remote.execution.v2.Directory value) {
      if (directoriesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDirectoriesIsMutable();
        directories_.add(index, value);
        onChanged();
      } else {
        directoriesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder addDirectories(
        build.bazel.remote.execution.v2.Directory.Builder builderForValue) {
      if (directoriesBuilder_ == null) {
        ensureDirectoriesIsMutable();
        directories_.add(builderForValue.build());
        onChanged();
      } else {
        directoriesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder addDirectories(
        int index, build.bazel.remote.execution.v2.Directory.Builder builderForValue) {
      if (directoriesBuilder_ == null) {
        ensureDirectoriesIsMutable();
        directories_.add(index, builderForValue.build());
        onChanged();
      } else {
        directoriesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder addAllDirectories(
        java.lang.Iterable<? extends build.bazel.remote.execution.v2.Directory> values) {
      if (directoriesBuilder_ == null) {
        ensureDirectoriesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, directories_);
        onChanged();
      } else {
        directoriesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder clearDirectories() {
      if (directoriesBuilder_ == null) {
        directories_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        directoriesBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public Builder removeDirectories(int index) {
      if (directoriesBuilder_ == null) {
        ensureDirectoriesIsMutable();
        directories_.remove(index);
        onChanged();
      } else {
        directoriesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public build.bazel.remote.execution.v2.Directory.Builder getDirectoriesBuilder(
        int index) {
      return getDirectoriesFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public build.bazel.remote.execution.v2.DirectoryOrBuilder getDirectoriesOrBuilder(
        int index) {
      if (directoriesBuilder_ == null) {
        return directories_.get(index);  } else {
        return directoriesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public java.util.List<? extends build.bazel.remote.execution.v2.DirectoryOrBuilder> 
         getDirectoriesOrBuilderList() {
      if (directoriesBuilder_ != null) {
        return directoriesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(directories_);
      }
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public build.bazel.remote.execution.v2.Directory.Builder addDirectoriesBuilder() {
      return getDirectoriesFieldBuilder().addBuilder(
          build.bazel.remote.execution.v2.Directory.getDefaultInstance());
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public build.bazel.remote.execution.v2.Directory.Builder addDirectoriesBuilder(
        int index) {
      return getDirectoriesFieldBuilder().addBuilder(
          index, build.bazel.remote.execution.v2.Directory.getDefaultInstance());
    }
    /**
     * <pre>
     * The directories descended from the requested root.
     * </pre>
     *
     * <code>repeated .build.bazel.remote.execution.v2.Directory directories = 1;</code>
     */
    public java.util.List<build.bazel.remote.execution.v2.Directory.Builder> 
         getDirectoriesBuilderList() {
      return getDirectoriesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        build.bazel.remote.execution.v2.Directory, build.bazel.remote.execution.v2.Directory.Builder, build.bazel.remote.execution.v2.DirectoryOrBuilder> 
        getDirectoriesFieldBuilder() {
      if (directoriesBuilder_ == null) {
        directoriesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            build.bazel.remote.execution.v2.Directory, build.bazel.remote.execution.v2.Directory.Builder, build.bazel.remote.execution.v2.DirectoryOrBuilder>(
                directories_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        directories_ = null;
      }
      return directoriesBuilder_;
    }

    private java.lang.Object nextPageToken_ = "";
    /**
     * <pre>
     * If present, signifies that there are more results which the client can
     * retrieve by passing this as the page_token in a subsequent
     * [request][build.bazel.remote.execution.v2.GetTreeRequest].
     * If empty, signifies that this is the last page of results.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     * @return The nextPageToken.
     */
    public java.lang.String getNextPageToken() {
      java.lang.Object ref = nextPageToken_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nextPageToken_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * If present, signifies that there are more results which the client can
     * retrieve by passing this as the page_token in a subsequent
     * [request][build.bazel.remote.execution.v2.GetTreeRequest].
     * If empty, signifies that this is the last page of results.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     * @return The bytes for nextPageToken.
     */
    public com.google.protobuf.ByteString
        getNextPageTokenBytes() {
      java.lang.Object ref = nextPageToken_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nextPageToken_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * If present, signifies that there are more results which the client can
     * retrieve by passing this as the page_token in a subsequent
     * [request][build.bazel.remote.execution.v2.GetTreeRequest].
     * If empty, signifies that this is the last page of results.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     * @param value The nextPageToken to set.
     * @return This builder for chaining.
     */
    public Builder setNextPageToken(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nextPageToken_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * If present, signifies that there are more results which the client can
     * retrieve by passing this as the page_token in a subsequent
     * [request][build.bazel.remote.execution.v2.GetTreeRequest].
     * If empty, signifies that this is the last page of results.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearNextPageToken() {
      
      nextPageToken_ = getDefaultInstance().getNextPageToken();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * If present, signifies that there are more results which the client can
     * retrieve by passing this as the page_token in a subsequent
     * [request][build.bazel.remote.execution.v2.GetTreeRequest].
     * If empty, signifies that this is the last page of results.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     * @param value The bytes for nextPageToken to set.
     * @return This builder for chaining.
     */
    public Builder setNextPageTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nextPageToken_ = value;
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


    // @@protoc_insertion_point(builder_scope:build.bazel.remote.execution.v2.GetTreeResponse)
  }

  // @@protoc_insertion_point(class_scope:build.bazel.remote.execution.v2.GetTreeResponse)
  private static final build.bazel.remote.execution.v2.GetTreeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new build.bazel.remote.execution.v2.GetTreeResponse();
  }

  public static build.bazel.remote.execution.v2.GetTreeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetTreeResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetTreeResponse>() {
    @java.lang.Override
    public GetTreeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetTreeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetTreeResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetTreeResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public build.bazel.remote.execution.v2.GetTreeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

