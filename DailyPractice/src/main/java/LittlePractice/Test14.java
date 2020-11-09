package LittlePractice;

import java.util.HashSet;
import java.util.Random;

/**
 * 生成10个1到20之间的不重复的随机数
 */

public class Test14 {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Random random = new Random();
        while (hashSet.size() <= 10) {
            hashSet.add(random.nextInt(19) + 1);
        }
        System.out.println(hashSet);
    }
}
