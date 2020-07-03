package com.java.learn;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @DataProvider注释
 * 标记一个方法是用来给其他测试方法提供数据的方法。要求该方法必须返回是object[][].
 * @Factory
 * 标记这个方法是一个工厂，方法必须返回的是一个对象。
 * @Listeners
 * 在一个测试方法上定义一个监听。例如Selenium自动化测试中需要用到这个事件监听功能，方便我们输出日志。
 * @Parameters
 * 描述了如何给一个测试方法传提参数。
 */

public class TestNG_Demo1 {

    @Test
    public void test1() {
        System.out.println("Holle");
    }

    @Test
    public void test2() {
        System.out.println("TestNG");
    }

    @BeforeClass
    public void beforetest() {
        System.out.println("启动测试的前提条件");
    }

    @AfterClass
    public void aftertest() {
        System.out.println("测试结束后的操作");
    }
}
