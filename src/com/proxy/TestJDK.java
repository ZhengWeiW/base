package com.proxy;

import java.lang.reflect.Proxy;

public class TestJDK {
    public static void main(String[] args) {
        // 创建被代理对象
        LogServiceJDK beProxy = new BeProxyJDK();

        // 创建处理器，传入被代理对象
        LogInvocationHandlerJDK handler = new LogInvocationHandlerJDK(beProxy);

        // 创建代理对象
        LogServiceJDK proxy = (LogServiceJDK) Proxy.newProxyInstance(
                beProxy.getClass().getClassLoader(),
                beProxy.getClass().getInterfaces(),
                handler
        );

        // 调用代理对象的方法
        proxy.logTime();
    }
}