package TeaseOutKnowledge.eleventh;

/**
 * Integer类概述
 *      Integer 类在对象中包装了一个基本类型 int 的值
 *      该类提供了多个方法，能在 int 类型和 String 类型之间互相转换，还提供了处理 int 类型时非常有用的其他一些常量和方法
 * 构造方法
 *      public Integer(int value)
 *      public Integer(String s)
 *      注意：这个字符串必须是由数字字符组成
 *
 */
public class StudyInteger1 {

    public static void main(String[] args) {
        // 方式1
        int i = 100;
        Integer ii = new Integer(i);
        System.out.println("ii=" + ii);//ii=100

        // 方式2
        String s = "100";
        Integer iii = new Integer(s);
        System.out.println("iii=" + iii);//iii=100

    }

}
