package com.qa.test;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test01 {

    @Test
    public void test01 () {
        Assert.assertEquals(5, "junit".length());
        // Assert.assertEquals("test", "java", "python");
    }
}
