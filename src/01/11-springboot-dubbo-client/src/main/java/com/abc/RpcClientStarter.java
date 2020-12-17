package com.abc;

import com.abc.client.RpcProxy;
import com.abc.rpc.api.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpcClientStarter implements CommandLineRunner {
    @Autowired
    private RpcProxy proxy;

    public static void main(String[] args) {
        SpringApplication.run(RpcClientStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SomeService service = proxy.create(SomeService.class);
        String result = service.doSome("研发部");
        System.out.println(result);
    }
}
