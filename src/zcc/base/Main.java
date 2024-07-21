package zcc.base;


/**
 * 基本数据类型( byte、boolean、short、char、int、float、long、double)以及字符串常量。
 * final 修饰的基本数据类型和字符串变量
 * 字符串通过 “+”拼接得到的字符串、基本数据类型之间算数运算（加减乘除）、基本数据类型的位运算（<<、>>、>>> ）
 *
 */
public class Main {
    static String str1 = "str";
    static String str2 = getStr();
    public static void main(String[] args) {

        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 在堆上创建的新的对象

        System.out.println(c == d);

        final String str3 = "str";
        final String str4 = getStr();
        String e = "str" + "ing";// 常量池中的对象
        String f = str3 + str4; // 在堆上创建的新的对象
        System.out.println(e == f);//false


        final String str6 = "str";
        final String str7 = "ing";
        // 下面两个表达式其实是等价的
        String o = "str" + "ing";// 常量池中的对象
        String p = str6 + str7; // 常量池中的对象
        System.out.println(o == p);// true


    }

    public static String getStr() {
        return "ing";
    }
}
