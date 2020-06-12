package TeaseOutKnowledge.twelfth;

import java.util.Random;

/**
 * Random类概述
 *      此类用于产生随机数
 *      如果用相同的种子创建两个 Random 实例，则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。
 * 构造方法
 *      public Random()
 *      public Random(long seed)
 * 成员方法
 *      public int nextInt()：返回的是int范围内的随机数
 *      public int nextInt(int n):返回的是[0,n)范围的内随机数
 */

public class StudyRandom {

    public static void main(String[] args) {
        // 创建对象
        Random r = new Random();
        for (int x = 0; x < 10; x++) {
            // int num = r.nextInt();//返回的是int范围内的随机数
            int num = r.nextInt(100) + 1;//本来返回的是[0,100)范围的内随机数，+1后返回[1,100)
            System.out.println(num);
        }

        //创建对象,给出指定的种子
        Random r1 = new Random(123);
        for (int x = 0; x < 10; x++) {
            int num = r1.nextInt(100) + 1;
            System.out.println(num);//给定种子后，每次得到的随机数是相同的。
        }
    }
}
