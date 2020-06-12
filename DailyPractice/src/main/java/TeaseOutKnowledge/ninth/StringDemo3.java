package TeaseOutKnowledge.ninth;

/**
 * 字符串内容为空:String s = “”;
 * 字符串对象为空:String s = null;
 *
 */

public class StringDemo3 {

    public static void main(String[] args) {
        // 创建字符串对象
        String s1 = "helloworld";
        String s2 = "helloworld";
        String s3 = "HelloWorld";

        // boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
        System.out.println("equals:" + s1.equals(s2));  //true
        System.out.println("equals:" + s1.equals(s3));  //false


        // boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
        System.out.println("equals:" + s1.equalsIgnoreCase(s2));    //true
        System.out.println("equals:" + s1.equalsIgnoreCase(s3));    //true


        // boolean contains(String str):判断大字符串中是否包含小字符串
        System.out.println("contains:" + s1.contains("hello")); //true
        System.out.println("contains:" + s1.contains("hw"));    //false


        // boolean startsWith(String str):判断字符串是否以某个指定的字符串开头
        System.out.println("startsWith:" + s1.startsWith("h"));     //true
        System.out.println("startsWith:" + s1.startsWith("hello")); //true
        System.out.println("startsWith:" + s1.startsWith("world")); //false


        // 练习：boolean endsWith(String str):判断字符串是否以某个指定的字符串结尾
        System.out.println("endsWith:" + s1.endsWith("o"));     //false
        System.out.println("endsWith:" + s1.endsWith("d"));     //true

        // boolean isEmpty():判断字符串是否为空。
        //System.out.println("isEmpty:" + s1.isEmpty());  //false

        String s4 = "";
        String s5 = null;
        //System.out.println("isEmpty:" + s4.isEmpty());//true
        // NullPointerException
        // s5对象都不存在，所以不能调用方法，空指针异常
        //System.out.println("isEmpty:" + s5.isEmpty());
    }
}
