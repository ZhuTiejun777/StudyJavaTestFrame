package com.study;

/**
 * 未捕获异常时,容易造成空指针异常,移动端app测试,经常因为数组索引越界而发生崩溃
 * 未捕获到异常,就不执行catch中的代码,捕获到异常后,执行catch中的代码
 * finally的代码为比执行的
 */
public class StudyException {
    public static int retInt(){
        int a = 100;
        try{
            return a;
            //return a/0;
        } catch(ArithmeticException e){

            System.out.println("调用catch 语句块");
            System.out.println(e);
            return a;

        } finally {
            System.out.println("调用finally 语句块");
        }
    }
    public static void main(String[] args){

        System.out.println(retInt());
    }
}
