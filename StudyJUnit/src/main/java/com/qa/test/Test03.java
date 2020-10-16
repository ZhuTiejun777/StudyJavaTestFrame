package com.qa.test;

import com.qa.protein.TrackingService;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class Test03 {

    private TrackingService trackingService;

    @BeforeClass
    public static void before() {
        System.out.println("Before class, Onln Once");
    }

    @AfterClass
    public static void after() {
        System.out.println("After class, only once");
    }

    @Before
    public void setup() {
        System.out.println("Before Method");
        trackingService = new TrackingService();
    }

    @After
    public void tearDown() {
        System.out.println("After Method");
    }

    @Test
    @Ignore // 标注字段不执行
    public void newTrackingServiceTotalIsZero() {
        assertEquals("Tracking service total was not zero", 0, trackingService.getTotal());
    }

    @Test
    public void whenAddingProteinTotalIsIncreaseByAmount() {
        trackingService.addProtein(10);
        assertEquals(10, trackingService.getTotal());
    }

    @Test
    public void whenRemovingProteinTotalRemainsZero() {
        trackingService.removeProtein(5);
        assertEquals(0, trackingService.getTotal());
    }

}
