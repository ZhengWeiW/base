package com.Thred;

import java.util.concurrent.*;

public class CompletableFutureThenComposeExample {

    public static void main(String[] args) throws Exception {
        // 假设我们有一个从数据库异步获取用户ID的方法
        CompletableFuture<Integer> userIdFuture = CompletableFuture.supplyAsync(() -> {
            // 模拟异步操作，比如从数据库查询用户ID
            try {
                Thread.sleep(1000); // 模拟耗时
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null; // 在实际情况下，可能需要更复杂的错误处理
            }
            return 1; // 假设查询到的用户ID为1
        });

        // 然后，我们想要使用这个用户ID去异步获取用户的详细信息
        // 注意：这里我们使用thenCompose来链式地处理两个异步操作
        CompletableFuture<String> userInfoFuture = userIdFuture.thenCompose(userId -> {
            // 根据用户ID异步获取用户信息
            return CompletableFuture.supplyAsync(() -> {
                // 模拟从另一个服务获取用户信息
                try {
                    Thread.sleep(500); // 模拟耗时
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null; // 在实际情况下，需要适当的错误处理
                }
                return "User ID: " + userId + ", Name: John Doe"; // 假设这是根据用户ID获取到的用户信息
            });
        });

        // 等待并打印用户信息
        String userInfo = userInfoFuture.get(); // 注意：get()会阻塞当前线程直到异步操作完成
        System.out.println(userInfo);

        // 如果你不想阻塞当前线程，可以使用CompletableFuture的其他方法（如thenAccept）来处理结果
        // userInfoFuture.thenAccept(System.out::println);
        // 注意：如果在这里不调用get()或join()，并且不处理结果（如通过thenAccept），那么主线程可能会立即结束，
        // 而异步操作可能还没有完成。在实际应用中，你可能需要确保异步操作有足够的时间来完成。
    }

    // 注意：在这个例子中，我们使用了supplyAsync来模拟异步操作。
    // 在实际应用中，这些异步操作可能来自网络请求、数据库查询等。
}