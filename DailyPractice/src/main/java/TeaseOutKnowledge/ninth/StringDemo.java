package TeaseOutKnowledge.ninth;

public class StringDemo {

    public static void main(String[] args) {
        // 定义一个字符串对象
        String s = "helloworld";

        // int length():获取字符串的长度。
        System.out.println("s.length:" + s.length());//10

        // char charAt(int index):获取指定索引位置的字符
        System.out.println("charAt:" + s.charAt(7));//r

        // int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf('l'));    //2

        // int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf("owo"));  //4

        // int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf('l', 4));         //  8
        System.out.println("indexOf:" + s.indexOf('k', 4)); // -1
        System.out.println("indexOf:" + s.indexOf('l', 40)); // -1

        // int indexOf(String str,intfromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf('o', 1)); //4

        // String substring(int start):从指定位置开始截取字符串,默认到末尾。包含start这个索引
        System.out.println("substring:" + s.substring(5));//world
        System.out.println("substring:" + s.substring(0));//helloworld

        // String substring(int start,int
        // end):从指定位置开始到指定位置结束截取字符串。包括start索引但是不包end索引
        System.out.println("substring:" + s.substring(3, 8)); //loworl
        System.out.println("substring:" + s.substring(0, s.length()));//helloworld
    }

}
