package com.abc.rpc.service;

public class AlipaySomeService implements SomeService {
    @Override
    public String hello(String name) {
        return name + "欢迎你！--- AlipaySomeService";
    }
}
