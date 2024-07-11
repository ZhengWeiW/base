package com.base;

public class StringTest01 {
    public static void main(String[] args) {
        String s = new String("1");
        //s.intern();
        String ss5 = s.intern();
        String ss2 = "1";
        System.out.println(ss5== ss2); //true
        System.out.println(s == ss2); //false

        String ss3 = new String("1") + new String("1");
        ss3.intern();
        String ss4 = "11";
        System.out.println(ss3 == ss4); //true


        String s1 = "test";
        String s2 = "test";
        System.out.println("s1和s2是同一个字符串" + (s1 == s2));//true

        String s3 = new String("test");
        System.out.println("s1和s3是同一个字符串" + (s1 == s3));//false
        String s4 = "tes" + "t";
        System.out.println("s1和s4是同一个字符串" + (s1 == s4));//true
        System.out.println("s3和s4是同一个字符串" + (s3 == s4));//false

        String s5 = new String("test");
        System.out.println("s1和s5是同一个字符串" + (s1 == s5));//false
        System.out.println("s3和s5是同一个字符串" + (s3 == s5));//false

        String s6 = s3.intern();
        System.out.println("s1和s6是同一个字符串" + (s1 == s6));//true
        System.out.println("s3和s6是同一个字符串" + (s3 == s6));//false

    }

}
