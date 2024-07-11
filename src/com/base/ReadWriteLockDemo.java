package com.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    /**
     * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
     * 但是，如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写。
     * 1. 读-读 可以共存
     * 2. 读-写 不能共存
     * 3. 写-写 不能共存
     */
    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
        // 写
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        // 读
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }

}

// 测试发现问题: 写入的时候，还没写入完成，会存在其他的写入！造成问题
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " 写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + " 写入成功!");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + " 读取" + key);
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读取结果：" + result);
    }
}

// 加锁
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // 读写锁

    public void put(String key, Object value) {
        // 写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入成功!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        // 读锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 读取" + key);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取结果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
