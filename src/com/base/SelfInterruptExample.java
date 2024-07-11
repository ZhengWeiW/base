package com.base;

import java.util.concurrent.atomic.AtomicInteger;

public class SelfInterruptExample {
    public static void main(String[] args) {

        AtomicInteger num = new AtomicInteger();
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // 执行某些耗时操作或等待操作
                try {
                    num.set(num.get() + 1);
                    Thread.sleep(1000); // 模拟等待操作
                    System.out.println("-------------"+num);
                    System.out.println("-------------"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    // 当线程被中断时，会抛出 InterruptedException 异常
                    // 在这里重新设置中断状态，以便后续结束线程的执行
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();

        // 在一定条件下，中断线程的执行
        if (num.get() ==5) {
            thread.interrupt(); // 中断线程
        }
    }
}