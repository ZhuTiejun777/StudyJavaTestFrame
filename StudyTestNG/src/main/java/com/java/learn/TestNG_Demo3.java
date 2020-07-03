package com.java.learn;

import org.testng.annotations.Test;

/**
 * @Test(timeOut) 超时判定,超时则执行失败
 */

public class TestNG_Demo3 {

    @Test(timeOut = 3000)
    public void test1() {
        try {
            Thread.sleep(2800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1");
    }

    // @Test(enabled = false)用例禁止执行
    @Test(enabled = false)
    public void test2() {
        System.out.println("用例禁止执行");
    }
}
