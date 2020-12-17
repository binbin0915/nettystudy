package com.abc.rpc.consumer;

import com.abc.rpc.client.RpcProxy;
import com.abc.rpc.service.SomeService;

public class RpcConsumer {
    public static void main(String[] args) {
        SomeService service = RpcProxy.create(SomeService.class, "Wechat");
        if (service != null) {
            System.out.println(service.hello("开课吧"));
            System.out.println(service.hashCode());
        }
    }
}
