package cz.yb.netty.demo.demo1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer  extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline cp =ch.pipeline();
        cp.addLast("httpServerCodec",new HttpServerCodec());
        cp.addLast("testHttpServerHandler",new TestHttpServerHandler());

    }
}
