package com.Thred;

import java.util.concurrent.Callable;

public class PrioritizedTask implements Comparable<PrioritizedTask> {
    private final int priority;
    private final Callable<String> task;

    public PrioritizedTask(int priority, Callable<String> task) {
        this.priority = priority;
        this.task = task;
    }

    @Override
    public int compareTo(PrioritizedTask other) {
        return Integer.compare(this.priority, other.priority);
    }

    // 获取 Callable 对象的方法（如果需要的话）
    public Callable<String> getTask() {
        return task;
    }
}
