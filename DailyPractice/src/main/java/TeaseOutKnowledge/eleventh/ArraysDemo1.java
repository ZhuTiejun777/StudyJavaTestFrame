package TeaseOutKnowledge.eleventh;

import java.util.Arrays;

/**
 * Arrays类概述
 *      针对数组进行操作的工具类。
 *      提供了排序，查找等功能。
 * 成员方法
 *      public static String toString(int[] a)：把数组转成字符串
 *      public static void sort(int[] a)：对数组进行排序
 *      public static int binarySearch(int[] a,int key)：二分查找
 *
 */

public class ArraysDemo1 {

    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = { 24, 69, 80, 57, 13 };

        // public static String toString(int[] a) 把数组转成字符串
        String str = Arrays.toString(arr);
        System.out.println(str);
        System.out.println("排序前：" + Arrays.toString(arr));

        // public static void sort(int[] a) 对数组进行排序
        Arrays.sort(arr);//底层是快速排序，了解就可以了
        System.out.println("排序后：" + Arrays.toString(arr));

        // [13, 24, 57, 69, 80]
        // public static int binarySearch(int[] a,int key) 二分查找
        System.out.println("binarySearch:" + Arrays.binarySearch(arr, 57));
        System.out.println("binarySearch:" + Arrays.binarySearch(arr, 577));
    }


}
