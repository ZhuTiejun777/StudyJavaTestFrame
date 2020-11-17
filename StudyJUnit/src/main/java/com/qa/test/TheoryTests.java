package com.qa.test;

import com.qa.protein.TrackingService;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class TheoryTests {

    @DataPoints
    public static int[] data () {
        return new int[] {
            1, 5, 10, 50, -4
        };
    }

    @Theory
    public void testThory (int value) {
        TrackingService trackingService = new TrackingService();
        trackingService.addProtein(value);
        // assume的作用是不执行一些不符合条件的组合，一般和theoryies一起使用
        Assume.assumeTrue(value > 0);
        System.out.println(value);
        assertTrue(trackingService.getTotal() > 0);
    }
}
