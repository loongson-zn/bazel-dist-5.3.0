// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/protobuf/extra_actions_base.proto

package com.google.devtools.build.lib.actions.extra;

public interface ExtraActionInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:blaze.ExtraActionInfo)
    com.google.protobuf.GeneratedMessageV3.
        ExtendableMessageOrBuilder<ExtraActionInfo> {

  /**
   * <pre>
   * The label of the ActionOwner of the shadowed action.
   * </pre>
   *
   * <code>optional string owner = 1;</code>
   * @return Whether the owner field is set.
   */
  boolean hasOwner();
  /**
   * <pre>
   * The label of the ActionOwner of the shadowed action.
   * </pre>
   *
   * <code>optional string owner = 1;</code>
   * @return The owner.
   */
  java.lang.String getOwner();
  /**
   * <pre>
   * The label of the ActionOwner of the shadowed action.
   * </pre>
   *
   * <code>optional string owner = 1;</code>
   * @return The bytes for owner.
   */
  com.google.protobuf.ByteString
      getOwnerBytes();

  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getAspectClass.getName()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * This is the aspect name of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>optional string aspect_name = 6 [deprecated = true];</code>
   * @return Whether the aspectName field is set.
   */
  @java.lang.Deprecated boolean hasAspectName();
  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getAspectClass.getName()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * This is the aspect name of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>optional string aspect_name = 6 [deprecated = true];</code>
   * @return The aspectName.
   */
  @java.lang.Deprecated java.lang.String getAspectName();
  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getAspectClass.getName()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * This is the aspect name of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>optional string aspect_name = 6 [deprecated = true];</code>
   * @return The bytes for aspectName.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getAspectNameBytes();

  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getParameters()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * These are the aspect parameters of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>map&lt;string, .blaze.ExtraActionInfo.StringList&gt; aspect_parameters = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated int getAspectParametersCount();
  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getParameters()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * These are the aspect parameters of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>map&lt;string, .blaze.ExtraActionInfo.StringList&gt; aspect_parameters = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated boolean containsAspectParameters(
      java.lang.String key);
  /**
   * Use {@link #getAspectParametersMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.devtools.build.lib.actions.extra.ExtraActionInfo.StringList>
  getAspectParameters();
  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getParameters()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * These are the aspect parameters of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>map&lt;string, .blaze.ExtraActionInfo.StringList&gt; aspect_parameters = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated java.util.Map<java.lang.String, com.google.devtools.build.lib.actions.extra.ExtraActionInfo.StringList>
  getAspectParametersMap();
  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getParameters()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * These are the aspect parameters of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>map&lt;string, .blaze.ExtraActionInfo.StringList&gt; aspect_parameters = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated 
  com.google.devtools.build.lib.actions.extra.ExtraActionInfo.StringList getAspectParametersOrDefault(
      java.lang.String key,
      com.google.devtools.build.lib.actions.extra.ExtraActionInfo.StringList defaultValue);
  /**
   * <pre>
   * Only set if the owner is an Aspect.
   * Corresponds to AspectValue.AspectKey.getParameters()
   * This field is deprecated as there might now be
   * multiple aspects applied to the same target.
   * These are the aspect parameters of the last aspect
   * in 'aspects' (8) field.
   * </pre>
   *
   * <code>map&lt;string, .blaze.ExtraActionInfo.StringList&gt; aspect_parameters = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated 
  com.google.devtools.build.lib.actions.extra.ExtraActionInfo.StringList getAspectParametersOrThrow(
      java.lang.String key);

  /**
   * <pre>
   * If the owner is an aspect, all aspects applied to the target
   * </pre>
   *
   * <code>repeated .blaze.ExtraActionInfo.AspectDescriptor aspects = 8;</code>
   */
  java.util.List<com.google.devtools.build.lib.actions.extra.ExtraActionInfo.AspectDescriptor> 
      getAspectsList();
  /**
   * <pre>
   * If the owner is an aspect, all aspects applied to the target
   * </pre>
   *
   * <code>repeated .blaze.ExtraActionInfo.AspectDescriptor aspects = 8;</code>
   */
  com.google.devtools.build.lib.actions.extra.ExtraActionInfo.AspectDescriptor getAspects(int index);
  /**
   * <pre>
   * If the owner is an aspect, all aspects applied to the target
   * </pre>
   *
   * <code>repeated .blaze.ExtraActionInfo.AspectDescriptor aspects = 8;</code>
   */
  int getAspectsCount();
  /**
   * <pre>
   * If the owner is an aspect, all aspects applied to the target
   * </pre>
   *
   * <code>repeated .blaze.ExtraActionInfo.AspectDescriptor aspects = 8;</code>
   */
  java.util.List<? extends com.google.devtools.build.lib.actions.extra.ExtraActionInfo.AspectDescriptorOrBuilder> 
      getAspectsOrBuilderList();
  /**
   * <pre>
   * If the owner is an aspect, all aspects applied to the target
   * </pre>
   *
   * <code>repeated .blaze.ExtraActionInfo.AspectDescriptor aspects = 8;</code>
   */
  com.google.devtools.build.lib.actions.extra.ExtraActionInfo.AspectDescriptorOrBuilder getAspectsOrBuilder(
      int index);

  /**
   * <pre>
   * An id uniquely describing the shadowed action at the ActionOwner level.
   * </pre>
   *
   * <code>optional string id = 2;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <pre>
   * An id uniquely describing the shadowed action at the ActionOwner level.
   * </pre>
   *
   * <code>optional string id = 2;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <pre>
   * An id uniquely describing the shadowed action at the ActionOwner level.
   * </pre>
   *
   * <code>optional string id = 2;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   * The mnemonic of the shadowed action. Used to distinguish actions with the
   * same ActionType.
   * </pre>
   *
   * <code>optional string mnemonic = 5;</code>
   * @return Whether the mnemonic field is set.
   */
  boolean hasMnemonic();
  /**
   * <pre>
   * The mnemonic of the shadowed action. Used to distinguish actions with the
   * same ActionType.
   * </pre>
   *
   * <code>optional string mnemonic = 5;</code>
   * @return The mnemonic.
   */
  java.lang.String getMnemonic();
  /**
   * <pre>
   * The mnemonic of the shadowed action. Used to distinguish actions with the
   * same ActionType.
   * </pre>
   *
   * <code>optional string mnemonic = 5;</code>
   * @return The bytes for mnemonic.
   */
  com.google.protobuf.ByteString
      getMnemonicBytes();
}
