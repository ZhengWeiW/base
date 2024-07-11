package com.base;


public class ClassloaderAndForNameTest {
    public static void main(String[] args) {
        String wholeNameLine = "com.base.Line";
        System.out.println("下面是测试Classloader的效果");// 不初始化静态代码块
        testClassloader(wholeNameLine);
        System.out.println("----------------------------------");
        System.out.println("下面是测试Class.forName的效果");// 初始化静态代码块
        testForName(wholeNameLine);

        ClassLoadTest.Test();

    }

    /**
     * classloader
     * @param wholeNameLine
     */
    private static void testClassloader(String wholeNameLine) {
        Class<?> line;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            line = loader.loadClass(wholeNameLine);
            System.out.println("line " + line.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class.forName
     * @param wholeNameLine
     */
    private static void testForName(String wholeNameLine) {
        try {
            Class<?> line = Class.forName(wholeNameLine);
            System.out.println("line   " + line.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
