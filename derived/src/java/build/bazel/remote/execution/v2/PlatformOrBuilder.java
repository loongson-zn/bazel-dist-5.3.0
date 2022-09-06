// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: build/bazel/remote/execution/v2/remote_execution.proto

package build.bazel.remote.execution.v2;

public interface PlatformOrBuilder extends
    // @@protoc_insertion_point(interface_extends:build.bazel.remote.execution.v2.Platform)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The properties that make up this platform. In order to ensure that
   * equivalent `Platform`s always hash to the same value, the properties MUST
   * be lexicographically sorted by name, and then by value. Sorting of strings
   * is done by code point, equivalently, by the UTF-8 bytes.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Platform.Property properties = 1;</code>
   */
  java.util.List<build.bazel.remote.execution.v2.Platform.Property> 
      getPropertiesList();
  /**
   * <pre>
   * The properties that make up this platform. In order to ensure that
   * equivalent `Platform`s always hash to the same value, the properties MUST
   * be lexicographically sorted by name, and then by value. Sorting of strings
   * is done by code point, equivalently, by the UTF-8 bytes.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Platform.Property properties = 1;</code>
   */
  build.bazel.remote.execution.v2.Platform.Property getProperties(int index);
  /**
   * <pre>
   * The properties that make up this platform. In order to ensure that
   * equivalent `Platform`s always hash to the same value, the properties MUST
   * be lexicographically sorted by name, and then by value. Sorting of strings
   * is done by code point, equivalently, by the UTF-8 bytes.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Platform.Property properties = 1;</code>
   */
  int getPropertiesCount();
  /**
   * <pre>
   * The properties that make up this platform. In order to ensure that
   * equivalent `Platform`s always hash to the same value, the properties MUST
   * be lexicographically sorted by name, and then by value. Sorting of strings
   * is done by code point, equivalently, by the UTF-8 bytes.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Platform.Property properties = 1;</code>
   */
  java.util.List<? extends build.bazel.remote.execution.v2.Platform.PropertyOrBuilder> 
      getPropertiesOrBuilderList();
  /**
   * <pre>
   * The properties that make up this platform. In order to ensure that
   * equivalent `Platform`s always hash to the same value, the properties MUST
   * be lexicographically sorted by name, and then by value. Sorting of strings
   * is done by code point, equivalently, by the UTF-8 bytes.
   * </pre>
   *
   * <code>repeated .build.bazel.remote.execution.v2.Platform.Property properties = 1;</code>
   */
  build.bazel.remote.execution.v2.Platform.PropertyOrBuilder getPropertiesOrBuilder(
      int index);
}
