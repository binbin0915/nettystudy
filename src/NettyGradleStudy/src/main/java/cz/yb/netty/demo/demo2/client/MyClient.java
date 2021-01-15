package cz.yb.netty.demo.demo2.client;

import io.netty.bootstrap.Bootstrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {
    public  static  void  main(String[] args) {
        EventLoopGroup eventGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventGroup).channel(NioSocketChannel.class).handler(new MyClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1",8888).sync();
            channelFuture.channel().closeFuture().sync();
        }
        catch (Exception ex) {
            eventGroup.shutdownGracefully();
        }
    }
}
