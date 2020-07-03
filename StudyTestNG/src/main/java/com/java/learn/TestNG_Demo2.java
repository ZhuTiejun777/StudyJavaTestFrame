package com.java.learn;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

    @Test
    public void test1() {
        System.out.println("Holle");
    }

    @Test
    public void test2() {
        System.out.println("TestNG");
    }

    @Test
    @Parameters({"Browser","Server"})
    public void test3(String browser, String server) {
        System.out.println("browser:" + browser + "  server:" + server);
    }
}
