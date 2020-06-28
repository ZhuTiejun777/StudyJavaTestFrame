package TeaseOutKnowledge.seventeenth;

import java.util.HashSet;
import java.util.Random;

/**
 * 获取10个1至20的随机数，且随机数不能重复。
 */
public class ExerciseDemo {

    public static void main(String[] args) {
        Random random = new Random();

        HashSet<Integer> hashSet = new HashSet<Integer>();

        while (hashSet.size() < 10) {
            int number = random.nextInt(20) + 1;
            hashSet.add(number);
        }

        for (Integer integer : hashSet) {
            System.out.println(integer);
        }
    }
}
