package com.abc.rpc.balance;

import java.util.List;

/**
 * 负载均衡规范
 */
public interface LoadBalance {

    String choose(List<String> servers);
}
