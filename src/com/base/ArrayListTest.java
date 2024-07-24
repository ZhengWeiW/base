package com.base;

import com.base.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Classname ArrayListTest
 * @Description TODO
 * @Date 2023/2/5 15:00
 * @Created by ZWW
 */
public class ArrayListTest {
     public static void main(String[] args) {
         int[] list1 = new int[] {1,2,3};
         int[] list2 = {1,2,3};
         int list3[] = new int[5];
         list3[0] = 1;
         list3[1] = 2;
         HashSet<String> set = new HashSet<>();
         set.add("1");

        //提交7
         System.out.println(list1.toString());
         System.out.println(list2.toString());
         System.out.println(list3.toString());

         User user1 = new User(1,"1",1);
         User user2 = new User(2,"2",2);
         User user3 = new User(3,"3",3);

         List<User> userlist = new ArrayList<>();
         userlist.add(user1);
         userlist.add(user2);
         userlist.add(user3);

         for(User user : userlist){
             user.setUserName(user.getUserName()+user.getUserName());
         }


         //11
         //测试提交12
         //测试提交13
         System.out.println(userlist);

         /**
          *功能描述
          * 前置递增运算符 (++i)：优先级较高。
          * 乘法运算符 (*)：优先级中等。
          * 后置递增运算符 (i++)：优先级较低
          * @author zcc
          * @date 2024/6/28
          * @param  * @param args
          * @return
          */
         int i =1;
         i=i++;
         System.out.println(i);//1
         System.out.println(i++);//1
         int j = i++;
         System.out.println(i);//3
         System.out.println(j);//2
         int k = i+ ++i * i++; // 4*4 +  4 + 1  优先计算 ++i = 4 其次计算 ++i * i = 4*4   然后计算 i+ ++i * i = 4*4 +  4 ，最后计算i+ ++i * i++ = 4*4 +  4 + 1
         System.out.println(i); // 5
         System.out.println(j); // 2
         System.out.println(k);  //
         //测试提交10
         System.out.println("--------------------");  //
         int[] a = new int[10];
         a[0] = 6;
         a[1] = 7;
         a[2] = 8;
         a[3] = 9;
         // 你试图将数组a中从索引2开始的5个元素复制到从索引3开始的位置，这会导致从索引3开始的原始元素被覆盖，包括那些你原本打算复制过去的元素中的一部分
         System.arraycopy(a, 2, a, 4, 5);
         //a[2]=99;
         for (int m = 0; m < a.length; m++) {
             System.out.print(a[m] + " ");
         }
     }


}