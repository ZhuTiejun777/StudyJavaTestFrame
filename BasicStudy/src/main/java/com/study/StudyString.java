package com.study;

public class StudyString {

    public static void main(String[] args) {
        // 用关键字String来定义一个字符串变量
        String myString = "Hello a world abc";
        //计算字符长度
        System.out.println(myString.length());
        //转换小写
        System.out.println(myString.toLowerCase());
        //转换大写
        System.out.println(myString.toUpperCase());
        //字符串用加号连接
        String st1 = "Hello";
        String st2 = "world";
        System.out.println(st1 + st2);
        //替换字母
        System.out.println(myString.replace('a', 'Y'));
        //查找某一个字母的索引
        System.out.println(myString.indexOf('w'));
        //字符串切割
        //从左到右，包括索引1，但是右边界不包含索引9
        System.out.println(myString.substring(1, 9));
        //从索引为4，包含4开始切割，4之前的不要
        System.out.println(myString.substring(4));
    }
}