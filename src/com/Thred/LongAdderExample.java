package com.Thred;

/**
 * @description:
 * @author: zcc
 * @createDate: 2024/7/24
 * @version: 1.0
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建 LongAdder 实例
        LongAdder longAdder = new LongAdder();

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        final int taskCount = 100;
        CountDownLatch latch = new CountDownLatch(taskCount);

        // 提交多个任务进行累加操作
        for (int i = 0; i < taskCount; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                // 假设每个任务累加的值不同，这里简单使用 taskId
                longAdder.add(taskId);
                latch.countDown();
            });
        }

        latch.await();

        // 关闭线程池（注意：这不会等待所有任务完成）
        // 在实际使用中，你可能需要等待所有任务完成后再获取结果
        // 这里为了简化示例，我们直接等待一段时间
//        try {
//            Thread.sleep(1000); // 等待1秒，确保所有任务都执行完毕（这不是一个好的做法，仅用于示例）
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 获取并打印累加结果
        long total = longAdder.sum();
        System.out.println("Total sum: " + total);

        // 注意：在实际应用中，你应该使用更合适的方法来等待所有任务完成，
        // 例如使用 CountDownLatch、CyclicBarrier 或 Future 等工具。
        executorService.shutdown();

    }
}
