package com.Thred;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // 创建ExecutorService来管理线程
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 创建两个CompletableFuture实例，模拟异步计算
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // 模拟耗时操作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Interrupted";
            }
            return "Result from future1";
        }, executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1); // 比future1更快完成
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Interrupted";
            }
            return "Result from future2";
        }, executor);

        /*
        acceptEither方法接收两个CompletableFuture实例和一个Consumer函数。当这两个CompletableFuture中的任何一个完成时，
        它会将那个完成的结果传递给Consumer函数，并忽略另一个CompletableFuture的结果。重要的是，Consumer函数的执行是同步的，
        即它会直接在调用线程中执行（如果调用线程没有被阻塞的话）
         */
        // 使用acceptEither处理结果
        CompletableFuture<Void> voidCompletableFuture = future1.acceptEither(future2, result -> {
            System.out.println("acceptEither result: " + result);
            // 这里是同步执行的，但可能在future1或future2的完成线程中
        });


        System.out.println("----acceptEitherAsync------");
        // 使用acceptEitherAsync处理结果，并指定Executor
        future1.acceptEitherAsync(future2, result -> {
            System.out.println("acceptEitherAsync result: " + result);
            // 这里是异步执行的，在指定的Executor的线程中
        }, executor);
        System.out.println("----acceptEitherAsync------");
        // 关闭ExecutorService（注意：这不会立即停止正在执行的任务）
        executor.shutdown();

        // 等待一段时间以确保CompletableFuture有足够的时间完成
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 注意：在实际应用中，你可能需要更复杂的逻辑来等待CompletableFuture完成
        // 例如，使用future.join()、future.get()（会阻塞）或CompletableFuture的其他组合方法
    }
}