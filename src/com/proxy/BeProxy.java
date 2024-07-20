package com.proxy;

public class BeProxy implements LogService {
    @Override
    public void logTime() {
        System.out.println("被代理类执行了~");
    }
}