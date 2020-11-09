package LittlePractice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 在一个列表中存储以下元素：apple,grape,banana,pear
 * 返回集合中的最大的和最小的元素
 * 将集合进行排序，并将排序后的结果打印在控制台上
 */

public class Test16 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("apple");
        arrayList.add("grape");
        arrayList.add("banana");
        arrayList.add("pears");
        arrayList.add("pear");
        arrayList.add("orange");
        String max = null;
        for (String string : arrayList) {
            int size = 0;
            for (String str : arrayList) {
                if (string.compareTo(str) >= 0) {
                    size += 1;
                }
            }
            if (size == arrayList.size()) {
                max = string;
                break;
            }
        }
        System.out.println(max);
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

    private static ArrayList<String> sortList(ArrayList<String> arrayList) {
        ArrayList<String> resultList = new ArrayList<String>();
        Collections.sort(arrayList);
        return arrayList;
    }
}
