package com.abc.discovery;

import com.abc.loadbalance.LoadBalance;
import com.abc.rpc.api.ZkConstant;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ServiceDiscoveryImpl implements ServiceDiscovery {

    @Autowired
    private LoadBalance loadBalance;

    private CuratorFramework curator;
    private List<String> servers = Collections.synchronizedList(new ArrayList<>());

    public ServiceDiscoveryImpl() {
        this.curator = CuratorFrameworkFactory.builder()
                .connectString(ZkConstant.ZK_CLUSTER)
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        this.curator.start();
    }

    @Override
    public String discovery(String servcieName) throws Exception {
        String servicePath = ZkConstant.ZK_DUBBO_ROOT_PATH + servcieName;
        servers = curator.getChildren().forPath(servicePath);
        if(servers.size() == 0) {
            return null;
        }
        registerWatcher(servicePath);
        return loadBalance.choose(servers);
    }

    private void registerWatcher(String servicePath) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(curator, servicePath, true);

        cache.getListenable().addListener((client, event) -> {
            servers = curator.getChildren().forPath(servicePath);
        });

        cache.start();
    }
}
