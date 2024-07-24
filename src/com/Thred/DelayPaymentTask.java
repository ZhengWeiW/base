package com.Thred;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zcc
 * @createDate: 2024/7/24
 * @version: 1.0
 */
public class DelayPaymentTask implements Delayed {

    private String userId; // 用户ID
    private long executeTime; // 执行时间

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public DelayPaymentTask(String userId, long delayTime) {
        this.userId = userId;
        this.executeTime = System.currentTimeMillis() + delayTime; // 设置执行时间为当前时间加上延迟时间
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);

    }

    @Override
    public int compareTo(Delayed o) {

        DelayPaymentTask that = (DelayPaymentTask) o;
        if (this.executeTime < that.executeTime) {
            return -1;
        }
        if (this.executeTime > that.executeTime) {
            return 1;
        }
        return 0;
    }
}
