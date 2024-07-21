package com.proxy;

public class BeProxyJDK implements LogServiceJDK {
    @Override
    public void logTime() {
        System.out.println("被代理类执行了~");
    }
}