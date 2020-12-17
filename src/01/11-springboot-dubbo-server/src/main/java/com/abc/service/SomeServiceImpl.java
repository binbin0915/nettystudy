package com.abc.service;

import com.abc.rpc.api.SomeService;
import org.springframework.stereotype.Service;

// 服务的真正提供者
@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public String doSome(String depart) {
        return depart + "欢迎你！";
    }
}
