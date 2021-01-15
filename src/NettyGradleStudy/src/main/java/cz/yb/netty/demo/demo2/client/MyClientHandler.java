package cz.yb.netty.demo.demo2.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;


public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    /**
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //favicon
        System.out.println(ctx.channel().remoteAddress()+","+msg);
        ctx.channel().writeAndFlush("from Client:"+ UUID.randomUUID());
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

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("from client hello");
    }
}
