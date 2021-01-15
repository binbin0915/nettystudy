package cz.yb.netty.demo.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;


public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    /**
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        //favicon
        System.out.println(msg.getClass());
        if(msg instanceof HttpRequest){
            HttpRequest req = (HttpRequest)msg;
            System.out.println("url:"+req.getUri());
            ByteBuf content = Unpooled.copiedBuffer("Helloworld", CharsetUtil.UTF_8);
            FullHttpResponse rep = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,content);
            rep.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            rep.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
            ctx.writeAndFlush(rep);
        }
    }
}
