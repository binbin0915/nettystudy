package cz.yb.grpc;

import cz.yb.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class XueshengServiceImpl extends XueshengServiceGrpc.XueshengServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端消息:"+ request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("nixx"+request.getUsername()+"好啊好啊").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端消息:"+ request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setAge(10).setName("张三").setCity("常州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(11).setName("李四").setCity("shangh").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(12).setName("王五").setCity("bj").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(13).setName("赵六").setCity("gz").build());

        responseObserver.onCompleted();
    }


    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return  new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext:"+value.getAge());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                StudentResponse studentResponse = StudentResponse.newBuilder().setName("君望永远1").setCity("常州1").setAge(16).build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("君望永远2").setCity("常州2").setAge(12).build();
                StudentResponseList studentResponseList =StudentResponseList.newBuilder().addStudentResponse(studentResponse).addStudentResponse(studentResponse2).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return  new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                    System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
