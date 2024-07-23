package com.Thred;

public class Person2 implements Comparable<Person2>{
    private int age;
    private String name;



    public Person2(String name, int age) {
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
    public int compareTo(Person2 other) {
        // 升序排序，根据年龄
        return Integer.compare(this.age, other.age);
    }

}
