package cz.yb.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: Xuesheng.proto")
public final class XueshengServiceGrpc {

  private XueshengServiceGrpc() {}

  public static final String SERVICE_NAME = "cz.yb.proto.XueshengService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cz.yb.proto.MyRequest,
      cz.yb.proto.MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUsername",
      requestType = cz.yb.proto.MyRequest.class,
      responseType = cz.yb.proto.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cz.yb.proto.MyRequest,
      cz.yb.proto.MyResponse> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<cz.yb.proto.MyRequest, cz.yb.proto.MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = XueshengServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (XueshengServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = XueshengServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          XueshengServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod =
              io.grpc.MethodDescriptor.<cz.yb.proto.MyRequest, cz.yb.proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new XueshengServiceMethodDescriptorSupplier("GetRealNameByUsername"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cz.yb.proto.StudentRequest,
      cz.yb.proto.StudentResponse> getGetStudentsByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsByAge",
      requestType = cz.yb.proto.StudentRequest.class,
      responseType = cz.yb.proto.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cz.yb.proto.StudentRequest,
      cz.yb.proto.StudentResponse> getGetStudentsByAgeMethod() {
    io.grpc.MethodDescriptor<cz.yb.proto.StudentRequest, cz.yb.proto.StudentResponse> getGetStudentsByAgeMethod;
    if ((getGetStudentsByAgeMethod = XueshengServiceGrpc.getGetStudentsByAgeMethod) == null) {
      synchronized (XueshengServiceGrpc.class) {
        if ((getGetStudentsByAgeMethod = XueshengServiceGrpc.getGetStudentsByAgeMethod) == null) {
          XueshengServiceGrpc.getGetStudentsByAgeMethod = getGetStudentsByAgeMethod =
              io.grpc.MethodDescriptor.<cz.yb.proto.StudentRequest, cz.yb.proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new XueshengServiceMethodDescriptorSupplier("GetStudentsByAge"))
              .build();
        }
      }
    }
    return getGetStudentsByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cz.yb.proto.StudentRequest,
      cz.yb.proto.StudentResponseList> getGetStudentsWrapperByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsWrapperByAges",
      requestType = cz.yb.proto.StudentRequest.class,
      responseType = cz.yb.proto.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<cz.yb.proto.StudentRequest,
      cz.yb.proto.StudentResponseList> getGetStudentsWrapperByAgesMethod() {
    io.grpc.MethodDescriptor<cz.yb.proto.StudentRequest, cz.yb.proto.StudentResponseList> getGetStudentsWrapperByAgesMethod;
    if ((getGetStudentsWrapperByAgesMethod = XueshengServiceGrpc.getGetStudentsWrapperByAgesMethod) == null) {
      synchronized (XueshengServiceGrpc.class) {
        if ((getGetStudentsWrapperByAgesMethod = XueshengServiceGrpc.getGetStudentsWrapperByAgesMethod) == null) {
          XueshengServiceGrpc.getGetStudentsWrapperByAgesMethod = getGetStudentsWrapperByAgesMethod =
              io.grpc.MethodDescriptor.<cz.yb.proto.StudentRequest, cz.yb.proto.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentsWrapperByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.StudentResponseList.getDefaultInstance()))
              .setSchemaDescriptor(new XueshengServiceMethodDescriptorSupplier("GetStudentsWrapperByAges"))
              .build();
        }
      }
    }
    return getGetStudentsWrapperByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cz.yb.proto.StreamRequest,
      cz.yb.proto.StreamResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "biTalk",
      requestType = cz.yb.proto.StreamRequest.class,
      responseType = cz.yb.proto.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<cz.yb.proto.StreamRequest,
      cz.yb.proto.StreamResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<cz.yb.proto.StreamRequest, cz.yb.proto.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = XueshengServiceGrpc.getBiTalkMethod) == null) {
      synchronized (XueshengServiceGrpc.class) {
        if ((getBiTalkMethod = XueshengServiceGrpc.getBiTalkMethod) == null) {
          XueshengServiceGrpc.getBiTalkMethod = getBiTalkMethod =
              io.grpc.MethodDescriptor.<cz.yb.proto.StreamRequest, cz.yb.proto.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "biTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cz.yb.proto.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new XueshengServiceMethodDescriptorSupplier("biTalk"))
              .build();
        }
      }
    }
    return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static XueshengServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<XueshengServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<XueshengServiceStub>() {
        @java.lang.Override
        public XueshengServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new XueshengServiceStub(channel, callOptions);
        }
      };
    return XueshengServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static XueshengServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<XueshengServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<XueshengServiceBlockingStub>() {
        @java.lang.Override
        public XueshengServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new XueshengServiceBlockingStub(channel, callOptions);
        }
      };
    return XueshengServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static XueshengServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<XueshengServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<XueshengServiceFutureStub>() {
        @java.lang.Override
        public XueshengServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new XueshengServiceFutureStub(channel, callOptions);
        }
      };
    return XueshengServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class XueshengServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUsername(cz.yb.proto.MyRequest request,
        io.grpc.stub.StreamObserver<cz.yb.proto.MyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentsByAge(cz.yb.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<cz.yb.proto.StudentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudentsByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cz.yb.proto.StudentRequest> getStudentsWrapperByAges(
        io.grpc.stub.StreamObserver<cz.yb.proto.StudentResponseList> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetStudentsWrapperByAgesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cz.yb.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<cz.yb.proto.StreamResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cz.yb.proto.MyRequest,
                cz.yb.proto.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetStudentsByAgeMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                cz.yb.proto.StudentRequest,
                cz.yb.proto.StudentResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            getGetStudentsWrapperByAgesMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                cz.yb.proto.StudentRequest,
                cz.yb.proto.StudentResponseList>(
                  this, METHODID_GET_STUDENTS_WRAPPER_BY_AGES)))
          .addMethod(
            getBiTalkMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                cz.yb.proto.StreamRequest,
                cz.yb.proto.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class XueshengServiceStub extends io.grpc.stub.AbstractAsyncStub<XueshengServiceStub> {
    private XueshengServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected XueshengServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new XueshengServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUsername(cz.yb.proto.MyRequest request,
        io.grpc.stub.StreamObserver<cz.yb.proto.MyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentsByAge(cz.yb.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<cz.yb.proto.StudentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cz.yb.proto.StudentRequest> getStudentsWrapperByAges(
        io.grpc.stub.StreamObserver<cz.yb.proto.StudentResponseList> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGetStudentsWrapperByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cz.yb.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<cz.yb.proto.StreamResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class XueshengServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<XueshengServiceBlockingStub> {
    private XueshengServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected XueshengServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new XueshengServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cz.yb.proto.MyResponse getRealNameByUsername(cz.yb.proto.MyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<cz.yb.proto.StudentResponse> getStudentsByAge(
        cz.yb.proto.StudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetStudentsByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class XueshengServiceFutureStub extends io.grpc.stub.AbstractFutureStub<XueshengServiceFutureStub> {
    private XueshengServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected XueshengServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new XueshengServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cz.yb.proto.MyResponse> getRealNameByUsername(
        cz.yb.proto.MyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENTS_WRAPPER_BY_AGES = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final XueshengServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(XueshengServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((cz.yb.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<cz.yb.proto.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((cz.yb.proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<cz.yb.proto.StudentResponse>) responseObserver);
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
        case METHODID_GET_STUDENTS_WRAPPER_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentsWrapperByAges(
              (io.grpc.stub.StreamObserver<cz.yb.proto.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<cz.yb.proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class XueshengServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    XueshengServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cz.yb.proto.Xuesheng.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("XueshengService");
    }
  }

  private static final class XueshengServiceFileDescriptorSupplier
      extends XueshengServiceBaseDescriptorSupplier {
    XueshengServiceFileDescriptorSupplier() {}
  }

  private static final class XueshengServiceMethodDescriptorSupplier
      extends XueshengServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    XueshengServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (XueshengServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new XueshengServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethod())
              .addMethod(getGetStudentsByAgeMethod())
              .addMethod(getGetStudentsWrapperByAgesMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
