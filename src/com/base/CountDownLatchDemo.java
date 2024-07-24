package com.base;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "\tstart");
        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 9; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\tStart");
                countDownLatch.countDown(); // 计数器-1
            }, String.valueOf(i)).start();
        }
        //阻塞等待计数器归零
        System.out.println(Thread.currentThread().getName() + "我跑完了");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\tEnd");
    }

}