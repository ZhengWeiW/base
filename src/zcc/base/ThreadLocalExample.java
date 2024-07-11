package zcc.base;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalExample {

    // 创建一个ThreadLocal变量，用来存储每个线程的用户ID
    private static final ThreadLocal<Integer> userId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            // 初始化时，为每个线程分配一个随机的用户ID（这里仅为示例）
            return ThreadLocalRandom.current().nextInt(1000, 10000); // 生成1000到9999之间的随机数
        }
    };

    public static void processUser() {
        // 获取当前线程的用户ID
        Integer currentUserId = userId.get();
        System.out.println("Processing user ID: " + currentUserId + " by thread: " + Thread.currentThread().getName());

        // 假设这里有一些业务逻辑处理
        try {
            // 模拟业务处理耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 清理工作（可选），在实际应用中，如果ThreadLocal变量存储的是复杂对象，建议在不再需要时显式清除，避免内存泄漏
        // userId.remove();
    }

    public static void main(String[] args) {
        // 创建并启动多个线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                processUser();
            }, "Thread-" + (i + 1)).start();
        }
    }
}