package com.abc.tomcat;

import com.abc.servlet.Servnet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TomcatServer {
    private Map<String, String> classNameMap = new HashMap<>();
    private Map<String, Servnet> instanceMap = new HashMap<>();

    private String basePackage;

    public TomcatServer(String basePackage) {
        this.basePackage = basePackage;
    }

    // 启动Tomcat
    public void start() throws Exception {
        // 加载指定包中的类名
        cacheClassName(basePackage);
        // 运行Tomcat
        runServer();
    }

    private void cacheClassName(String basePackage) {
        URL resource = this.getClass().getClassLoader()
                .getResource(basePackage.replaceAll("\\.", "/"));
        if(resource == null) return;
        File dir = new File(resource.getFile());
        for (File file : dir.listFiles()) {
            if(file.isDirectory()) {
                cacheClassName(basePackage + "." + file.getName());
            } else if(file.getName().endsWith(".class")) {
                String fileName = file.getName().replace(".class", "").trim();
                classNameMap.put(fileName.toLowerCase(), basePackage + "." + fileName);
            }
        }
    }


    public void runServer() throws Exception {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();

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
                            pipeline.addLast(new HttpServerCodec());
                            pipeline.addLast(new TomcatServerHandler(classNameMap, instanceMap));
                        }
                    });

            ChannelFuture future = bootstrap.bind(8888).sync();
            System.out.println("Tomcat启动成功，端口号8888");
            future.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
