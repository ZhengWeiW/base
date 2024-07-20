package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 1.获取Class类对象
 * Class clazz = Class.forName("全类名“)；
 * Class clazz = 对象.getClass();
 * Class clazz = 类名.class;
 * 2.获取构造器
 * Constructor oct = clazz.getDeclaredConstructor();
 * 3.创建对象
 * Object obj = oct.newInstance();
 */
public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // 创建 MyClass 的一个实例
            MyClass myObject = new MyClass();

            // 获取 MyClass 类的 Class 对象
            Class<?> clazz = myObject.getClass();

            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            MyClass myObject2 =(MyClass) declaredConstructor.newInstance();

            String myField = myObject2.getMyField();
            String testField = myObject2.getTestField();
            System.out.println("--------"+myField);
            // 通过 Class 对象获取名为 "myField" 的字段
            Field field = clazz.getDeclaredField("myField");

            // 设置为可访问（即使它是私有的）
            field.setAccessible(true);

            // 获取当前字段的值（可选，仅用于演示）
            String oldValue = (String) field.get(myObject);
            System.out.println("Old value: " + oldValue);

            // 修改字段的值
            field.set(myObject, "new value");

            // 打印修改后的对象状态
            System.out.println("Modified object: " + myObject);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}