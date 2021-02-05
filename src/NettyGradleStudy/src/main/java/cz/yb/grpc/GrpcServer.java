package cz.yb.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    private Server server;
    private  void start() throws IOException {
        this.server = ServerBuilder.forPort(9988).addService(new XueshengServiceImpl()).build().start();
        System.out.println("Grpc服务启动.....");

        Runtime.getRuntime().addShutdownHook(new Thread(
                ()->{
                    System.out.println("关闭JVM.....");
                    GrpcServer.this.stop();
                }
        ));

        System.out.println("Grpc服务启动后执行到这里.....");

    }

    private  void stop(){
        if(null != this.server){
            this.server.shutdown();
        }
    }

    private  void awaitTermination() throws  InterruptedException{
        if(null != this.server){
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws  Exception {
        GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }
}
