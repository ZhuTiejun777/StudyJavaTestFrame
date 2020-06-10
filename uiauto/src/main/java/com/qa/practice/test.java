package com.qa.practice;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("b","4");
        map.put("a","5");
        map.put("c","3");
        map.put("d","5");
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.get(1));
        System.out.println();
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }


    }
}
