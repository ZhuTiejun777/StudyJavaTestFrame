package TeaseOutKnowledge.thirteenth;

import java.math.BigDecimal;

/**
 * BigDecimal类概述
 *      不可变的、任意精度的有符号十进制数。
 * 构造方法
 *      public BigDecimal(String val)
 *
 * BigDecimal类成员方法
 *      public BigDecimal add(BigDecimal augend)：加
 *      public BigDecimal subtract(BigDecimal subtrahend)：减
 *      public BigDecimal multiply(BigDecimal multiplicand)：乘
 *      public BigDecimal divide(BigDecimal divisor)：除
 *      public BigDecimal divide(BigDecimal divisor,int scale,int roundingMode)：商，保留几位小数
 *
 *
 */
public class StudyBigDecimal {

    public static void main(String[] args) {
        // 因为float类型的数据存储和整数不一样导致的,float类型和double很容易丢失精度
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);
        System.out.println(1.0 - 0.12);

        BigDecimal bd1 = new BigDecimal("0.09");
        BigDecimal bd2 = new BigDecimal("0.01");
        System.out.println("add:" + bd1.add(bd2));

        BigDecimal bd3 = new BigDecimal("1.0");
        BigDecimal bd4 = new BigDecimal("0.32");
        System.out.println("subtract:" + bd3.subtract(bd4));

        BigDecimal bd5 = new BigDecimal("1.015");
        BigDecimal bd6 = new BigDecimal("100");
        System.out.println("multiply:" + bd5.multiply(bd6));

        BigDecimal bd7 = new BigDecimal("1.301");
        BigDecimal bd8 = new BigDecimal("100");
        System.out.println("divide:" + bd7.divide(bd8));
        System.out.println("divide:"+ bd7.divide(bd8, 3, BigDecimal.ROUND_HALF_UP));
        System.out.println("divide:"+ bd7.divide(bd8, 8, BigDecimal.ROUND_HALF_UP));

        /**
         * divide(BigDecimal divisor, int scale, introundingMode)
         * BigDecimal的setScale方法 ：BigDecimal.setScale() 方法用于格式化小数点 ，表示保留一位小数，默认用四舍五入方式
         *      直接删除多余的小数位，如2.35会变成2.3 setScale(1,BigDecimal.ROUND_DOWN)
         *      进位处理，2.35变成2.4 setScale(1,BigDecimal.ROUND_UP)
         *      四舍五入，2.35变成2.4 setScale(1,BigDecimal.ROUND_HALF_UP)
         *      四舍五入，2.35变成2.3，如果是5则向下舍setScaler(1,BigDecimal.ROUND_HALF_DOWN)
         * BigDecimal枚举常量用法摘要 ：
         *      CEILING 向正无限大方向舍入的舍入模式。
         *      DOWN 向零方向舍入的舍入模式。
         *      FLOOR 向负无限大方向舍入的舍入模式。
         *      HALF_DOWN 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向下舍入。
         *      HALF_EVEN 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
         *      HALF_UP 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向上舍入。
         *      UNNECESSARY 用于断言请求的操作具有精确结果的舍入模式，因此不需要舍入。
         *      UP 远离零方向舍入的舍入模式。
         */


    }

}
