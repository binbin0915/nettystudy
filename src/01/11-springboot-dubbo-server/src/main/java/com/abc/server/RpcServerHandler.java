package com.abc.server;

import com.abc.dto.InvokeMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RpcServerHandler extends ChannelInboundHandlerAdapter {
    private Map<String, Object> registryMap;
    public RpcServerHandler(Map<String, Object> registryMap) {
        this.registryMap = registryMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if(msg instanceof InvokeMessage) {
            Object result = "没有指定的提供者";
            InvokeMessage message = (InvokeMessage) msg;
            if(registryMap.containsKey(message.getServiceName())) {
                Object provider = registryMap.get(message.getServiceName());
                result = provider.getClass()
                        .getMethod(message.getMethodName(), message.getParamTypes())
                        .invoke(provider, message.getParamValues());
            }
            ctx.writeAndFlush(result);
            ctx.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
