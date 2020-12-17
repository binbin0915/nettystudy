package com.abc;

import com.abc.registry.RegistryCenter;
import com.abc.server.RpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpCServerStarter implements CommandLineRunner {
    @Autowired
    private RpcServer server;
    @Autowired
    private RegistryCenter registryCenter;

    public static void main(String[] args) {
        SpringApplication.run(RpCServerStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.publish(registryCenter, "127.0.0.1:8888", "com.abc.service");
    }
}
