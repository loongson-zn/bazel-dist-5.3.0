// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/protobuf/extra_actions_base.proto

package com.google.devtools.build.lib.actions.extra;

public interface JavaCompileInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:blaze.JavaCompileInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string outputjar = 1;</code>
   * @return Whether the outputjar field is set.
   */
  boolean hasOutputjar();
  /**
   * <code>optional string outputjar = 1;</code>
   * @return The outputjar.
   */
  java.lang.String getOutputjar();
  /**
   * <code>optional string outputjar = 1;</code>
   * @return The bytes for outputjar.
   */
  com.google.protobuf.ByteString
      getOutputjarBytes();

  /**
   * <code>repeated string classpath = 2;</code>
   * @return A list containing the classpath.
   */
  java.util.List<java.lang.String>
      getClasspathList();
  /**
   * <code>repeated string classpath = 2;</code>
   * @return The count of classpath.
   */
  int getClasspathCount();
  /**
   * <code>repeated string classpath = 2;</code>
   * @param index The index of the element to return.
   * @return The classpath at the given index.
   */
  java.lang.String getClasspath(int index);
  /**
   * <code>repeated string classpath = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the classpath at the given index.
   */
  com.google.protobuf.ByteString
      getClasspathBytes(int index);

  /**
   * <code>repeated string sourcepath = 3;</code>
   * @return A list containing the sourcepath.
   */
  java.util.List<java.lang.String>
      getSourcepathList();
  /**
   * <code>repeated string sourcepath = 3;</code>
   * @return The count of sourcepath.
   */
  int getSourcepathCount();
  /**
   * <code>repeated string sourcepath = 3;</code>
   * @param index The index of the element to return.
   * @return The sourcepath at the given index.
   */
  java.lang.String getSourcepath(int index);
  /**
   * <code>repeated string sourcepath = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the sourcepath at the given index.
   */
  com.google.protobuf.ByteString
      getSourcepathBytes(int index);

  /**
   * <code>repeated string source_file = 4;</code>
   * @return A list containing the sourceFile.
   */
  java.util.List<java.lang.String>
      getSourceFileList();
  /**
   * <code>repeated string source_file = 4;</code>
   * @return The count of sourceFile.
   */
  int getSourceFileCount();
  /**
   * <code>repeated string source_file = 4;</code>
   * @param index The index of the element to return.
   * @return The sourceFile at the given index.
   */
  java.lang.String getSourceFile(int index);
  /**
   * <code>repeated string source_file = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the sourceFile at the given index.
   */
  com.google.protobuf.ByteString
      getSourceFileBytes(int index);

  /**
   * <code>repeated string javac_opt = 5;</code>
   * @return A list containing the javacOpt.
   */
  java.util.List<java.lang.String>
      getJavacOptList();
  /**
   * <code>repeated string javac_opt = 5;</code>
   * @return The count of javacOpt.
   */
  int getJavacOptCount();
  /**
   * <code>repeated string javac_opt = 5;</code>
   * @param index The index of the element to return.
   * @return The javacOpt at the given index.
   */
  java.lang.String getJavacOpt(int index);
  /**
   * <code>repeated string javac_opt = 5;</code>
   * @param index The index of the value to return.
   * @return The bytes of the javacOpt at the given index.
   */
  com.google.protobuf.ByteString
      getJavacOptBytes(int index);

  /**
   * <code>repeated string processor = 6;</code>
   * @return A list containing the processor.
   */
  java.util.List<java.lang.String>
      getProcessorList();
  /**
   * <code>repeated string processor = 6;</code>
   * @return The count of processor.
   */
  int getProcessorCount();
  /**
   * <code>repeated string processor = 6;</code>
   * @param index The index of the element to return.
   * @return The processor at the given index.
   */
  java.lang.String getProcessor(int index);
  /**
   * <code>repeated string processor = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the processor at the given index.
   */
  com.google.protobuf.ByteString
      getProcessorBytes(int index);

  /**
   * <code>repeated string processorpath = 7;</code>
   * @return A list containing the processorpath.
   */
  java.util.List<java.lang.String>
      getProcessorpathList();
  /**
   * <code>repeated string processorpath = 7;</code>
   * @return The count of processorpath.
   */
  int getProcessorpathCount();
  /**
   * <code>repeated string processorpath = 7;</code>
   * @param index The index of the element to return.
   * @return The processorpath at the given index.
   */
  java.lang.String getProcessorpath(int index);
  /**
   * <code>repeated string processorpath = 7;</code>
   * @param index The index of the value to return.
   * @return The bytes of the processorpath at the given index.
   */
  com.google.protobuf.ByteString
      getProcessorpathBytes(int index);

  /**
   * <code>repeated string bootclasspath = 8;</code>
   * @return A list containing the bootclasspath.
   */
  java.util.List<java.lang.String>
      getBootclasspathList();
  /**
   * <code>repeated string bootclasspath = 8;</code>
   * @return The count of bootclasspath.
   */
  int getBootclasspathCount();
  /**
   * <code>repeated string bootclasspath = 8;</code>
   * @param index The index of the element to return.
   * @return The bootclasspath at the given index.
   */
  java.lang.String getBootclasspath(int index);
  /**
   * <code>repeated string bootclasspath = 8;</code>
   * @param index The index of the value to return.
   * @return The bytes of the bootclasspath at the given index.
   */
  com.google.protobuf.ByteString
      getBootclasspathBytes(int index);

  /**
   * <code>repeated string argument = 9;</code>
   * @return A list containing the argument.
   */
  java.util.List<java.lang.String>
      getArgumentList();
  /**
   * <code>repeated string argument = 9;</code>
   * @return The count of argument.
   */
  int getArgumentCount();
  /**
   * <code>repeated string argument = 9;</code>
   * @param index The index of the element to return.
   * @return The argument at the given index.
   */
  java.lang.String getArgument(int index);
  /**
   * <code>repeated string argument = 9;</code>
   * @param index The index of the value to return.
   * @return The bytes of the argument at the given index.
   */
  com.google.protobuf.ByteString
      getArgumentBytes(int index);

  /**
   * <code>optional string system = 10;</code>
   * @return Whether the system field is set.
   */
  boolean hasSystem();
  /**
   * <code>optional string system = 10;</code>
   * @return The system.
   */
  java.lang.String getSystem();
  /**
   * <code>optional string system = 10;</code>
   * @return The bytes for system.
   */
  com.google.protobuf.ByteString
      getSystemBytes();
}
