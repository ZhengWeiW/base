package com.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Long a = 1000l;
        Long b = 1000l;
        System.out.printf(String.valueOf(a==b));
        HashMap hashmap = new HashMap();
        Object put = hashmap.put(1, "1");
        Object put1 = hashmap.put(1, "2");
        System.out.println("------"+put+"-------");
        System.out.println("------"+put1+"-------");
        Set set = new HashSet();
        System.out.println("------"+set.add("1")+"-------");
        System.out.println("------"+set.add("1")+"-------");


        int i = 1;
        i++;
        ++i;
        System.out.println("------"+(i+ ++i * i++));


        int h = 2;
        System.out.println(h << 16);


    }
}
