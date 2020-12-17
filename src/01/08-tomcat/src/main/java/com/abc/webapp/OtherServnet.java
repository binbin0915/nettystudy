package com.abc.webapp;


import com.abc.servlet.NettyRequest;
import com.abc.servlet.NettyResponse;
import com.abc.servlet.Servnet;

public class OtherServnet extends Servnet {
    @Override
    public void doGet(NettyRequest request,
                      NettyResponse response) throws Exception {
        String param = request.getParameter("name");
        String uri = request.getUri();
        String method = request.getMethod();
        String path = request.getPath();

        String content = "method = " + method + "\n" +
                         "uri = " + uri + "\n" +
                         "path = " + path + "\n" +
                         "param = " + param;
        response.write(content);
    }

    @Override
    public void doPost(NettyRequest request,
                       NettyResponse response) throws Exception{
        doGet(request, response);
    }
}
