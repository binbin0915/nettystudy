package com.abc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChannelInboundHandler3 extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("3333 " + msg);
        ctx.fireChannelRead(msg);
    }

    // @Override
    // public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //     ctx.channel().pipeline().fireChannelRead("Hello World 3333");
    // }

}



