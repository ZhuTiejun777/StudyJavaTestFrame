package com.study;

public class CompareSize {

    public static void main(String[] args) {

        //调用方法
        sayHello("Anthony");
        // 不能直接Max(57. 89); 返回给函数Max，但不会输出到屏幕
        System.out.println(Max(57, 89));
    }
            // 定义自己的第一个方法
            public static void sayHello(String name){

        System.out.println("Hello " + name);
    }
            // 定义一个比较两个整数大小的方法
            public static int Max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }

}
