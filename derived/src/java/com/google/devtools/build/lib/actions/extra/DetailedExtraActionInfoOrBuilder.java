// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/protobuf/extra_actions_base.proto

package com.google.devtools.build.lib.actions.extra;

public interface DetailedExtraActionInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:blaze.DetailedExtraActionInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * If the given action was included in the output due to a request for a
   * specific file, then this field contains the name of that file so that the
   * caller can correctly associate the extra action with that file.
   * The data in this message is currently not sufficient to run the action on a
   * production machine, because not all necessary input files are identified,
   * especially for C++.
   * There is no easy way to fix this; we could require that all header files
   * are declared and then add all of them here (which would be a huge superset
   * of the files that are actually required), or we could run the include
   * scanner and add those files here.
   * </pre>
   *
   * <code>optional string triggering_file = 1;</code>
   * @return Whether the triggeringFile field is set.
   */
  boolean hasTriggeringFile();
  /**
   * <pre>
   * If the given action was included in the output due to a request for a
   * specific file, then this field contains the name of that file so that the
   * caller can correctly associate the extra action with that file.
   * The data in this message is currently not sufficient to run the action on a
   * production machine, because not all necessary input files are identified,
   * especially for C++.
   * There is no easy way to fix this; we could require that all header files
   * are declared and then add all of them here (which would be a huge superset
   * of the files that are actually required), or we could run the include
   * scanner and add those files here.
   * </pre>
   *
   * <code>optional string triggering_file = 1;</code>
   * @return The triggeringFile.
   */
  java.lang.String getTriggeringFile();
  /**
   * <pre>
   * If the given action was included in the output due to a request for a
   * specific file, then this field contains the name of that file so that the
   * caller can correctly associate the extra action with that file.
   * The data in this message is currently not sufficient to run the action on a
   * production machine, because not all necessary input files are identified,
   * especially for C++.
   * There is no easy way to fix this; we could require that all header files
   * are declared and then add all of them here (which would be a huge superset
   * of the files that are actually required), or we could run the include
   * scanner and add those files here.
   * </pre>
   *
   * <code>optional string triggering_file = 1;</code>
   * @return The bytes for triggeringFile.
   */
  com.google.protobuf.ByteString
      getTriggeringFileBytes();

  /**
   * <pre>
   * The actual action.
   * </pre>
   *
   * <code>required .blaze.ExtraActionInfo action = 2;</code>
   * @return Whether the action field is set.
   */
  boolean hasAction();
  /**
   * <pre>
   * The actual action.
   * </pre>
   *
   * <code>required .blaze.ExtraActionInfo action = 2;</code>
   * @return The action.
   */
  com.google.devtools.build.lib.actions.extra.ExtraActionInfo getAction();
  /**
   * <pre>
   * The actual action.
   * </pre>
   *
   * <code>required .blaze.ExtraActionInfo action = 2;</code>
   */
  com.google.devtools.build.lib.actions.extra.ExtraActionInfoOrBuilder getActionOrBuilder();
}
