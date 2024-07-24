package com.Thred;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerExample2 {

    // 共享的队列
    private final Queue<Integer> queue = new LinkedList<>();
    // 锁
    private final Lock lock = new ReentrantLock();
    // 消费者等待条件
    private final Condition notEmpty = lock.newCondition();
    // 生产者等待条件
    private final Condition notFull = lock.newCondition();
    // 队列的容量限制
    private final int capacity = 110;

    // 生产者线程
    class Producer implements Runnable {
        public void run() {
            int product = 0;
            while (true) {
                lock.lock();
                try {

                    // 检查队列是否已满
                    while (queue.size() == capacity) {
                        System.out.println("----Producer-------");
                        notFull.await(); // 等待队列不满
                        System.out.println("--------------");
                        System.out.println("*******************"+Thread.currentThread().getName());
                    }
                    // 生产产品
                    queue.add(product++);
                    System.out.println("Produced: " + product);
                    System.out.println("Produced******大小: " + queue.size());

                    // 通知消费者
                    //notEmpty.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
                try {
                    // 模拟生产时间
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // 消费者线程
    class Consumer implements Runnable {
        public void run() {
            System.out.println("111111111111111111");
            while (true) {
                lock.lock();
                try {

                    // 检查队列是否为空
                    while (queue.isEmpty()) {
                        System.out.println("----Consumer-------");
                        notEmpty.await(); // 等待队列非空

                    }
                    System.out.println("---------------------"+Thread.currentThread().getName());
                    // 消费产品
                    Integer item = queue.poll();
                    System.out.println("Consumed: " + item);
                    System.out.println("Consumed----大小: " + queue.size());
                    // 通知生产者
                    notFull.signal();  //是为了唤醒在notFull.await(); 处阻塞的线程
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
                try {
                    // 模拟消费时间
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample2 example = new ProducerConsumerExample2();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 3L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.submit(example.new Producer());
        System.out.println("??????????????????????????");

        threadPoolExecutor.submit(example.new Producer());
        threadPoolExecutor.submit(example.new Consumer());
        System.out.println("22222222222222222");
//        // 创建并启动生产者线程
//        Producer producer = example.new Producer();
//        producer.start();
//
//        // 创建并启动消费者线程
//        Consumer consumer = example.new Consumer();
//        consumer.start();
    }
}
