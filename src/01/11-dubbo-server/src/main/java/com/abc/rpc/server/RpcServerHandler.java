package com.abc.rpc.server;

import com.abc.rpc.dto.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

public class RpcServerHandler extends SimpleChannelInboundHandler<Invocation> {
    private Map<String, Object> registerMap;
    private String providerPackage;

    public RpcServerHandler(Map<String, Object> registerMap, String providerPackage) {
        this.registerMap = registerMap;
        this.providerPackage = providerPackage;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Invocation msg) throws Exception {
        Object result = "没有要访问的提供者";

        String className = msg.getClassName();
        String simpleClassName = className.substring(className.lastIndexOf(".") + 1);
        String key = providerPackage + "." + msg.getPrefix() + simpleClassName;

        // 判断注册表中是否存在指定服务
        if(registerMap.containsKey(key)) {
            // 获取到相应的提供者实例，然后调用其相应方法
            Object provider = registerMap.get(key);
            result = provider.getClass().getMethod(msg.getMethodName(), msg.getParamTypes())
                    .invoke(provider, msg.getParamValues());
        }
        ctx.writeAndFlush(result);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
