package com.qa.test;

import com.qa.protein.TrackingService;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParametrizedTests {

    private int input;
    private int expected;

    private static TrackingService trackingService = new TrackingService();

    public ParametrizedTests(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }
    
}
