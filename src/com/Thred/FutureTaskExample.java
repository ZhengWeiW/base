package com.Thred;

/**
 * @description:
 * @author: zcc
 * @createDate: 2024/7/24
 * @version: 1.0
 */
import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        // 创建一个Callable任务
        Callable<String> callableTask = () -> {
            Thread.sleep(1000); // 模拟耗时操作
            return "任务完成";
        };

        // 使用FutureTask包装Callable任务
        FutureTask<String> futureTask = new FutureTask<>(callableTask);

        // 创建一个单线程的线程池来执行FutureTask
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(futureTask); // 提交FutureTask给线程池执行

        // 执行其他任务...
        System.out.println("等待任务完成...");

        // 等待FutureTask执行完成，并获取结果
        String result = futureTask.get(); // 这会阻塞，直到任务完成
        System.out.println("任务结果: " + result);

        // 关闭线程池
        executorService.shutdown();
    }
}
