package com.Thred;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        // 使用自然排序（按年龄）  
        PriorityBlockingQueue<Person> ageQueue = new PriorityBlockingQueue<>();

        // 向队列中添加元素  
        ageQueue.offer(new Person("Alice", 30));
        ageQueue.offer(new Person("Bob", 20));
        ageQueue.offer(new Person("Charlie", 25));

        // 遍历并打印队列中的元素（按年龄排序）  
        System.out.println("按年龄排序的队列:");
        while (!ageQueue.isEmpty()) {
            Person person = ageQueue.poll();
            System.out.println(person);
        }

        Comparator<Person> nameComparator = (p1,p2) -> Integer.compare(p1.getName().length(),p2.getName().length());
        // 使用自定义排序（按名字长度）    初始容量
        PriorityBlockingQueue<Person> nameLengthQueue = new PriorityBlockingQueue<>(10,nameComparator);

        // 向队列中添加元素  
        nameLengthQueue.offer(new Person("David", 35)); // 名字长度为5  
        nameLengthQueue.offer(new Person("Eve", 50));   // 名字长度为3
        nameLengthQueue.offer(new Person("Frank", 40)); // 名字长度为5  

        // 遍历并打印队列中的元素（按名字长度排序）  
        System.out.println("\n按名字长度排序的队列:");
        while (!nameLengthQueue.isEmpty()) {
            Person person = nameLengthQueue.poll();
            System.out.println(person);
        }
    }

}