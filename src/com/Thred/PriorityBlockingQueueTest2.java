package com.Thred;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueTest2 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool =  new ThreadPoolExecutor(1, 2, 3L,
                TimeUnit.SECONDS, new PriorityBlockingQueue<>(5),
                new ThreadPoolExecutor.AbortPolicy());


        pool.execute(new Person("6",7));
        pool.execute(new Person("5",5));
        pool.execute(new Person("4",4));
        pool.execute(new Person("8",8));
        pool.execute(new Person("2",2));
        pool.execute(new Person("3",3));
        pool.execute(new Person("1",1));

        PriorityBlockingQueue<PrioritizedTask> queue = new PriorityBlockingQueue<>();
        queue.add(new PrioritizedTask(1,()->"12"));
        queue.add(new PrioritizedTask(1, ()-> "Low Priority Task"));
        //Person2 必须实现Callable 方法  submit方法用于提交一个Runnable、Callable或FutureTask任务给线程池执行。
//        for(int i = 10; i>0 ;i++){
//
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " Person2开始执行 " + 1 + "，优先级 ");
//                    try {
//                        // 模拟任务执行时间
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                    }
//                    System.out.println(Thread.currentThread().getName() + " Person2完成执行 " + 1);
//                }
//            },new Person2(String.valueOf(i),i));
//        }

        try {
            Thread.sleep(5000); // 等待足够长的时间以查看输出结果
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        pool.shutdown();
    }


}
