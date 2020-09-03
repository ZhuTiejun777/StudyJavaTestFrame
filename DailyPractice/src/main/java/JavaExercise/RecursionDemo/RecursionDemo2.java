package JavaExercise.RecursionDemo;

import java.math.BigInteger;

public class RecursionDemo2 {

    /**
     * 需求：求1000的阶乘结果中尾部数字0的个数和全部数字0的个数
     * 例如：100560000，全部0有6个，尾部0有4个
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(getAllNum(Fun()));
        System.out.println(getTailNum(Fun()));
    }

    /*
     * 计算1000的阶乘，返回一个BigInteger对象
     */
    public static BigInteger Fun() {
        //思考一下为什么不能用int类型
        BigInteger bi1 = new BigInteger("1");
        for(int i = 1; i <= 1000; i++) {
            BigInteger bi2 = new BigInteger(i+"");
            bi1 = bi1.multiply(bi2);
        }
        return bi1;
    }

    /*
     * 先计算全部0的个数
     */
    public static int getAllNum(BigInteger bi) {

        // BigInteger转成字符串表现形式
        String s1 = bi.toString();
        System.out.println(s1);
        //定义一个计数器
        int count = 0;
        //依次拿到字符串每一个字符，判断是否是0
        for (int i = 0; i < s1.length(); i++) {
            if('0' == s1.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /*
     * 计算尾部0的个数
     * 分析：
     * 我们需要计算尾部的0的个数，我们需要把字符串反转过来，尾部的0都在字符串前面显示
     * 然后遍历字符串每一个字符，是否和字符0去判断
     * 是，计数器就加1，不是就break循环
     */
    public static int getTailNum(BigInteger bi) {

        //1.字符串实现反转，需要利用StringBuffer,String类本身没有rever()方法
        StringBuffer sb = new StringBuffer(bi.toString());
        //2.反转之后字符串形式
        String s2 = sb.reverse().toString();
        //定义计数器
        int num = 0;
        //3.遍历
        for (int i = 0; i < s2.length(); i++) {
            if( '0' != s2.charAt(i)) {
                break;
            }else {
                num++;
            }
        }

        return num;
    }
}
