package com.java.learn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Demo7 {

    @Test
    public void AssertTest1() {
        Assert.assertEquals(12, 12);
        // 如果断言失败,打印"not equals"
        // assertEquals值的比较
        Assert.assertEquals("ABc", "ABC", "not equals");
    }

    @Test
    public void AssertTest2() {
        String[] strings1 = {"java", "python", "c++"};
        String[] strings2 = {"python", "c++", "java"};
        // 判断两个对象是否相同,忽略排序位置
        Assert.assertEqualsNoOrder(strings1, strings2, "两组字符串不同");
    }

    @Test
    public void AssertTest3() {
        String[] strings1 = {"java", "python", "c++"};
        String[] strings2 = {"python", "c++", "java"};
        Assert.assertTrue(strings1 == strings2, "两个不相等");
    }

    @Test
    public void AssertTest4() {
        String[] strings1 = {"java", "python", "c++"};
        String[] strings2 = {"python", "c++", "java"};
        String[] strings3 = null;
        // 判断对象不为Null
        Assert.assertNotNull(strings1, "该对象为空");
        Assert.assertNotNull(strings3, "该对象为空");
    }

    @Test
    public void AssertTest5() {
        String[] st1 = {"Anthony", "Tom", "Jhon"};
        String[] st2 = {"Jhon", "Anthony", "Tom"};
        String[] st3 = st1;
        // assertSame地址的比较
        Assert.assertSame(st1, st3, "not same");
        Assert.assertSame(st1, st2, "not same");
    }
}
