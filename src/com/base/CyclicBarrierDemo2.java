package com.base;

import zcc.base.Thread2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: zcc
 * @createDate: 2024/7/17
 * @version: 1.0
 */
public class CyclicBarrierDemo2 {
    public static void main(String[] args) {
//        // CyclicBarrier(int parties, Runnable barrierAction)
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
//            System.out.println(Thread.currentThread().getName() +"-----------召唤神龙成功");
//        });
        Thread2 Thread2 = new Thread2();
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(7, Thread2);
        for (int i = 1; i <= 14; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +
                        "收集了第" + tempInt + "颗龙珠");

                try {
                    cyclicBarrier1.await(); // 等待 +1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
