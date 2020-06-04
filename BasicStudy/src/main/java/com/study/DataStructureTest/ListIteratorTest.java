package com.study.DataStructureTest;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * public boolean hasNext(); 判断是否有下一个元素，返回值是布尔型
 * public object next();获取下一个元素对象，返回的是一个对象
 * public boolean hasPrevious();判断是否有上一个元素，返回值是布尔型
 * public object previous();获取上一个元素，返回的是一个对象
 */

public class ListIteratorTest {


    public static void main(String[] args){

        ArrayList<String> name = new ArrayList<String>();
        name.add("Anthony");
        name.add("mark");
        name.add("tom");
        name.add("john");
        name.add("jack");

        // 从上往下 遍历list元素
        ListIterator<String> itr = name.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("---------------------------");

        // 从下网上遍历list元素
        while(itr.hasPrevious()){
            System.out.println(itr.previous());
        }
    }
}


