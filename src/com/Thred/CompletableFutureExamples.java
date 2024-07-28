package com.Thred;

import java.util.concurrent.*;


public class CompletableFutureExamples {

    public static void main(String[] args) throws Exception {
        // 1. 创建一个已完成的CompletableFuture
        CompletableFuture<String> completedFuture = CompletableFuture.completedFuture("message");
        System.out.println("Completed Future Value: " + completedFuture.getNow(null));

        // 2. 运行一个简单的异步阶段（这里为了简化，不直接测试异步完成）
        // 注意：直接在main线程中等待异步完成可能会阻塞main线程，这里只是演示如何创建
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            // 异步任务
            System.out.println("Running async task...");
            try {
                Thread.sleep(1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 注意：这里不等待runAsyncFuture完成，因为它会阻塞main线程

        // 3. 在前一个阶段上应用函数
        CompletableFuture<String> applyFuture = completedFuture
                .thenApply(s -> {
                    // 对结果进行大写转换
                    return s.toUpperCase();
                });
        System.out.println("Transformed Future Value: " + applyFuture.get());

        // 4. 异步地应用函数
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> applyAsyncFuture = completedFuture
                .thenApplyAsync(s -> {
                    // 异步执行大写转换
                    try {
                        Thread.sleep(500); // 模拟耗时操作
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return s.toUpperCase();
                }, executor);

        // 等待异步操作完成
        System.out.println("Async Transformed Future Value: " + applyAsyncFuture.get());

        // 关闭ExecutorService
        executor.shutdown();

        // 5. 使用定制的Executor异步应用函数（已在4中演示，不再重复）

        // 6. 链式处理
        CompletableFuture<String> chainFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World");

        // 等待链式操作完成（注意：这里可能会阻塞，但只是为了演示）
        // 实际上，更好的做法是不在这里等待，而是继续执行其他任务
        chainFuture.join(); // 或者使用get()，但会抛出异常

        // 7. 合并多个CompletableFuture的结果
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 2);

        CompletableFuture<Integer> sumFuture = future1.thenCombine(future2, Integer::sum);

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));

        // 由于sumFuture是异步的，我们需要等待它完成（仅为了演示）
        sumFuture.join();
    }

    // 注意：这里使用了JUnit的assertTrue和assertFalse作为示例，但在main方法中我们不需要它们
    // 因此，我已经将它们替换为System.out.println或直接从CompletableFuture获取结果

}
