package TeaseOutKnowledge.tenth;

/**
 * String,StringBuffer,StringBuilder的区别
 *      String是内容不可变的，而StringBuffer,StringBuilder都是内容可变的。
 *      StringBuffer是同步的，数据安全,效率低;StringBuilder是不同步的,数据不安全,效率高
 * StringBuffer和数组的区别
 *      二者都可以看出是一个容器，装其他的数据。
 *      但是呢,StringBuffer的数据最终是一个字符串数据。
 *      而数组可以放置多种数据，但必须是同一种数据类型的。
 */


public class StringBufferDemo3 {
    public static void main(String[] args) {
        // String 转换 StringBuffer
        String s = "hello";
        // 注意：不能把字符串的值直接赋值给StringBuffer
        // StringBuffer sb = "hello";
        // StringBuffer sb = s;
        // 方式1:通过构造方法
        StringBuffer sb = new StringBuffer(s);
        // 方式2：通过append()方法
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);
        System.out.println("sb:" + sb);//sb:hello
        System.out.println("sb2:" + sb2);//sb2:hello

        // StringBuffer转换 String
        StringBuffer buffer = new StringBuffer("java");
        // String(StringBuffer buffer)
        // 方式1:通过构造方法
        String str = new String(buffer);
        // 方式2：通过toString()方法
        String str2 = buffer.toString();
        System.out.println("str:" + str);//str:java
        System.out.println("str2:" + str2);//str2:java
    }
}


