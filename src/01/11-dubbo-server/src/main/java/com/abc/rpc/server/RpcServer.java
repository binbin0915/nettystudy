package com.abc.rpc.server;

import com.abc.rpc.register.RegisterCenter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.File;
import java.net.URL;
import java.util.*;

public class RpcServer {

    // 定义服务注册表
    private Map<String, Object> registerMap = new HashMap<>();
    // 用于缓存指定包中所有提供者的类名
    private List<String> classCache = new ArrayList<>();
    private String providerPackage;

    private String serviceAddress;

    // 将指定包中的所有提供者进行发布（写入服务注册表）
    public void publish(String basePackage, RegisterCenter center, String serviceAddress) throws Exception {
        // 将指定包中的所有.class文件的类名写入到classCache中
        getProviderClass(basePackage);
        // 真正注册
        doRgister(center, serviceAddress);
        this.serviceAddress = serviceAddress;
        this.providerPackage = basePackage;
    }

    private void getProviderClass(String basePackage) {
        // 获取指定包中的资源
        URL resource = this.getClass().getClassLoader()
                // com.abc.rpc.service  -> com/abc/rpc/service
                .getResource(basePackage.replaceAll("\\.", "/"));

        // 若目录中没有任何资源，则直接结束
        if(resource == null) return;

        // 将URL资源转化为file
        File dir = new File(resource.getFile());

        // 遍历指定包及其子孙包中所有的文件，查找.class文件
        for (File file : dir.listFiles()) {
            // 若当前遍历文件为目录，则递归
            if(file.isDirectory()) {
                getProviderClass(basePackage + "." + file.getName());
            } else if(file.getName().endsWith(".class")) {
                // 获取简单类名
                String fileName = file.getName().replace(".class", "").trim();
                // 将.class的全限定类名添加到缓存集合
                classCache.add(basePackage + "." + fileName);
            }
        }

        // System.out.println("classCache = " + classCache);
    }

    private void doRgister(RegisterCenter center, String serviceAddress) throws Exception {
        // 1. 写入到registerMap
        // 2. 写入到zk

        // 若没有提供者类，则直接结束
        if(classCache.size() == 0) return;

        // 将所有提供者写入到注册表
        for (String className : classCache) {
            Class<?> clazz = Class.forName(className);
            String interfaceName = clazz.getInterfaces()[0].getName();
            // 注意：这里的key由原来的接口变为了实现类名
            registerMap.put(className, clazz.newInstance());
            center.register(interfaceName, serviceAddress);

        }

    }

    // 启动服务端
    public void start() throws InterruptedException {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try{

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup)
                    // 用于指定当服务端请求处理线程全部用完时，临时存放已经完成了三次握手的请求的队列的长度
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    // 指定是否启用心跳机制来维护C/S间的长连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 指定要创建的Channel的类型
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE,
                                    ClassResolvers.cacheDisabled(null)));
                            // 添加自定义处理器
                            pipeline.addLast(new RpcServerHandler(registerMap, providerPackage));
                        }
                    });

            String ip = serviceAddress.split(":")[0];
            String port = serviceAddress.split(":")[1];

            ChannelFuture future = bootstrap.bind(ip, Integer.valueOf(port)).sync();
            System.out.println("server 已启动");
            future.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
