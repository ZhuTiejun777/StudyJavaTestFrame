package com.qa.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(BadCategoryTest.class)
public class Test05 {

    @Test
    public void test01 () {
        System.out.println("Assert Equals");
        Assert.assertEquals(4, "test".length());
    }
}
