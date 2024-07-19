package com.base;

import java.util.HashMap;

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

    }
}
