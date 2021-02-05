package cz.yb.grpc;

import cz.yb.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args)  throws  Exception{
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("127.0.0.1",9988).usePlaintext().build();
        XueshengServiceGrpc.XueshengServiceBlockingStub blockingStub = XueshengServiceGrpc.newBlockingStub(managedChannel);
        XueshengServiceGrpc.XueshengServiceStub stub = XueshengServiceGrpc.newStub(managedChannel);


        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());

        System.out.println(myResponse.getRealname());
        System.out.println("--------------------------------------");

//        Iterator<StudentResponse>  iter= blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(18).build());
//
//        while (iter.hasNext()){
//            StudentResponse studentResponse = iter.next();
//            System.out.println(studentResponse.getName()+"---"+studentResponse.getAge()+"---"+studentResponse.getCity());
//        }
//        System.out.println("--------------------------------------");
//
//
//        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
//            @Override
//            public void onNext(StudentResponseList value) {
//                value.getStudentResponseList().forEach(studentResponse -> {
//                    System.out.println(studentResponse.getName()+":"+studentResponse.getAge());
//                        }
//                );
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println("client onError:"+t.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("client onCompleted");
//            }
//        };
//
//        //发送流式  必须异步
//        StreamObserver<StreamRequest> streamRequestStreamObserver = stub.biTalk(new StreamObserver<StreamResponse>() {
//            @Override
//            public void onNext(StreamResponse value) {
//                System.out.println(value.getResponseInfo());
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println(t.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("onCompleted");
//            }
//        });
//
//        for (int i=0;i<10;i++){
//            streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
//            Thread.sleep(1000);
//        }
//

        //
//        Thread.sleep(300000);


    }
}
