package com.java.learn;

import org.testng.annotations.Test;

/**
 * 默认priority是等于0，而且priority值越小，优先级越高。
 */

public class TestNG_Demo4 {

    @Test(priority = 2)
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 1)
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }
}
