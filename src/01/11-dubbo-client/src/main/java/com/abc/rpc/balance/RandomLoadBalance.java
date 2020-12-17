package com.abc.rpc.balance;

import java.util.List;
import java.util.Random;

/**
 * 随机负载均衡策略
 */
public class RandomLoadBalance implements LoadBalance {
    @Override
    public String choose(List<String> servers) {
        return servers.get(new Random().nextInt(servers.size()));
    }
}
