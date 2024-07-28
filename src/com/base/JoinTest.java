package com.base;

public class JoinTest {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            try {
                // 模拟耗时操作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行完毕");
        });

        thread.start();
        System.out.println("----------"+Thread.currentThread().getName());
        try {
            // 等待线程执行完毕
            thread.join();
            System.out.println("----------"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程继续执行");
    }

}
