package com.abc.rpc.server;

import com.abc.rpc.register.ZkRegisterCenter;

public class RpcServerStarter {
    public static void main(String[] args) throws Exception {
        RpcServer server = new RpcServer();
        // 发布服务提供者
        server.publish("com.abc.rpc.service", new ZkRegisterCenter(), "127.0.0.1:8888");
        // 启动server
        server.start();
    }
}
