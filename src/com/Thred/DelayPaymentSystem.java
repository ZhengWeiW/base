package com.Thred;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @description:
 * @author: zcc
 * @createDate: 2024/7/24
 * @version: 1.0
 */

public class DelayPaymentSystem {
    private DelayQueue<DelayPaymentTask> delayQueue = new DelayQueue<>();

    public void processPayment(String userId) {
        // 假设这里已经处理了支付请求，并设置了 30 分钟的延迟
        long delayTime = 1000L; // 30 分钟
        DelayPaymentTask task = new DelayPaymentTask(userId, delayTime);
        delayQueue.put(task);

        // 启动一个线程来不断从 DelayQueue 中取出并执行到期的任务
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    DelayPaymentTask taskToExecute = delayQueue.take(); // 阻塞直到有任务到期
                    // 执行任务，比如检查支付状态并发送通知
                    System.out.println("Checking payment for user -------------" + taskToExecute.getUserId());
                    // 这里可以添加检查支付状态并发送通知的逻辑
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    // 省略其他方法和属性
}