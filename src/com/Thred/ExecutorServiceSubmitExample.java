package com.Thred;

/**
 * @description:
 * @author: zcc
 * @createDate: 2024/7/24
 * @version: 1.0
 */
import java.util.concurrent.*;

public class ExecutorServiceSubmitExample {
    public static void main(String[] args) throws Exception {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 提交一个Callable任务给线程池执行，并获取返回的Future对象
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(1000); // 模拟耗时操作
            return "通过ExecutorService.submit提交的任务完成";
        });

        // 执行其他任务...
        System.out.println("等待任务完成...");

        // 等待Future对象表示的任务完成，并获取结果
        String result = future.get(); // 这会阻塞，直到任务完成
        System.out.println("任务结果: " + result);


        // 关闭线程池
        executorService.shutdown();
    }
}
