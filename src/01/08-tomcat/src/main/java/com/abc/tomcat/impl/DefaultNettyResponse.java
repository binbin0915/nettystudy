package com.abc.tomcat.impl;

import com.abc.servlet.NettyResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import io.netty.util.internal.StringUtil;

public class DefaultNettyResponse implements NettyResponse {
    private HttpRequest request;
    private ChannelHandlerContext context;

    public DefaultNettyResponse(ChannelHandlerContext context,
                                HttpRequest request) {
        this.request = request;
        this.context = context;
    }

    public void write(String content) throws Exception {
        if (StringUtil.isNullOrEmpty(content)) {
            return;
        }

        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(content.getBytes("UTF-8")));

        HttpHeaders headers = response.headers();
        headers.set(HttpHeaderNames.CONTENT_TYPE, "text/json");
        headers.set(HttpHeaderNames.CONTENT_LENGTH,
                           response.content().readableBytes());
        headers.set(HttpHeaderNames.EXPIRES,0);
        if(HttpUtil.isKeepAlive(request)) {
            headers.set(HttpHeaderNames.CONNECTION,
                                   HttpHeaderValues.KEEP_ALIVE);
        }
        context.writeAndFlush(response);
    }
}
