package com.base;

import java.util.concurrent.Semaphore;

public class Mutil_Producer_ConsumerByCondition {


    public static void main(String[] args) {
        ResourceByCondition r = new ResourceByCondition();
        Mutil_Producer pro = new Mutil_Producer(r);
        Mutil_Consumer con = new Mutil_Consumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程

        t2.start();
        t3.start();
        t0.start();
        t1.start();
    }
}

/**
 * @decrition 生产者线程
 */
class Mutil_Producer implements Runnable {
    private ResourceByCondition r;

    Mutil_Producer(ResourceByCondition r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.product("北京烤鸭");
        }
    }
}

/**
 * @decrition 消费者线程
 */
class Mutil_Consumer implements Runnable {
    private ResourceByCondition r;

    Mutil_Consumer(ResourceByCondition r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.consume();
        }
    }
}
