package com.proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // 创建被代理对象
        LogService beProxy = new BeProxy();

        // 创建处理器，传入被代理对象
        LogInvocationHandler handler = new LogInvocationHandler(beProxy);

        // 创建代理对象
        LogService proxy = (LogService) Proxy.newProxyInstance(
                beProxy.getClass().getClassLoader(),
                beProxy.getClass().getInterfaces(),
                handler
        );

        // 调用代理对象的方法
        proxy.logTime();
    }
}