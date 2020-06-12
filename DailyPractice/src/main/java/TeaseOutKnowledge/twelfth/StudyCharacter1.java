package TeaseOutKnowledge.twelfth;

/**
 * Character类概述
 *      Character 类在对象中包装一个基本类型 char 的值，
 *      此外，该类提供了几种方法，以确定字符的类别（小写字母，数字，等等），并将字符从大写转换成小写，反之亦然
 * 构造方法
 *      public Character(char value)
 *
 * Character类成员方法
 *      public static boolean isUpperCase(char ch):判断给定的字符是否是大写字符
 *      public static boolean isLowerCase(char ch):判断给定的字符是否是小写字符
 *      public static boolean isDigit(char ch):判断给定的字符是否是数字字符
 *      public static char toUpperCase(char ch):把给定的字符转换为大写字符
 *      public static char toLowerCase(char ch):把给定的字符转换为小写字符
 */
public class StudyCharacter1 {

    public static void main(String[] args) {
        // 创建对象
        // Character ch = new Character((char) 97);
        Character ch = new Character('a');
        System.out.println("ch:" + ch);
        //运行程序后可以发现：这两个对象的结果是相同的

        // public static boolean isUpperCase(char ch):判断给定的字符是否是大写字符
        System.out.println("isUpperCase:" + Character.isUpperCase('A'));
        System.out.println("isUpperCase:" + Character.isUpperCase('a'));
        System.out.println("isUpperCase:" + Character.isUpperCase('0'));

        // public static boolean isLowerCase(char ch):判断给定的字符是否是小写字符
        System.out.println("isLowerCase:" + Character.isLowerCase('A'));
        System.out.println("isLowerCase:" + Character.isLowerCase('a'));
        System.out.println("isLowerCase:" + Character.isLowerCase('0'));

        // public static boolean isDigit(char ch):判断给定的字符是否是数字字符
        System.out.println("isDigit:" + Character.isDigit('A'));
        System.out.println("isDigit:" + Character.isDigit('a'));
        System.out.println("isDigit:" + Character.isDigit('0'));

        // public static char toUpperCase(char ch):把给定的字符转换为大写字符
        System.out.println("toUpperCase:" + Character.toUpperCase('A'));
        System.out.println("toUpperCase:" + Character.toUpperCase('a'));

        // public static char toLowerCase(char ch):把给定的字符转换为小写字符
        System.out.println("toLowerCase:" + Character.toLowerCase('A'));
        System.out.println("toLowerCase:" + Character.toLowerCase('a'));
    }

}
