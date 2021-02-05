package cz.yb.netty.demo.demo6.server;

import cz.yb.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class MyServerHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    /**
     * @param myMessage
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage myMessage) throws Exception {
        //favicon
        System.out.println(ctx.channel().remoteAddress()+","+myMessage.getDataType());
//        ctx.channel().writeAndFlush(new TextWebSocketFrame("Server time:"+ LocalDateTime.now()));
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

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded:"+ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved:"+ctx.channel().id().asLongText());
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
