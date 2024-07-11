package com.base;

public class JMMVolatileDemo01 {
    /**
     * Volatile 用来保证数据的同步，也就是可见性
     * 不加 volatile 就没有可见性，会一直循环
     */
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (num == 0) {
                System.out.println("-----------------------"+num);
            }
        }).start();
        Thread.sleep(10);
        System.out.println("-----------------------");


        num = 1;
        System.out.println(num);
    }
}
