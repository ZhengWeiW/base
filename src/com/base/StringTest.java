package com.base;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname StringTest
 * @Description TODO
 * @Date 2022/12/10 14:04
 * @Created by ZWW
 */
public class StringTest {
    //基本数据类型8种  byte char short int long float double boolean
    //分别占字节       1     2     2    4   8     4     8      1
    //大小             byte / char / short < int < long < float < double
    //运算点          byte / char / short 三者相互运算  会自动转int
    //计算机底层都是以补码的形式存储数据   int
    // % 取余的结果的正负取决于除数的正负
    //  异或  不一样才是true

     public static void main(String[] args) {
         int a = 2;
         int b = a++; //  推荐是使用 m+ = 2,不推荐 m = m+2 因为m++ 不改变数据类型
         System.out.println(a);
         System.out.println(b);
         int c = ++a ;
         System.out.println(a);
         System.out.println(c);

         byte b1 = -128;
         b1--;
         System.out.println(b1);


         switch(1){

             case 1:
                 System.out.println(2);

             case 2:
                 System.out.println(3);

             case 3:
                 System.out.println(4);


         }
         String str = "";
         System.out.println(10 + (10 >> 1));

         BigDecimal big = null;
         System.out.println(String.valueOf(big));

         short s1 = 1; s1 = (short) (s1 + 1);



         String input = "first-part-second-part-third-part";

         // 找到第一个 "-" 的索引位置
         int indexOfDash = input.indexOf("-");

         // 如果找到了 "-"，则将其之前的部分作为一部分，将其之后的部分作为另一部分
         String part1 = indexOfDash != -1 ? input.substring(0, indexOfDash) : input;
         String part2 = indexOfDash != -1 ? input.substring(indexOfDash + 1) : "";

         // 输出结果
         System.out.println("Part 1: " + part1);
         System.out.println("Part 2: " + part2);


         System.out.println((5198.02+1299+1090));
         ExecutorService executorService = Executors.newCachedThreadPool();
         executorService.execute(new Runnable() {
             @Override
             public void run() {

             }
         });

         executorService.submit(new Runnable() {
             @Override
             public void run() {

             }
         });

     }
}