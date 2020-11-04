package LittlePractice;

import java.util.ArrayList;

/**
 * 一、定义一个方法listTest(ArrayList al, Integer s)，要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。
 */
public class Test02 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println(listTest(arrayList, 30));

    }

    public static int listTest (ArrayList<Integer> arrayList, Integer integer) {
        int number = 0;
        for (int i : arrayList) {
            if (i == integer) {
                break;
            }
            number += 1;
        }
        if (number == arrayList.size()) {
            return -1;
        } else {
            return number;
        }
    }
}
