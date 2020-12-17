package com.abc.tomcat.impl;


import com.abc.servlet.NettyRequest;
import com.abc.servlet.NettyResponse;
import com.abc.servlet.Servnet;

// 默认Servnet
public class DefaultServnet extends Servnet {
    @Override
    public void doGet(NettyRequest request,
                      NettyResponse response) throws Exception {
        String servnetName = request.getUri().split("/")[1];
        String content = "404 - no this Servnet:" + servnetName;
        response.write(content);
    }

    @Override
    public void doPost(NettyRequest request,
                       NettyResponse response) throws Exception{
        doGet(request, response);
    }
}
