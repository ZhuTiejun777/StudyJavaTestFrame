package com.qa.util;

import io.restassured.response.Response;
import org.testng.Assert;

public class TestUtils {

    //断言状态码是不是200或者其他状态码,例如常见404等
    public void checkStatusCode (Response response, int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "状态码检查失败!");
    }

    //打印响应全部内容,debug中应该经常用到这个
    public void printAllResponseText(Response response) {
        System.out.println(response.then().log().all());
    }

    //只打印响应正文
    public void printResponseBody(Response response) {
        System.out.println(response.then().log().body());
    }
}
