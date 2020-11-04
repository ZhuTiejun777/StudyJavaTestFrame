package LittlePractice;

import java.util.ArrayList;
import java.util.Random;

/**
 * 一、产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
 */
public class Test01 {

    public static void main(String[] args) {
        int[] ints = new int[10];
        Random random = new Random();
        for (int i = 0; i < ints.length; i ++) {
            ints[i] = random.nextInt(100);
            // ints[i] = (int)(Math.random()*100+1);
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i : ints) {
            if (i >= 10) {
                arrayList.add(i);
            }
        }
        System.out.println(arrayList);
    }
}
