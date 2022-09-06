// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/devtools/remoteexecution/v1test/remote_execution.proto

package com.google.devtools.remoteexecution.v1test;

public interface TreeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.devtools.remoteexecution.v1test.Tree)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The root directory in the tree.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Directory root = 1;</code>
   * @return Whether the root field is set.
   */
  boolean hasRoot();
  /**
   * <pre>
   * The root directory in the tree.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Directory root = 1;</code>
   * @return The root.
   */
  com.google.devtools.remoteexecution.v1test.Directory getRoot();
  /**
   * <pre>
   * The root directory in the tree.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Directory root = 1;</code>
   */
  com.google.devtools.remoteexecution.v1test.DirectoryOrBuilder getRootOrBuilder();

  /**
   * <pre>
   * All the child directories: the directories referred to by the root and,
   * recursively, all its children. In order to reconstruct the directory tree,
   * the client must take the digests of each of the child directories and then
   * build up a tree starting from the `root`.
   * </pre>
   *
   * <code>repeated .google.devtools.remoteexecution.v1test.Directory children = 2;</code>
   */
  java.util.List<com.google.devtools.remoteexecution.v1test.Directory> 
      getChildrenList();
  /**
   * <pre>
   * All the child directories: the directories referred to by the root and,
   * recursively, all its children. In order to reconstruct the directory tree,
   * the client must take the digests of each of the child directories and then
   * build up a tree starting from the `root`.
   * </pre>
   *
   * <code>repeated .google.devtools.remoteexecution.v1test.Directory children = 2;</code>
   */
  com.google.devtools.remoteexecution.v1test.Directory getChildren(int index);
  /**
   * <pre>
   * All the child directories: the directories referred to by the root and,
   * recursively, all its children. In order to reconstruct the directory tree,
   * the client must take the digests of each of the child directories and then
   * build up a tree starting from the `root`.
   * </pre>
   *
   * <code>repeated .google.devtools.remoteexecution.v1test.Directory children = 2;</code>
   */
  int getChildrenCount();
  /**
   * <pre>
   * All the child directories: the directories referred to by the root and,
   * recursively, all its children. In order to reconstruct the directory tree,
   * the client must take the digests of each of the child directories and then
   * build up a tree starting from the `root`.
   * </pre>
   *
   * <code>repeated .google.devtools.remoteexecution.v1test.Directory children = 2;</code>
   */
  java.util.List<? extends com.google.devtools.remoteexecution.v1test.DirectoryOrBuilder> 
      getChildrenOrBuilderList();
  /**
   * <pre>
   * All the child directories: the directories referred to by the root and,
   * recursively, all its children. In order to reconstruct the directory tree,
   * the client must take the digests of each of the child directories and then
   * build up a tree starting from the `root`.
   * </pre>
   *
   * <code>repeated .google.devtools.remoteexecution.v1test.Directory children = 2;</code>
   */
  com.google.devtools.remoteexecution.v1test.DirectoryOrBuilder getChildrenOrBuilder(
      int index);
}
