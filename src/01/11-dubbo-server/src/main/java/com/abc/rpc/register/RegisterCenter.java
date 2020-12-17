package com.abc.rpc.register;

/**
 * 注册规范
 */
public interface RegisterCenter {
    /**
     *
     * @param serviceName     业务接口
     * @param serviceAddress  ip:port:实现类名
     */
    void register(String serviceName, String serviceAddress) throws Exception;
}
