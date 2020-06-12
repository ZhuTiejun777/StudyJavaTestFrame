package TeaseOutKnowledge.twelfth;

import java.util.Arrays;

/**
 * System类概述
 *      System 类包含一些有用的类字段和方法。它不能被实例化。
 * 成员方法
 *      public static void gc()：运行垃圾回收器。
 *      public static void exit(int status)：终止当前正在运行的 Java 虚拟机。参数用作状态码；根据惯例，非 0 的状态码表示异常终止。
 *      public static long currentTimeMillis()：返回以毫秒为单位的当前时间
 *      public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)：
 *      从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
 *          src——源数组
 *          srcPos——原数组中的起始位置
 *          dest——目标数组
 *          destPos——目标数组中的起始位置
 *          length——要复制的数组元素的数量
 */
public class StudySystem {

    public static void main(String[] args) {
        System.out.println("1945年的今天");
        // 终止虚拟机，下面的程序不运行
        //System.exit(0);
        System.out.println("日本宣布无条件投降");

        long start = System.currentTimeMillis();
        for (int x = 0; x < 100000; x++) {
            System.out.println("hello" + x);
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "毫秒");

        // 定义数组
        int[] arr = { 11, 22, 33, 44, 55 };
        int[] arr2 = { 6, 7, 8, 9, 10 };

        System.arraycopy(arr, 1, arr2, 2, 2);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }

}
