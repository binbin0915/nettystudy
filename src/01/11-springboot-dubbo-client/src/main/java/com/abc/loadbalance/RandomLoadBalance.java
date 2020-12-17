package com.abc.loadbalance;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomLoadBalance implements LoadBalance {

    @Override
    public String choose(List<String> servers) {
        int index = new Random().nextInt(servers.size());
        return servers.get(index);
    }
}
