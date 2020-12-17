package com.abc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChannelInboundHandler2 extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("2222 " + msg);
        ctx.fireChannelRead(msg);
    }


    // ctx.fireChannelRead(msg) 与pipeline.fireChannelRead(msg)都会触发
    // 下一个节点的fireChannelRead(msg)方法的执行，但不同的是，这下一个节点是谁是不一样的
    // ctx.fireChannelRead(msg)的下一个节点，就是pipeline上其真正的下一个节点
    // pipeline.fireChannelRead(msg)的下一个节点，是pipeline的head节点后的第一个节点
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().pipeline().fireChannelRead("Hello World 2222");
    }

}


