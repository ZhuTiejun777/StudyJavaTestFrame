package com.study;

/**
 * 递归就是自己调用自己，f(x)=f(x-1)+f(x-2)
 * 递归函数需要有边界出口
 */
public class StudyRecursion {

    //使用静态方法，方便函数调用，同一类中静态方法调用不需要实例化
    public static int factorial(int N){

        if(N <= 1)
            return 1;
        else{
            return N*factorial(N-1);
        }

    }

    public static void main(String[] args) {

        System.out.println(factorial(5));
    }
}
