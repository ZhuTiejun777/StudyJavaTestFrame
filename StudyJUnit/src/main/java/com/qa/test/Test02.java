package com.qa.test;

import com.qa.protein.TrackingService;
import org.junit.*;

public class Test02 {

    private TrackingService trackingService;

    @Before
    public void setup () {
        System.out.println("Before Method");
        trackingService = new TrackingService();
    }

    @After
    public void tearDown() {
        System.out.println("After Method");
    }

    @Test
    public void test01 () {
        Assert.assertEquals("Tracking service total was not zero", 0, trackingService.getTotal());
    }

    @Test
    public void test02 () {
        trackingService.addProtein(10);
        Assert.assertEquals(10, trackingService.getTotal());
    }

    @Test
    public void test03 () {
        trackingService.removeProtein(5);
        Assert.assertEquals(0, trackingService.getTotal());
    }

}
