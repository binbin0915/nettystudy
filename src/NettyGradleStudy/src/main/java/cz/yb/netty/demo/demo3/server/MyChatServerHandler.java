package cz.yb.netty.demo.demo3.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.UUID;


public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    private  static ChannelGroup cg = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel c =ctx.channel();
        cg.forEach(ch->{
            if(ch!=c){
                ch.writeAndFlush(c.remoteAddress()+"发送的消息:"+msg+"\n");
            }
            else{
                ch.writeAndFlush("自己:"+msg+"\n");
            }
        });
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
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel c =ctx.channel();
        c.writeAndFlush("服务器-"+c.remoteAddress()+"上线了\n");

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel c =ctx.channel();
        c.writeAndFlush("服务器-"+c.remoteAddress()+"下线了\n");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel c =ctx.channel();
        c.writeAndFlush("服务器-"+c.remoteAddress()+"加入了\n");
        cg.add(c);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel c =ctx.channel();
        c.writeAndFlush("服务器-"+c.remoteAddress()+"断开了\n");
//        cg.remove(c);
    }
}
