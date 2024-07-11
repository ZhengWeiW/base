package com.base;

public class ClassLoadTest {

    public static void Test(){
        System.out.println("测试顺序");
    }

    {
        num2 = 100; //4
        System.out.println("num2");
    }

    public int num2 = 60; //5

    static {
        num1 = 20;  // 1
    }

    public static int num1 = 10; //2

    public ClassLoadTest(){
        System.out.println("构造方法");
    }

    public ClassLoadTest(int num2) {
        System.out.println("构造方法2");
    }

    public static void main(String[] arges){
        ClassLoadTest classLoadTest = new ClassLoadTest();  //3,6
        System.out.println(ClassLoadTest.num1); //7
        System.out.println(classLoadTest.num2);  //8
        System.out.println(num1);

    }



    /**
    1.父类静态变量和静态语句块（执行顺序由代码编写顺序确定）初始化
    2.子类静态变量和静态语句块（执行顺序由代码编写顺序确定）初始化,
    3.父类实例变量和语句块（执行顺序由代码编写顺序确定）初始化
    4.父类构造函数
    5.子类实例变量和语句块（执行顺序由代码编写顺序确定）初始化
    6.子类构造函数

     如果调用类的静态方法ClassLoadTest.Test();顺序为 静态代码块或静态变量 -->  静态方法

     private final static int num1 = 10;
     这个变量是一个final、static的基本类型变量，并且它的值是一个编译时常量表达式（即10）。因此，它的值会在类加载的准备阶段被赋值完成。
     private static int num1 = 10;
     这个变量是一个static但非final的基本类型变量。虽然它有一个初始值10，但这个赋值操作不会在准备阶段完成，而是在类加载的初始化阶段。当类的<clinit>()方法被调用时，这个赋值操作会发生。
     private final int num1 = 10;
     这个变量是一个final但非static的实例变量。这意味着它不是类的属性，而是每个对象的属性。这个赋值不会在类加载的任何阶段发生，而是在创建对象（即调用构造方法）的时候。在构造方法中，或者如果使用了实例初始化块，这个赋值操作会发生。
     总结：

     final static且是编译时常量表达式的变量在准备阶段赋值。
     static但非final的变量在初始化阶段赋值。
     final但非static的变量在创建对象时（构造方法或实例初始化块中）赋值。
     */
}
