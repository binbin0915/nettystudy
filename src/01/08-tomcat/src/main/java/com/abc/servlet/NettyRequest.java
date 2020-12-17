package com.abc.servlet;

import java.util.List;
import java.util.Map;

// 定义请求接口
public interface NettyRequest {
    String getUri();
    String getMethod();
    Map<String, List<String>> getParameters();
    List<String> getParameters(String name);
    String getParameter(String name);
    String getPath();
}
