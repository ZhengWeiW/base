package com.base;

import zcc.base.Thread2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
* @Description:  CyclicBarrier 与 CountDownLatch 都能实现阻塞主线程的效果，
 * CountDownLatch 是-1，CyclicBarrier 是+1，并且CyclicBarrier是可以重复使用，CountDownLatch不可以重复使用，
 * CyclicBarrier结束以后，主线程处理后续，CyclicBarrier最后完成的线程处理后续
* @Param:
* @return:
* @Author: zcc
* @Date: 11:08 2024/7/17
*/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() +"-----------开始 ");
        // CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println(Thread.currentThread().getName() +"-----------召唤神龙成功");
        });
        for (int i = 1; i <= 15; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +
                        "收集了第" + tempInt + "颗龙珠");

                try {
                    cyclicBarrier.await(); // 等待 +1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
            System.out.println(Thread.currentThread().getName() +"-----------结束 ");
        }

    }
}
