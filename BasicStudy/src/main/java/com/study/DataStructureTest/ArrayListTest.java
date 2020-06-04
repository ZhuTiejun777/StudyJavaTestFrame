package com.study.DataStructureTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ArrayList是一个可变化的数组
 * 它实现了List的全部功能，主要有插入元素，编辑元素，删除元素，遍历元素。
 * 而Array虽然高效；但是其容量固定且无法动态改变。
 * 无法确定数组大小时才使用ArrayList！
 */

public class ArrayListTest {
    public static void main(String[] args) {

        //默认创建一个ArrayList集合
        List<String> list = new ArrayList<String>();
        //创建一个初始化长度为100的ArrayList集合
        List<String> initlist = new ArrayList<String>(100);
        //将其他类型的集合转为ArrayList
        List<String> setList = new ArrayList<String>(new HashSet());
        System.out.println(setList);

        // 定义列表ArrayList<数据类型> 列表名称 = new ArrayList<数据类型>(列表大小);
        ArrayList<Integer> mylist = new ArrayList<Integer>(5);
        ArrayList<Integer> mylist1 = new ArrayList<Integer>();
        // 想列表中依次添加元素
        mylist.add(1);
        mylist.add(3);
        mylist.add(5);
        mylist.add(7);
        mylist.add(9);

        // mylist.get(2)获取索引为2的值
        System.out.println(mylist.get(2));

        // 循环打印列表的值 for (Integer x : mylist)
        for (Integer x : mylist) {
            System.out.println(x);
        }
        // mylist.size()列表的大小
        System.out.println("size = " + mylist.size());

        // 打印出来，检查下是不是把3改成11, set(索引,要替换的值)
        mylist.set(1, 11);
        for (Integer x1 : mylist) {
            System.out.println(x1);
        }

        // indexOf()返回元素在链表中第一次出现的位置，如果返回-1，表示链表中没有这个元素。
        // lastIndexOf()返回元素在链表中最后一次出现的位置，如果返回-1，表示链表中没有这个元素。
        mylist.indexOf(5);
        mylist.lastIndexOf(5);

        // 删除列表中的元素,可以传索引,也可以传具体的值
        mylist.remove(0);
        mylist.remove(9);

        // 是否为空，通过定义在ArrayList中的私有变量size得到
        System.out.println(mylist.isEmpty());

        // contains(Object o)判断是否包含某个元素，通过遍历底层数组elementData，通过equals或==进行判断
        System.out.println(mylist.contains(1));

        // clear()集合清空
        mylist.clear();
    }
}
