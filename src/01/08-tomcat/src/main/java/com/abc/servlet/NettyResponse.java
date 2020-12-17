package com.abc.servlet;

// 定义响应接口
public interface NettyResponse {
    void write(String content) throws Exception;
}
