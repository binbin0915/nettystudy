package com.abc.rpc.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Invocation implements Serializable {
    /**
     * 业务接口名
     */
    private String className;
    /**
     * 远程调用方法名
     */
    private String methodName;
    /**
     * 方法参数类型列表
     */
    private Class<?>[] paramTypes;
    /**
     * 方法参数值
     */
    private Object[] paramValues;
    /**
     * 要调用的实现类名的前辍
     */
    private String prefix;
}
