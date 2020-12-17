package com.abc.client;

import com.abc.discovery.ServiceDiscovery;
import com.abc.rpc.api.InvokeMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class RpcProxy {
    @Autowired
    private ServiceDiscovery discovery;

    public <T> T create(Class<?> clazz) {
        return (T)Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(Object.class.equals(method.getDeclaringClass())) {
                            return method.invoke(this, args);
                        }

                        return rpcInvoke(clazz, method, args);
                    }
                });
    }

    private Object rpcInvoke(Class<?> clazz, Method method, Object[] args) throws Exception {
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        RpcClientHandler handler = new RpcClientHandler();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE,
                                    ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast(handler);
                        }
                    });

            String serviceAddress = discovery.discovery(clazz.getName());
            String ip = serviceAddress.split(":")[0];
            String port = serviceAddress.split(":")[1];

            ChannelFuture future = bootstrap.connect(ip, Integer.valueOf(port)).sync();

            InvokeMessage message = new InvokeMessage();
            message.setServiceName(clazz.getName());
            message.setMethodName(method.getName());
            message.setParamTypes(method.getParameterTypes());
            message.setParamValues(args);

            future.channel().writeAndFlush(message);
            future.channel().closeFuture().sync();
        } finally {
            loopGroup.shutdownGracefully();
        }
        return handler.getResult();
    }
}
