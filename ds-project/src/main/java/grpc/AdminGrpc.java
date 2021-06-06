package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Admin.proto")
public final class AdminGrpc {

  private AdminGrpc() {}

  public static final String SERVICE_NAME = "grpc.Admin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getInsertCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertCustomer",
      requestType = grpc.Request.class,
      responseType = grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getInsertCustomerMethod() {
    io.grpc.MethodDescriptor<grpc.Request, grpc.Response> getInsertCustomerMethod;
    if ((getInsertCustomerMethod = AdminGrpc.getInsertCustomerMethod) == null) {
      synchronized (AdminGrpc.class) {
        if ((getInsertCustomerMethod = AdminGrpc.getInsertCustomerMethod) == null) {
          AdminGrpc.getInsertCustomerMethod = getInsertCustomerMethod = 
              io.grpc.MethodDescriptor.<grpc.Request, grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.Admin", "insertCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new AdminMethodDescriptorSupplier("insertCustomer"))
                  .build();
          }
        }
     }
     return getInsertCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getModifyCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "modifyCustomer",
      requestType = grpc.Request.class,
      responseType = grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getModifyCustomerMethod() {
    io.grpc.MethodDescriptor<grpc.Request, grpc.Response> getModifyCustomerMethod;
    if ((getModifyCustomerMethod = AdminGrpc.getModifyCustomerMethod) == null) {
      synchronized (AdminGrpc.class) {
        if ((getModifyCustomerMethod = AdminGrpc.getModifyCustomerMethod) == null) {
          AdminGrpc.getModifyCustomerMethod = getModifyCustomerMethod = 
              io.grpc.MethodDescriptor.<grpc.Request, grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.Admin", "modifyCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new AdminMethodDescriptorSupplier("modifyCustomer"))
                  .build();
          }
        }
     }
     return getModifyCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getQueryCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "queryCustomer",
      requestType = grpc.Request.class,
      responseType = grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getQueryCustomerMethod() {
    io.grpc.MethodDescriptor<grpc.Request, grpc.Response> getQueryCustomerMethod;
    if ((getQueryCustomerMethod = AdminGrpc.getQueryCustomerMethod) == null) {
      synchronized (AdminGrpc.class) {
        if ((getQueryCustomerMethod = AdminGrpc.getQueryCustomerMethod) == null) {
          AdminGrpc.getQueryCustomerMethod = getQueryCustomerMethod = 
              io.grpc.MethodDescriptor.<grpc.Request, grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.Admin", "queryCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new AdminMethodDescriptorSupplier("queryCustomer"))
                  .build();
          }
        }
     }
     return getQueryCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getDeleteCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCustomer",
      requestType = grpc.Request.class,
      responseType = grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Request,
      grpc.Response> getDeleteCustomerMethod() {
    io.grpc.MethodDescriptor<grpc.Request, grpc.Response> getDeleteCustomerMethod;
    if ((getDeleteCustomerMethod = AdminGrpc.getDeleteCustomerMethod) == null) {
      synchronized (AdminGrpc.class) {
        if ((getDeleteCustomerMethod = AdminGrpc.getDeleteCustomerMethod) == null) {
          AdminGrpc.getDeleteCustomerMethod = getDeleteCustomerMethod = 
              io.grpc.MethodDescriptor.<grpc.Request, grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.Admin", "deleteCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new AdminMethodDescriptorSupplier("deleteCustomer"))
                  .build();
          }
        }
     }
     return getDeleteCustomerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdminStub newStub(io.grpc.Channel channel) {
    return new AdminStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdminBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AdminBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdminFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AdminFutureStub(channel);
  }

  /**
   */
  public static abstract class AdminImplBase implements io.grpc.BindableService {

    /**
     */
    public void insertCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertCustomerMethod(), responseObserver);
    }

    /**
     */
    public void modifyCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getModifyCustomerMethod(), responseObserver);
    }

    /**
     */
    public void queryCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryCustomerMethod(), responseObserver);
    }

    /**
     */
    public void deleteCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCustomerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInsertCustomerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Request,
                grpc.Response>(
                  this, METHODID_INSERT_CUSTOMER)))
          .addMethod(
            getModifyCustomerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Request,
                grpc.Response>(
                  this, METHODID_MODIFY_CUSTOMER)))
          .addMethod(
            getQueryCustomerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Request,
                grpc.Response>(
                  this, METHODID_QUERY_CUSTOMER)))
          .addMethod(
            getDeleteCustomerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Request,
                grpc.Response>(
                  this, METHODID_DELETE_CUSTOMER)))
          .build();
    }
  }

  /**
   */
  public static final class AdminStub extends io.grpc.stub.AbstractStub<AdminStub> {
    private AdminStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminStub(channel, callOptions);
    }

    /**
     */
    public void insertCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modifyCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getModifyCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomer(grpc.Request request,
        io.grpc.stub.StreamObserver<grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCustomerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AdminBlockingStub extends io.grpc.stub.AbstractStub<AdminBlockingStub> {
    private AdminBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Response insertCustomer(grpc.Request request) {
      return blockingUnaryCall(
          getChannel(), getInsertCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Response modifyCustomer(grpc.Request request) {
      return blockingUnaryCall(
          getChannel(), getModifyCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Response queryCustomer(grpc.Request request) {
      return blockingUnaryCall(
          getChannel(), getQueryCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Response deleteCustomer(grpc.Request request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCustomerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AdminFutureStub extends io.grpc.stub.AbstractStub<AdminFutureStub> {
    private AdminFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Response> insertCustomer(
        grpc.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Response> modifyCustomer(
        grpc.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getModifyCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Response> queryCustomer(
        grpc.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Response> deleteCustomer(
        grpc.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCustomerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_CUSTOMER = 0;
  private static final int METHODID_MODIFY_CUSTOMER = 1;
  private static final int METHODID_QUERY_CUSTOMER = 2;
  private static final int METHODID_DELETE_CUSTOMER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdminImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSERT_CUSTOMER:
          serviceImpl.insertCustomer((grpc.Request) request,
              (io.grpc.stub.StreamObserver<grpc.Response>) responseObserver);
          break;
        case METHODID_MODIFY_CUSTOMER:
          serviceImpl.modifyCustomer((grpc.Request) request,
              (io.grpc.stub.StreamObserver<grpc.Response>) responseObserver);
          break;
        case METHODID_QUERY_CUSTOMER:
          serviceImpl.queryCustomer((grpc.Request) request,
              (io.grpc.stub.StreamObserver<grpc.Response>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOMER:
          serviceImpl.deleteCustomer((grpc.Request) request,
              (io.grpc.stub.StreamObserver<grpc.Response>) responseObserver);
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

  private static abstract class AdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.AdminOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Admin");
    }
  }

  private static final class AdminFileDescriptorSupplier
      extends AdminBaseDescriptorSupplier {
    AdminFileDescriptorSupplier() {}
  }

  private static final class AdminMethodDescriptorSupplier
      extends AdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdminMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdminFileDescriptorSupplier())
              .addMethod(getInsertCustomerMethod())
              .addMethod(getModifyCustomerMethod())
              .addMethod(getQueryCustomerMethod())
              .addMethod(getDeleteCustomerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
