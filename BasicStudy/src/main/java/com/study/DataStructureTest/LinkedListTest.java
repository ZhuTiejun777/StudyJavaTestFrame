package com.study.DataStructureTest;

import java.util.LinkedList;

/**
 * ArrayList是Array(动态数组)的数据结构,LinkedList是Link(链表)的数据结构.
 * 数组便于查询和修改，但是不方便新增和删除
 * 链表适合新增和删除，但是不适合查询，根据业务情况使用合适的数据结构和算法是在大数据量和高并发时必须要考虑的问题
 */


public class LinkedListTest {

        public static void main(String[] args){

            LinkedList<String> mylist = new LinkedList<String>();
            mylist.add("Tom");
            mylist.add("Lucy");
            mylist.add("Anthony");
            mylist.add("tina");
            mylist.add("luca");

            // 遍历链表
            for(String x : mylist){
                System.out.println(x);
            }

            // 打印链表元素个数
            System.out.println("Size= "+mylist.size());

            //添加第一个元素
            mylist.addFirst("Bobo");

            // 末尾添加一个元素
            mylist.addLast("Zara");

            // 遍历链表，检查插入第一个和最后一个是否正确
            for(String x : mylist){
                System.out.println(x);
            }

            //删除第一个和最后一个
            mylist.removeFirst();
            mylist.removeLast();

            System.out.println(mylist);

            for(String x : mylist){
                System.out.println(x);
            }

            // 通过索引获取元素
            System.out.println(mylist.get(1));

            // 指定索引添加元素
            mylist.set(1,"jock");
            System.out.println(mylist);

            //清空该链表
            mylist.clear();
        }
}


