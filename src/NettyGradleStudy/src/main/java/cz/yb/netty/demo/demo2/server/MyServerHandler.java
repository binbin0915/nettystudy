package cz.yb.netty.demo.demo2.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.util.UUID;


public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    /**
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //favicon
        System.out.println(ctx.channel().remoteAddress()+","+msg);
        ctx.channel().writeAndFlush("from server:"+ UUID.randomUUID());
//        if(msg instanceof HttpRequest){
//            HttpRequest req = (HttpRequest)msg;
//            System.out.println("url:"+req.getUri());
//            ByteBuf content = Unpooled.copiedBuffer("Helloworld", CharsetUtil.UTF_8);
//            FullHttpResponse rep = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,content);
//            rep.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
//            rep.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
//            ctx.writeAndFlush(rep);
//        }
    }

    /**
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
