package TeaseOutKnowledge.thirteenth;

import java.math.BigInteger;

/**
 * BigInteger类概述
 *      可以让超过Integer范围内的数据进行运算
 * 构造方法
 *      public BigInteger(String val)
 *
 * BigInteger类成员方法
 *      public BigInteger add(BigInteger val)：加
 *      public BigInteger subtract(BigInteger val)：减
 *      public BigInteger multiply(BigInteger val)：乘
 *      public BigInteger divide(BigInteger val)：除
 *      public BigInteger[] divideAndRemainder(BigInteger val)：返回商和余数的数组
 */
public class StudyBigInteger {

    public static void main(String[] args) {
        //我们先来输出Integer的最大最小值
        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(Integer.MIN_VALUE);//-2147483648
        //可以看到Integer的范围，如果我们超过Integer的范围，就要用BigInteger了
        //假如我们用Integer来创建一个超出它的范围的一个对象，那么肯定是报错的
        // Integer iii = new Integer("2147483648");// NumberFormatException
        // System.out.println(iii);
        // 所以通过大整数来创建对象
        BigInteger bi = new BigInteger("2147483648");
        System.out.println("BigInteger :" + bi);//BigInteger :2147483648

        //首先创建两个对象，然后我们来验证加减乘除的成员方法
        BigInteger bi1 = new BigInteger("100");
        BigInteger bi2 = new BigInteger("50");
        //加
        System.out.println("add:" + bi1.add(bi2));//add:150
        //减
        System.out.println("subtract:" + bi1.subtract(bi2));//subtract:50
        //乘
        System.out.println("multiply:" + bi1.multiply(bi2));//multiply:5000
        //除
        System.out.println("divide:" + bi1.divide(bi2));//divide:2
        BigInteger[] bis = bi1.divideAndRemainder(bi2);
        System.out.println("商：" + bis[0]);//商：2
        System.out.println("余数：" + bis[1]);//余数：0

    }

}
