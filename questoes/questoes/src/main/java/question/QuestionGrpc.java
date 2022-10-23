package question;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.30.0)",
    comments = "Source: Questions.proto")
public final class QuestionGrpc {

  private QuestionGrpc() {}

  public static final String SERVICE_NAME = "Question";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<question.QuestionRequest,
      question.QuestionReply> getCallQuestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CallQuestion",
      requestType = question.QuestionRequest.class,
      responseType = question.QuestionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<question.QuestionRequest,
      question.QuestionReply> getCallQuestionMethod() {
    io.grpc.MethodDescriptor<question.QuestionRequest, question.QuestionReply> getCallQuestionMethod;
    if ((getCallQuestionMethod = QuestionGrpc.getCallQuestionMethod) == null) {
      synchronized (QuestionGrpc.class) {
        if ((getCallQuestionMethod = QuestionGrpc.getCallQuestionMethod) == null) {
          QuestionGrpc.getCallQuestionMethod = getCallQuestionMethod =
              io.grpc.MethodDescriptor.<question.QuestionRequest, question.QuestionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CallQuestion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  question.QuestionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  question.QuestionReply.getDefaultInstance()))
              .setSchemaDescriptor(new QuestionMethodDescriptorSupplier("CallQuestion"))
              .build();
        }
      }
    }
    return getCallQuestionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static QuestionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuestionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QuestionStub>() {
        @java.lang.Override
        public QuestionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QuestionStub(channel, callOptions);
        }
      };
    return QuestionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QuestionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuestionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QuestionBlockingStub>() {
        @java.lang.Override
        public QuestionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QuestionBlockingStub(channel, callOptions);
        }
      };
    return QuestionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static QuestionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuestionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QuestionFutureStub>() {
        @java.lang.Override
        public QuestionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QuestionFutureStub(channel, callOptions);
        }
      };
    return QuestionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class QuestionImplBase implements io.grpc.BindableService {

    /**
     */
    public void callQuestion(question.QuestionRequest request,
        io.grpc.stub.StreamObserver<question.QuestionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCallQuestionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCallQuestionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                question.QuestionRequest,
                question.QuestionReply>(
                  this, METHODID_CALL_QUESTION)))
          .build();
    }
  }

  /**
   */
  public static final class QuestionStub extends io.grpc.stub.AbstractAsyncStub<QuestionStub> {
    private QuestionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuestionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuestionStub(channel, callOptions);
    }

    /**
     */
    public void callQuestion(question.QuestionRequest request,
        io.grpc.stub.StreamObserver<question.QuestionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCallQuestionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class QuestionBlockingStub extends io.grpc.stub.AbstractBlockingStub<QuestionBlockingStub> {
    private QuestionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuestionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuestionBlockingStub(channel, callOptions);
    }

    /**
     */
    public question.QuestionReply callQuestion(question.QuestionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCallQuestionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class QuestionFutureStub extends io.grpc.stub.AbstractFutureStub<QuestionFutureStub> {
    private QuestionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuestionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuestionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<question.QuestionReply> callQuestion(
        question.QuestionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCallQuestionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALL_QUESTION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final QuestionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(QuestionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALL_QUESTION:
          serviceImpl.callQuestion((question.QuestionRequest) request,
              (io.grpc.stub.StreamObserver<question.QuestionReply>) responseObserver);
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

  private static abstract class QuestionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    QuestionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return question.QuestionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Question");
    }
  }

  private static final class QuestionFileDescriptorSupplier
      extends QuestionBaseDescriptorSupplier {
    QuestionFileDescriptorSupplier() {}
  }

  private static final class QuestionMethodDescriptorSupplier
      extends QuestionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    QuestionMethodDescriptorSupplier(String methodName) {
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
      synchronized (QuestionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new QuestionFileDescriptorSupplier())
              .addMethod(getCallQuestionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
