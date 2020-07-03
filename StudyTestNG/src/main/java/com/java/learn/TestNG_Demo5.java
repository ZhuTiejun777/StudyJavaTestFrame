package com.java.learn;

import org.testng.annotations.Test;

public class TestNG_Demo5 {

    // 多应用于接口性能测试
    // invocationCount重复执行次数,invocationTimeOut一共执行不能超过的时间
    @Test(invocationCount = 5, invocationTimeOut = 1000)
    public void test1() {
        System.out.println("tst1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}
