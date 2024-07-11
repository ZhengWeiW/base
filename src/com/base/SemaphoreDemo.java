package com.base;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟资源类，有3个空车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) { // 模拟6个车
            new Thread(() -> {
                try {
                    semaphore.acquire(); // acquire 得到
                    System.out.println(Thread.currentThread().getName() + " 抢到了车位");

                    TimeUnit.SECONDS.sleep(new Random().nextInt(10)); // 停3秒钟
                    System.out.println(Thread.currentThread().getName() + " 离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // 释放这个位置
                }
            }, String.valueOf(i)).start();

        }

    }
}
