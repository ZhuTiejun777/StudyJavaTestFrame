package TeaseOutKnowledge.eleventh;

import java.util.ArrayList;
import java.util.List;


/**
 * 冒泡排序
 *      相邻元素两两比较，大的往后放，第一次完毕，最大值出现在了最大索引处.同理，即可得到排好序的数组
 * 选择排序
 *      从0索引开始，依次和后面元素比较，小的往前放，第一次完毕，最小值出现在了最小索引处
 */

public class ArrayDemo1 {

    public static void main(String[] args) {
        int[] list = {5,6,8,1,5,4,9,10};
        int[] list2 = {5,6,8,1,5,4,9,10};
        int[] list3 = {5,6,8,1,5,4,9,10};
        printArray(list);
        int num;

        for (int j = 1; j < list.length; j ++) {
            for (int i = 0; i < j; i++) {
                if (list[i] > list[j]) {
                    num = list[j];
                    list[j] = list[i];
                    list[i] = num;
                }
            }
        }
        printArray(list);
        selectSort(list2);
        test(list3);
    }

    // 遍历功能
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x] + ", ");
            }
        }
        System.out.println("]");
    }

    // 选择排序
    public static void selectSort(int[] arr){
        for(int x=0; x<arr.length-1; x++){
            for(int y=x+1; y<arr.length; y++){
                if(arr[y] <arr[x]){
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
        printArray(arr);
    }

    // 选择排序
    public static void test (int[] arr) {
        int num;
        for (int i =0; i < arr.length; i ++) {
            for (int j = 0; j < arr.length; j ++) {
                if (i < j) {
                    if (arr[i] > arr[j]) {
                        num = arr[j];
                        arr[j] = arr[i];
                        arr[i] = num;
                    }
                }
            }
        }
        printArray(arr);
    }

}
