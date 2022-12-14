package build.bazel.remote.execution.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The action cache API is used to query whether a given action has already been
 * performed and, if so, retrieve its result. Unlike the
 * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage],
 * which addresses blobs by their own content, the action cache addresses the
 * [ActionResult][build.bazel.remote.execution.v2.ActionResult] by a
 * digest of the encoded [Action][build.bazel.remote.execution.v2.Action]
 * which produced them.
 * The lifetime of entries in the action cache is implementation-specific, but
 * the server SHOULD assume that more recently used entries are more likely to
 * be used again.
 * As with other services in the Remote Execution API, any call may return an
 * error with a [RetryInfo][google.rpc.RetryInfo] error detail providing
 * information about when the client should retry the request; clients SHOULD
 * respect the information provided.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: build/bazel/remote/execution/v2/remote_execution.proto")
public final class ActionCacheGrpc {

  private ActionCacheGrpc() {}

  public static final String SERVICE_NAME = "build.bazel.remote.execution.v2.ActionCache";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<build.bazel.remote.execution.v2.GetActionResultRequest,
      build.bazel.remote.execution.v2.ActionResult> getGetActionResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetActionResult",
      requestType = build.bazel.remote.execution.v2.GetActionResultRequest.class,
      responseType = build.bazel.remote.execution.v2.ActionResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<build.bazel.remote.execution.v2.GetActionResultRequest,
      build.bazel.remote.execution.v2.ActionResult> getGetActionResultMethod() {
    io.grpc.MethodDescriptor<build.bazel.remote.execution.v2.GetActionResultRequest, build.bazel.remote.execution.v2.ActionResult> getGetActionResultMethod;
    if ((getGetActionResultMethod = ActionCacheGrpc.getGetActionResultMethod) == null) {
      synchronized (ActionCacheGrpc.class) {
        if ((getGetActionResultMethod = ActionCacheGrpc.getGetActionResultMethod) == null) {
          ActionCacheGrpc.getGetActionResultMethod = getGetActionResultMethod =
              io.grpc.MethodDescriptor.<build.bazel.remote.execution.v2.GetActionResultRequest, build.bazel.remote.execution.v2.ActionResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetActionResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  build.bazel.remote.execution.v2.GetActionResultRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  build.bazel.remote.execution.v2.ActionResult.getDefaultInstance()))
              .setSchemaDescriptor(new ActionCacheMethodDescriptorSupplier("GetActionResult"))
              .build();
        }
      }
    }
    return getGetActionResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<build.bazel.remote.execution.v2.UpdateActionResultRequest,
      build.bazel.remote.execution.v2.ActionResult> getUpdateActionResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateActionResult",
      requestType = build.bazel.remote.execution.v2.UpdateActionResultRequest.class,
      responseType = build.bazel.remote.execution.v2.ActionResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<build.bazel.remote.execution.v2.UpdateActionResultRequest,
      build.bazel.remote.execution.v2.ActionResult> getUpdateActionResultMethod() {
    io.grpc.MethodDescriptor<build.bazel.remote.execution.v2.UpdateActionResultRequest, build.bazel.remote.execution.v2.ActionResult> getUpdateActionResultMethod;
    if ((getUpdateActionResultMethod = ActionCacheGrpc.getUpdateActionResultMethod) == null) {
      synchronized (ActionCacheGrpc.class) {
        if ((getUpdateActionResultMethod = ActionCacheGrpc.getUpdateActionResultMethod) == null) {
          ActionCacheGrpc.getUpdateActionResultMethod = getUpdateActionResultMethod =
              io.grpc.MethodDescriptor.<build.bazel.remote.execution.v2.UpdateActionResultRequest, build.bazel.remote.execution.v2.ActionResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateActionResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  build.bazel.remote.execution.v2.UpdateActionResultRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  build.bazel.remote.execution.v2.ActionResult.getDefaultInstance()))
              .setSchemaDescriptor(new ActionCacheMethodDescriptorSupplier("UpdateActionResult"))
              .build();
        }
      }
    }
    return getUpdateActionResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ActionCacheStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ActionCacheStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ActionCacheStub>() {
        @java.lang.Override
        public ActionCacheStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ActionCacheStub(channel, callOptions);
        }
      };
    return ActionCacheStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ActionCacheBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ActionCacheBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ActionCacheBlockingStub>() {
        @java.lang.Override
        public ActionCacheBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ActionCacheBlockingStub(channel, callOptions);
        }
      };
    return ActionCacheBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ActionCacheFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ActionCacheFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ActionCacheFutureStub>() {
        @java.lang.Override
        public ActionCacheFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ActionCacheFutureStub(channel, callOptions);
        }
      };
    return ActionCacheFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The action cache API is used to query whether a given action has already been
   * performed and, if so, retrieve its result. Unlike the
   * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage],
   * which addresses blobs by their own content, the action cache addresses the
   * [ActionResult][build.bazel.remote.execution.v2.ActionResult] by a
   * digest of the encoded [Action][build.bazel.remote.execution.v2.Action]
   * which produced them.
   * The lifetime of entries in the action cache is implementation-specific, but
   * the server SHOULD assume that more recently used entries are more likely to
   * be used again.
   * As with other services in the Remote Execution API, any call may return an
   * error with a [RetryInfo][google.rpc.RetryInfo] error detail providing
   * information about when the client should retry the request; clients SHOULD
   * respect the information provided.
   * </pre>
   */
  public static abstract class ActionCacheImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Retrieve a cached execution result.
     * Implementations SHOULD ensure that any blobs referenced from the
     * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage]
     * are available at the time of returning the
     * [ActionResult][build.bazel.remote.execution.v2.ActionResult] and will be
     * for some period of time afterwards. The lifetimes of the referenced blobs SHOULD be increased
     * if necessary and applicable.
     * Errors:
     * * `NOT_FOUND`: The requested `ActionResult` is not in the cache.
     * </pre>
     */
    public void getActionResult(build.bazel.remote.execution.v2.GetActionResultRequest request,
        io.grpc.stub.StreamObserver<build.bazel.remote.execution.v2.ActionResult> responseObserver) {
      asyncUnimplementedUnaryCall(getGetActionResultMethod(), responseObserver);
    }

    /**
     * <pre>
     * Upload a new execution result.
     * In order to allow the server to perform access control based on the type of
     * action, and to assist with client debugging, the client MUST first upload
     * the [Action][build.bazel.remote.execution.v2.Execution] that produced the
     * result, along with its
     * [Command][build.bazel.remote.execution.v2.Command], into the
     * `ContentAddressableStorage`.
     * Server implementations MAY modify the
     * `UpdateActionResultRequest.action_result` and return an equivalent value.
     * Errors:
     * * `INVALID_ARGUMENT`: One or more arguments are invalid.
     * * `FAILED_PRECONDITION`: One or more errors occurred in updating the
     *   action result, such as a missing command or action.
     * * `RESOURCE_EXHAUSTED`: There is insufficient storage space to add the
     *   entry to the cache.
     * </pre>
     */
    public void updateActionResult(build.bazel.remote.execution.v2.UpdateActionResultRequest request,
        io.grpc.stub.StreamObserver<build.bazel.remote.execution.v2.ActionResult> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateActionResultMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetActionResultMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                build.bazel.remote.execution.v2.GetActionResultRequest,
                build.bazel.remote.execution.v2.ActionResult>(
                  this, METHODID_GET_ACTION_RESULT)))
          .addMethod(
            getUpdateActionResultMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                build.bazel.remote.execution.v2.UpdateActionResultRequest,
                build.bazel.remote.execution.v2.ActionResult>(
                  this, METHODID_UPDATE_ACTION_RESULT)))
          .build();
    }
  }

  /**
   * <pre>
   * The action cache API is used to query whether a given action has already been
   * performed and, if so, retrieve its result. Unlike the
   * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage],
   * which addresses blobs by their own content, the action cache addresses the
   * [ActionResult][build.bazel.remote.execution.v2.ActionResult] by a
   * digest of the encoded [Action][build.bazel.remote.execution.v2.Action]
   * which produced them.
   * The lifetime of entries in the action cache is implementation-specific, but
   * the server SHOULD assume that more recently used entries are more likely to
   * be used again.
   * As with other services in the Remote Execution API, any call may return an
   * error with a [RetryInfo][google.rpc.RetryInfo] error detail providing
   * information about when the client should retry the request; clients SHOULD
   * respect the information provided.
   * </pre>
   */
  public static final class ActionCacheStub extends io.grpc.stub.AbstractAsyncStub<ActionCacheStub> {
    private ActionCacheStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActionCacheStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ActionCacheStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve a cached execution result.
     * Implementations SHOULD ensure that any blobs referenced from the
     * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage]
     * are available at the time of returning the
     * [ActionResult][build.bazel.remote.execution.v2.ActionResult] and will be
     * for some period of time afterwards. The lifetimes of the referenced blobs SHOULD be increased
     * if necessary and applicable.
     * Errors:
     * * `NOT_FOUND`: The requested `ActionResult` is not in the cache.
     * </pre>
     */
    public void getActionResult(build.bazel.remote.execution.v2.GetActionResultRequest request,
        io.grpc.stub.StreamObserver<build.bazel.remote.execution.v2.ActionResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetActionResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Upload a new execution result.
     * In order to allow the server to perform access control based on the type of
     * action, and to assist with client debugging, the client MUST first upload
     * the [Action][build.bazel.remote.execution.v2.Execution] that produced the
     * result, along with its
     * [Command][build.bazel.remote.execution.v2.Command], into the
     * `ContentAddressableStorage`.
     * Server implementations MAY modify the
     * `UpdateActionResultRequest.action_result` and return an equivalent value.
     * Errors:
     * * `INVALID_ARGUMENT`: One or more arguments are invalid.
     * * `FAILED_PRECONDITION`: One or more errors occurred in updating the
     *   action result, such as a missing command or action.
     * * `RESOURCE_EXHAUSTED`: There is insufficient storage space to add the
     *   entry to the cache.
     * </pre>
     */
    public void updateActionResult(build.bazel.remote.execution.v2.UpdateActionResultRequest request,
        io.grpc.stub.StreamObserver<build.bazel.remote.execution.v2.ActionResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateActionResultMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The action cache API is used to query whether a given action has already been
   * performed and, if so, retrieve its result. Unlike the
   * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage],
   * which addresses blobs by their own content, the action cache addresses the
   * [ActionResult][build.bazel.remote.execution.v2.ActionResult] by a
   * digest of the encoded [Action][build.bazel.remote.execution.v2.Action]
   * which produced them.
   * The lifetime of entries in the action cache is implementation-specific, but
   * the server SHOULD assume that more recently used entries are more likely to
   * be used again.
   * As with other services in the Remote Execution API, any call may return an
   * error with a [RetryInfo][google.rpc.RetryInfo] error detail providing
   * information about when the client should retry the request; clients SHOULD
   * respect the information provided.
   * </pre>
   */
  public static final class ActionCacheBlockingStub extends io.grpc.stub.AbstractBlockingStub<ActionCacheBlockingStub> {
    private ActionCacheBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActionCacheBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ActionCacheBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve a cached execution result.
     * Implementations SHOULD ensure that any blobs referenced from the
     * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage]
     * are available at the time of returning the
     * [ActionResult][build.bazel.remote.execution.v2.ActionResult] and will be
     * for some period of time afterwards. The lifetimes of the referenced blobs SHOULD be increased
     * if necessary and applicable.
     * Errors:
     * * `NOT_FOUND`: The requested `ActionResult` is not in the cache.
     * </pre>
     */
    public build.bazel.remote.execution.v2.ActionResult getActionResult(build.bazel.remote.execution.v2.GetActionResultRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetActionResultMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Upload a new execution result.
     * In order to allow the server to perform access control based on the type of
     * action, and to assist with client debugging, the client MUST first upload
     * the [Action][build.bazel.remote.execution.v2.Execution] that produced the
     * result, along with its
     * [Command][build.bazel.remote.execution.v2.Command], into the
     * `ContentAddressableStorage`.
     * Server implementations MAY modify the
     * `UpdateActionResultRequest.action_result` and return an equivalent value.
     * Errors:
     * * `INVALID_ARGUMENT`: One or more arguments are invalid.
     * * `FAILED_PRECONDITION`: One or more errors occurred in updating the
     *   action result, such as a missing command or action.
     * * `RESOURCE_EXHAUSTED`: There is insufficient storage space to add the
     *   entry to the cache.
     * </pre>
     */
    public build.bazel.remote.execution.v2.ActionResult updateActionResult(build.bazel.remote.execution.v2.UpdateActionResultRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateActionResultMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The action cache API is used to query whether a given action has already been
   * performed and, if so, retrieve its result. Unlike the
   * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage],
   * which addresses blobs by their own content, the action cache addresses the
   * [ActionResult][build.bazel.remote.execution.v2.ActionResult] by a
   * digest of the encoded [Action][build.bazel.remote.execution.v2.Action]
   * which produced them.
   * The lifetime of entries in the action cache is implementation-specific, but
   * the server SHOULD assume that more recently used entries are more likely to
   * be used again.
   * As with other services in the Remote Execution API, any call may return an
   * error with a [RetryInfo][google.rpc.RetryInfo] error detail providing
   * information about when the client should retry the request; clients SHOULD
   * respect the information provided.
   * </pre>
   */
  public static final class ActionCacheFutureStub extends io.grpc.stub.AbstractFutureStub<ActionCacheFutureStub> {
    private ActionCacheFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActionCacheFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ActionCacheFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieve a cached execution result.
     * Implementations SHOULD ensure that any blobs referenced from the
     * [ContentAddressableStorage][build.bazel.remote.execution.v2.ContentAddressableStorage]
     * are available at the time of returning the
     * [ActionResult][build.bazel.remote.execution.v2.ActionResult] and will be
     * for some period of time afterwards. The lifetimes of the referenced blobs SHOULD be increased
     * if necessary and applicable.
     * Errors:
     * * `NOT_FOUND`: The requested `ActionResult` is not in the cache.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<build.bazel.remote.execution.v2.ActionResult> getActionResult(
        build.bazel.remote.execution.v2.GetActionResultRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetActionResultMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Upload a new execution result.
     * In order to allow the server to perform access control based on the type of
     * action, and to assist with client debugging, the client MUST first upload
     * the [Action][build.bazel.remote.execution.v2.Execution] that produced the
     * result, along with its
     * [Command][build.bazel.remote.execution.v2.Command], into the
     * `ContentAddressableStorage`.
     * Server implementations MAY modify the
     * `UpdateActionResultRequest.action_result` and return an equivalent value.
     * Errors:
     * * `INVALID_ARGUMENT`: One or more arguments are invalid.
     * * `FAILED_PRECONDITION`: One or more errors occurred in updating the
     *   action result, such as a missing command or action.
     * * `RESOURCE_EXHAUSTED`: There is insufficient storage space to add the
     *   entry to the cache.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<build.bazel.remote.execution.v2.ActionResult> updateActionResult(
        build.bazel.remote.execution.v2.UpdateActionResultRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateActionResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACTION_RESULT = 0;
  private static final int METHODID_UPDATE_ACTION_RESULT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ActionCacheImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ActionCacheImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACTION_RESULT:
          serviceImpl.getActionResult((build.bazel.remote.execution.v2.GetActionResultRequest) request,
              (io.grpc.stub.StreamObserver<build.bazel.remote.execution.v2.ActionResult>) responseObserver);
          break;
        case METHODID_UPDATE_ACTION_RESULT:
          serviceImpl.updateActionResult((build.bazel.remote.execution.v2.UpdateActionResultRequest) request,
              (io.grpc.stub.StreamObserver<build.bazel.remote.execution.v2.ActionResult>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ActionCacheBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ActionCacheBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return build.bazel.remote.execution.v2.RemoteExecutionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ActionCache");
    }
  }

  private static final class ActionCacheFileDescriptorSupplier
      extends ActionCacheBaseDescriptorSupplier {
    ActionCacheFileDescriptorSupplier() {}
  }

  private static final class ActionCacheMethodDescriptorSupplier
      extends ActionCacheBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ActionCacheMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ActionCacheGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ActionCacheFileDescriptorSupplier())
              .addMethod(getGetActionResultMethod())
              .addMethod(getUpdateActionResultMethod())
              .build();
        }
      }
    }
    return result;
  }
}
