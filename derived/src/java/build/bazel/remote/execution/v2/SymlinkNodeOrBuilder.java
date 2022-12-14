// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: build/bazel/remote/execution/v2/remote_execution.proto

package build.bazel.remote.execution.v2;

public interface SymlinkNodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:build.bazel.remote.execution.v2.SymlinkNode)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The name of the symlink.
   * </pre>
   *
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * The name of the symlink.
   * </pre>
   *
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * The target path of the symlink. The path separator is a forward slash `/`.
   * The target path can be relative to the parent directory of the symlink or
   * it can be an absolute path starting with `/`. Support for absolute paths
   * can be checked using the [Capabilities][build.bazel.remote.execution.v2.Capabilities]
   * API. `..` components are allowed anywhere in the target path as logical
   * canonicalization may lead to different behavior in the presence of
   * directory symlinks (e.g. `foo/../bar` may not be the same as `bar`).
   * To reduce potential cache misses, canonicalization is still recommended
   * where this is possible without impacting correctness.
   * </pre>
   *
   * <code>string target = 2;</code>
   * @return The target.
   */
  java.lang.String getTarget();
  /**
   * <pre>
   * The target path of the symlink. The path separator is a forward slash `/`.
   * The target path can be relative to the parent directory of the symlink or
   * it can be an absolute path starting with `/`. Support for absolute paths
   * can be checked using the [Capabilities][build.bazel.remote.execution.v2.Capabilities]
   * API. `..` components are allowed anywhere in the target path as logical
   * canonicalization may lead to different behavior in the presence of
   * directory symlinks (e.g. `foo/../bar` may not be the same as `bar`).
   * To reduce potential cache misses, canonicalization is still recommended
   * where this is possible without impacting correctness.
   * </pre>
   *
   * <code>string target = 2;</code>
   * @return The bytes for target.
   */
  com.google.protobuf.ByteString
      getTargetBytes();

  /**
   * <code>.build.bazel.remote.execution.v2.NodeProperties node_properties = 4;</code>
   * @return Whether the nodeProperties field is set.
   */
  boolean hasNodeProperties();
  /**
   * <code>.build.bazel.remote.execution.v2.NodeProperties node_properties = 4;</code>
   * @return The nodeProperties.
   */
  build.bazel.remote.execution.v2.NodeProperties getNodeProperties();
  /**
   * <code>.build.bazel.remote.execution.v2.NodeProperties node_properties = 4;</code>
   */
  build.bazel.remote.execution.v2.NodePropertiesOrBuilder getNodePropertiesOrBuilder();
}
