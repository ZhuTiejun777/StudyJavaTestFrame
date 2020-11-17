package com.qa.test;

import com.qa.protein.TrackingService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class Test07 {

    private static TrackingService trackingService = new TrackingService();

    @Test
    public void testIs () {
        trackingService.addProtein(10);
        assertThat(trackingService.getTotal(), is(10));
    }

    @Test
    public void testInstaceType () {
        trackingService.addProtein(10);
        assertThat(trackingService.getTotal(), instanceOf(Integer.class));
    }

    @Test
    public void testHasItem() {
        String[] arr = new String[]{"Tom", "Jack", "Anthony", "Bill"};
        assertThat(Arrays.asList(arr), hasItems("Anthony", "Jack"));
    }

    @Test
    public void testAllOf() {
        trackingService.addProtein(10);
        assertThat(trackingService.getTotal(), allOf(is(10), instanceOf(Integer.class)));
    }

    @Test
    public void testContainsString() {
        String st = "Hello Junit!!";
        assertThat(st, containsString("Junit"));
    }

    @Test
    public void testAnyOf() {
        trackingService.addProtein(10);
        assertThat(trackingService.getTotal(), anyOf(is(10), instanceOf(String.class)));
    }

}
