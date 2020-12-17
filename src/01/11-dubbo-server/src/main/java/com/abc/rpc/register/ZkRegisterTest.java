package com.abc.rpc.register;

public class ZkRegisterTest {
    public static void main(String[] args) throws Exception {
        RegisterCenter center = new ZkRegisterCenter();
        center.register("com.abc.service.SomeService", "127.0.0.1:8888:com.abc.service.SomeServiceImpl");
        System.in.read();
    }
}
