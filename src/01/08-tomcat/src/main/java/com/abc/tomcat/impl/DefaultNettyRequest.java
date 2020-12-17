package com.abc.tomcat.impl;

import com.abc.servlet.NettyRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class DefaultNettyRequest implements NettyRequest {

    private HttpRequest request;

    public DefaultNettyRequest(HttpRequest request) {
        this.request = request;
    }

    public String getUri() {
        return request.uri();
    }

    public String getMethod() {
        return request.method().name();
    }

    public Map<String, List<String>> getParameters() {
        QueryStringDecoder decoder =
                new QueryStringDecoder(request.uri());
        return decoder.parameters();
    }

    public List<String> getParameters(String name) {
        Map<String, List<String>> parameters =
                                   this.getParameters();
        List<String> parameter = parameters.get(name);
        return parameter;
    }

    public String getParameter(String name) {
        List<String> list = this.getParameters(name);
        if(list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public String getPath() {
        QueryStringDecoder decoder =
                    new QueryStringDecoder(request.uri());
        return decoder.path();
    }
}
