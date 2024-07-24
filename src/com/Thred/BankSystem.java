package com.Thred;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BankSystem {
    private final Account accountA = new Account(1000); // 初始余额1000
    private final Account accountB = new Account(0, true); // 初始余额0，且被冻结
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition sufficientFunds = lock.newCondition();
    private final Condition accountBNotFrozen = lock.newCondition();

    public void transfer(double amount) throws InterruptedException {
        lock.lock();
        try {
            while (accountA.getBalance() < amount || accountB.isFrozen()) {
                if (accountA.getBalance() < amount) {
                    sufficientFunds.await(); // 等待账户A有足够余额
                }
                if (accountB.isFrozen()) {
                    accountBNotFrozen.await(); // 等待账户B未冻结
                }
            }

            // 执行转账操作
            accountA.debit(amount);
            accountB.credit(amount);

            System.out.println("Transfer of " + amount + " successful from A to B.");
            System.out.println(accountA.getBalance());
            System.out.println(accountB.getBalance());
        } finally {
            lock.unlock();
        }
    }

    public static class Account {
        private double balance;
        private boolean frozen;

        public Account(double balance) {
            this.balance = balance;
            this.frozen = false;
        }

        public Account(double balance, boolean frozen) {
            this.balance = balance;
            this.frozen = frozen;
        }

        public synchronized double getBalance() {
            return balance;
        }

        public synchronized void debit(double amount) {
            if (balance >= amount) {
                balance -= amount;
            }
        }

        public synchronized void credit(double amount) {
            balance += amount;
        }

        public synchronized boolean isFrozen() {
            return frozen;
        }

        public synchronized void unfreeze() {
            frozen = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankSystem bankSystem = new BankSystem();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 转账线程
        executor.submit(() -> {
            try {
                bankSystem.transfer(500); // 尝试转账500，应该失败并等待
                Thread.sleep(1000); // 假设稍后余额会增加
                bankSystem.transfer(1500); // 再次尝试转账500，现在应该成功
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 增加账户A余额的线程
        executor.submit(() -> {
            try {
                Thread.sleep(500); // 等待一段时间以模拟异步操作
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (bankSystem.accountA) {
                bankSystem.accountA.debit(-1000); // 假设通过某种方式增加了余额
                bankSystem.lock.lock();
                try {
                    bankSystem.sufficientFunds.signalAll(); // 唤醒等待的线程
                } finally {
                    bankSystem.lock.unlock();
                }
            }
        });

        // 解冻账户B的线程
        executor.submit(() -> {
            try {
                Thread.sleep(250); // 等待一段时间以模拟异步操作
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (bankSystem.accountB) {
                bankSystem.accountB.unfreeze(); // 解冻账户B
                bankSystem.lock.lock();
                try {
                    bankSystem.accountBNotFrozen.signalAll(); // 唤醒等待的线程
                } finally {
                    bankSystem.lock.unlock();
                }
            }
        });

        executor.shutdown();
        while (!executor.isTerminated()) {
            // 等待所有任务完成
        }
    }
}
