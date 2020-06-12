package TeaseOutKnowledge.ninth;

/**
 * String s = new String(“hello”)和String s = “hello”;的区别
 * 前者会创建2个对象，后者创建1个对象。我们可以用 == 和 equals来比较
 * ==:比较引用类型比较的是地址值是否相同
 * equals:比较引用类型默认也是比较地址值是否相同，而String类重写了equals()方法，比较的是内容是否相同
 */

public class StringDemo2 {

    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "hello";

        System.out.println(s1 == s2);// false
        System.out.println(s1.equals(s2));// true

        String str = "hello";
        String str2 = "he"+new String("llo");
        System.out.println(str == str2);

        String str3 = "test";
        String str4 = "test";
        System.out.println(str3 == str4); // true
        System.out.println(str3.equals(str4)); // true
    }

}
