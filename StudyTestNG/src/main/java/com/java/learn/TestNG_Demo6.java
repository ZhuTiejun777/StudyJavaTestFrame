package com.java.learn;

import org.testng.annotations.Test;

public class TestNG_Demo6 {

    // dependsOnMethods 依赖执行顺序
    @Test(dependsOnMethods={"test5", "test4"})
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @Test
    public void test4(){
        System.out.println("test4");
    }

    @Test
    public void test5(){
        System.out.println("test5");
    }

}
