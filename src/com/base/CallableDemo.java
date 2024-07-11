package com.base;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread); // 适配类

        new Thread(futureTask, "A").start(); // 调用执行
        // 第二次调用执行，在同一个futureTask对象，不输出结果，可理解为“缓存”
        new Thread(futureTask, "B").start();

        //get 方法获得返回结果! 一般放在最后一行！否则可能会阻塞
        Integer result = (Integer) futureTask.get(); // 获取返回值
        System.out.println(result);
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tcall 被调用");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
