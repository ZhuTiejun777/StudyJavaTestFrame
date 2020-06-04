package com.study.DataStructureTest;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构
 * 对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针
 * 对于随机新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据
 */

public class MyClass {

    public static void main(String[] args) {

        long n = (long) 1E6;

        ArrayList arrayList = new ArrayList();
        long milis = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        //System.out.println(arrayList);
        System.out.println("新增操作arraylist 花费了  " + (System.currentTimeMillis() - milis) + " 毫秒");

        LinkedList linkedList = new LinkedList();
        milis = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        //System.out.println(linkedList);
        System.out.println("新增操作linkedlist 花费了  " + (System.currentTimeMillis() - milis) + " 毫秒");

        // arraylist删除元素
        milis = System.currentTimeMillis();
        arrayList.remove(1E5);
        System.out.println("删除元素arraylist 花费了  " + (System.currentTimeMillis() - milis) + " 毫秒");

        // linkedlist删除元素
        milis = System.currentTimeMillis();
        linkedList.remove(1E5);
        System.out.println("删除元素linkedlist 花费了  " + (System.currentTimeMillis() - milis) + " 毫秒");

        // arraylist get 中间元素
        milis = System.currentTimeMillis();
        System.out.println(arrayList.get((int) n / 2));
        System.out.println("访问中间元素arraylist 花费了  " + (System.currentTimeMillis() - milis) + " 毫秒");

        // linkedlist get 中间元素
        milis = System.currentTimeMillis();
        System.out.println(linkedList.get((int) n / 2));
        System.out.println("访问中间元素linkedlist 花费了  " + (System.currentTimeMillis() - milis) + " 毫秒");
    }
}
