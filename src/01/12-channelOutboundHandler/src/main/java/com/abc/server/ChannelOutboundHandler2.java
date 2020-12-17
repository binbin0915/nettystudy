package com.abc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.concurrent.TimeUnit;

public class ChannelOutboundHandler2 extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg,
                      ChannelPromise promise) throws Exception {
        System.out.println("2222 " + msg);
        ctx.write(msg, promise);
    }

    // 当前处理器添加到pipeline中后就会触发该方法的执行
    // pipeline中的每一个处理器，只要它重写了handlerAdded()方法，那么只要其相应的
    // 处理器被添加到了pipeline，都会执行
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        ctx.executor().schedule(() -> {
            ctx.channel().write("Hello World 2222");
        }, 1, TimeUnit.SECONDS);
    }
}
