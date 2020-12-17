package com.abc.server;

import com.abc.registry.RegistryCenter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RpcServer {

    private boolean isRegisted = false;
    private ConcurrentHashMap<String, Object> registryMap = new ConcurrentHashMap<>();
    private List<String> classCache = Collections.synchronizedList(new ArrayList<>());

    public void publish(RegistryCenter registryCenter, String serviceAddress, String providerPackage) throws Exception {

        getProviderClass(providerPackage);

        doRegister(registryCenter, serviceAddress);

        NioEventLoopGroup parentGroup = new NioEventLoopGroup();
        NioEventLoopGroup childGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE,
                                    ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast(new RpcServerHandler(registryMap));
                        }
                    });

            String ip = serviceAddress.split(":")[0];
            String port = serviceAddress.split(":")[1];

            ChannelFuture future = bootstrap.bind(ip, Integer.valueOf(port)).sync();
            System.out.println("微服务已注册成功");
            future.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }

    }

    public void getProviderClass(String providerPackage) {
        URL resource = this.getClass().getClassLoader()
                .getResource(providerPackage.replaceAll("\\.", "/"));

        File dir = new File(resource.getFile());
        for(File file : dir.listFiles()) {
            if(file.isDirectory()) {
                getProviderClass(providerPackage + "." + file.getName());

            } else if(file.getName().endsWith(".class")){
                String fileName = file.getName().replace(".class", "").trim();
                classCache.add(providerPackage + "." + fileName);
            }
        }
    }

    private void doRegister(RegistryCenter registryCenter, String serviceAddress) throws Exception {
        if(classCache.size() == 0) return;

        for (String className : classCache) {
            Class<?> clazz = Class.forName(className);
            String interfaceName = clazz.getInterfaces()[0].getName();
            registryMap.put(interfaceName, clazz.newInstance());
            if(!isRegisted) {
                registryCenter.register(interfaceName, serviceAddress);
                isRegisted = true;
            }
        }

    }
}
