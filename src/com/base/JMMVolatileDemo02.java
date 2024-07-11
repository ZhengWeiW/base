package com.base;


import java.util.concurrent.atomic.AtomicInteger;

public class JMMVolatileDemo02 {
    private volatile static int num = 0;
    private volatile static AtomicInteger num2 = new AtomicInteger(0);
    private static AtomicInteger num3 = new AtomicInteger(0);

    public  static void add() {
        num++;
    }
    public  static void add2() {
        num2.incrementAndGet();
    }

    public  static void add3() {
        num3.incrementAndGet();
    }

    // 结果应该是 num 为 2万，测试看结果
    public static void main(String[] args) throws InterruptedException {
        long starTime = System.currentTimeMillis();
        System.out.println("------------------------"+starTime);
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    add();
                    add2();
                    add3();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都全部计算完毕，看最终结果
        // 默认一个 main线程 一个 gc 线程
        while (Thread.activeCount() > 2) {
            System.out.println("------------------------"+Thread.activeCount());
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
        System.out.println(Thread.currentThread().getName() + " " + num2);
        System.out.println(Thread.currentThread().getName() + " " + num3);

    }
}
