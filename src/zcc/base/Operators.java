package zcc.base;

/**
 * @description:
 * @author: zcc
 * @createDate: 2024/7/19
 * @version: 1.0
 */
public class Operators {
    public static void main(String[] args) {
        int i = -1;
        System.out.println("初始数据：" + i);
        System.out.println("初始数据对应的二进制字符串：" + Integer.toBinaryString(i));
        i <<= 10;
        System.out.println("左移 10 位后的数据 " + i);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(i));

        int b = 1;
        System.out.println("初始数据：" + b);
        System.out.println("初始数据对应的二进制字符串：" + Integer.toBinaryString(b));
        b <<= 10;
        System.out.println("左移 10 位后的数据 " + b);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(b));

        int c = 1;
        System.out.println("初始数据：" + c);
        System.out.println("初始数据对应的二进制字符串：" + Integer.toBinaryString(c));
        c >>= 10;
        System.out.println("左移 10 位后的数据 " + c);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(c));


        int d = -1;
        System.out.println("初始数据：" + d);
        System.out.println("初始数据对应的二进制字符串：" + Integer.toBinaryString(d));
        d >>= 10;
        System.out.println("左移 10 位后的数据 " + d);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(d));

        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1==i2);
    }
}
