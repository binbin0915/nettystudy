package cz.yb.netty.demo.demo6.client;

import cz.yb.protobuf.DataInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class MyChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline cp =ch.pipeline();
        cp.addLast(new ProtobufVarint32FrameDecoder());
        cp.addLast(new ProtobufDecoder(DataInfo.MyMessage.getDefaultInstance()));
        cp.addLast(new ProtobufVarint32LengthFieldPrepender());
        cp.addLast(new ProtobufEncoder());
        cp.addLast(new MyChatClientHandler());
    }
}
