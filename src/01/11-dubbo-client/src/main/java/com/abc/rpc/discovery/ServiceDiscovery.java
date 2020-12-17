package com.abc.rpc.discovery;

/**
 * 服务发现规范
 */
public interface ServiceDiscovery {
    /**
     *
     * @param serviceName  服务名称
     * @return  返回负载均衡后的主机信息，格式是 ip:port:实现类名
     */
    String discovery(String serviceName) throws Exception;
}
