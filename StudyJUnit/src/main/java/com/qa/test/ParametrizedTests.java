package com.qa.test;

import com.qa.protein.TrackingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ParametrizedTests {

    private int input;
    private int expected;

    private static TrackingService trackingService = new TrackingService();

    public ParametrizedTests(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]> data () {
        return Arrays.asList(new Object[][] {
                {5, 5},
                {5, 10},
                {-12, 0},
                {50, 50},
                {1, 51}
        });
    }

    @Test
    public void tset01 () {
        if (input > 0) {
            trackingService.addProtein(input);
        } else {
            trackingService.removeProtein(-input);
        }
        Assert.assertEquals(expected, trackingService.getTotal());
    }
}
