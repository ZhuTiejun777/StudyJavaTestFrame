package com.java.learn;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Demo8 {

    @Test
    public void testSoftAssert() {
        System.out.println("Test start");
        // 软断言,断言失败不会终止程序运行
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(12, 13,"两者不相等");
        System.out.println("Test complete");
        System.out.println(3+8);
        // 抛出异常信息,不加的话就不会抛出异常信息
        assertion.assertAll();
    }
    
}
