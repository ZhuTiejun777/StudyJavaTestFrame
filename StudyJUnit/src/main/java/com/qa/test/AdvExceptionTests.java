package com.qa.test;

import com.qa.protein.InvalidGoalException;
import com.qa.protein.TrackingService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;

public class AdvExceptionTests {

    private TrackingService trackingService = new TrackingService();

    // 定义一次规则,整个类都使用
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testExceptionThrow() throws InvalidGoalException {
        // 设置期待的异常抛出类
        expectedException.expect(InvalidGoalException.class);
        // 设置期待异常消息
        expectedException.expectMessage("Goal is less than zero.");
        trackingService.setGoal(-5);
    }

    @Test
    public void testExceptionThrow2() throws InvalidGoalException {
        // 设置期待的异常抛出类
        expectedException.expect(InvalidGoalException.class);
        // 设置期待异常消息包含某些字段
        expectedException.expectMessage(containsString("Goal"));
        trackingService.setGoal(-5);
    }

}
