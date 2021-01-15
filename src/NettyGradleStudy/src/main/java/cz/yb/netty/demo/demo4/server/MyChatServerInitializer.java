package cz.yb.netty.demo.demo4.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import io.netty.handler.timeout.IdleStateHandler;


import java.util.concurrent.TimeUnit;

public class MyChatServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline cp =ch.pipeline();
        //空闲检测
        cp.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));
        cp.addLast(new MyChatServerHandler());
    }
}
