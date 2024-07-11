package com.base;

public final class FinalClass extends BaseClass {
    // FinalClass中可以定义自己的方法
    public void finalClassMethod() {
        System.out.println("This is a method from FinalClass");
    }

    // FinalClass不能被子类继承，所以这里不需要（也不能）定义其他子类可以重写的方法
    // 例如，我们不能定义一个非final的、非static的、非private的方法

    // main方法用于演示
    public static void main(String[] args) {
        // 创建FinalClass的实例
        FinalClass finalClassInstance = new FinalClass();

        // 调用基类的方法
        finalClassInstance.baseMethod();

        // 调用FinalClass自己的方法
        finalClassInstance.finalClassMethod();

        // 尝试创建FinalClass的子类（这将导致编译错误）
        // class SubClassOfFinal extends FinalClass {} // 这行代码会报错
    }
}
