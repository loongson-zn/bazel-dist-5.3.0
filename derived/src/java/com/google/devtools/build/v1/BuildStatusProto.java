// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/devtools/build/v1/build_status.proto

package com.google.devtools.build.v1;

public final class BuildStatusProto {
  private BuildStatusProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_devtools_build_v1_BuildStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_devtools_build_v1_BuildStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n+google/devtools/build/v1/build_status." +
      "proto\022\030google.devtools.build.v1\032\034google/" +
      "api/annotations.proto\032\031google/protobuf/a" +
      "ny.proto\"\306\002\n\013BuildStatus\022<\n\006result\030\001 \001(\016" +
      "2,.google.devtools.build.v1.BuildStatus." +
      "Result\022%\n\007details\030\002 \001(\0132\024.google.protobu" +
      "f.Any\"\321\001\n\006Result\022\022\n\016UNKNOWN_STATUS\020\000\022\025\n\021" +
      "COMMAND_SUCCEEDED\020\001\022\022\n\016COMMAND_FAILED\020\002\022" +
      "\016\n\nUSER_ERROR\020\003\022\020\n\014SYSTEM_ERROR\020\004\022\026\n\022RES" +
      "OURCE_EXHAUSTED\020\005\022 \n\034INVOCATION_DEADLINE" +
      "_EXCEEDED\020\006\022\035\n\031REQUEST_DEADLINE_EXCEEDED" +
      "\020\010\022\r\n\tCANCELLED\020\007Bt\n\034com.google.devtools" +
      ".build.v1B\020BuildStatusProtoP\001Z=google.go" +
      "lang.org/genproto/googleapis/devtools/bu" +
      "ild/v1;build\370\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.protobuf.AnyProto.getDescriptor(),
        });
    internal_static_google_devtools_build_v1_BuildStatus_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_devtools_build_v1_BuildStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_devtools_build_v1_BuildStatus_descriptor,
        new java.lang.String[] { "Result", "Details", });
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.protobuf.AnyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
