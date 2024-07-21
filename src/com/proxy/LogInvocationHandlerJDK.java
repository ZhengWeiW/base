package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandlerJDK implements InvocationHandler {
    // 持有被代理对象的引用
    private Object target;

    public LogInvocationHandlerJDK(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法调用前的处理
        System.out.println("代理对象开始执行: " + method.getName());

        // 反射调用被代理对象的方法
        Object result = method.invoke(target, args);

        // 方法调用后的处理
        System.out.println("代理对象结束执行: " + method.getName());

        return result;
    }
}