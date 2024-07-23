package com.Thred;

public class Person implements Runnable, Comparable<Person>{
    private int age;
    private String name;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PriorityBlockingQueuePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        // 升序排序，根据年龄
        return Integer.compare(this.age, other.age);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始执行 " + name + "，优先级 ");
        try {
            // 模拟任务执行时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " 完成执行 " + name);

    }
}
