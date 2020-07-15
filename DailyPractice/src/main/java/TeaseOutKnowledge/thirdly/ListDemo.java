package TeaseOutKnowledge.thirdly;
/**
 * 数组是存储同一种数据类型多个元素的集合。也可以看成是一个容器
 * 数组既可以存储基本数据类型，也可以存储引用数据类型(引用数据类型:类，接口，数组)
 *
 * 格式1：数据类型[] 数组名;
 * 格式2：数据类型 数组名[];
 * 注意：这两种格式中，数组中是没有元素值的。我们要对数组的元素进行初始化
 *
 * Java中的数组必须先初始化,然后才能使用,为数组中的数组元素分配内存空间,并为每个数组元素赋值
 *
 * 动态初始化：初始化时只指定数组长度，由系统为数组分配初始值
 * 静态初始化：初始化时指定每个数组元素的初始值，由系统决定数组长度
 */

/**
 * Java 程序在运行时，需要在内存中的分配空间。为了提高运算效率，就对空间进行了不同区域的划分，
 * 因为每一片区域都有特定的处理数据方式和内存管理方式。
 *
 * 栈内存——存储局部变量
 * 堆内存——存储new出来的东西
 * 方法区 1.本地方法区 (和系统相关) 2.寄存器 (给CPU使用)
 *
 * 局部变量：方法定义中或者方法声明上的所有变量，使用完毕，立即消失。
 *
 */


public class ListDemo {
    //解释：定义了一个int类型的数组，这个数组中可以存放3个int类型的值。
    int[] arr = new int[3];

    // 静态初始化,格式：数据类型[] 数组名 = new 数据类型[]{元素1,元素2,…};
    // 解释：定义了一个int类型的数组，这个数组中可以存放3个int类型的值，并且值分别是1,2,3
    public int[] arr1 = new int[]{1,2,3};
    //现在我们经常用下面这简化写法
    static int[] arr2 = {1,2,3};

    public static void main(String[] args) {

        int[] arr3 = {11,22,33,44,55};

        printArray(arr3);
    }

    public static void printArray(int []arr){
        for (int i = 0; i < arr.length; i++) {
            // print不换行, println换行
            System.out.print(arr[i]+",");
            System.out.println(arr[i]);

        }
    }

}