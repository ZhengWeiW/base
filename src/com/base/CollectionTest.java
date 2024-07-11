package com.base;

import java.util.Arrays;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args){
        List<Integer> collect = Arrays.asList(1, 2, 3, 4, 5);
        collect.stream().filter(a -> a/2 == 0 )
                .forEach(a -> a=a+10);
        System.out.println(collect);

    }
}
