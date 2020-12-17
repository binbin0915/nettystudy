package com.abc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChannelInboundHandler1 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("1111 " + msg);
        ctx.fireChannelRead(msg);
    }

    // 当channel被激活时会触发该方法的执行，但只会执行channel中第一个处理器的该方法
    // @Override
    // public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //     ctx.channel().pipeline().fireChannelRead("Hello World 1111");
    // }

}
