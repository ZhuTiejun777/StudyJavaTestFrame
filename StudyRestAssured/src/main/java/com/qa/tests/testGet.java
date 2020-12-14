package com.qa.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testGet {

    /**
     * get请求参数数据设置：queryParam
     */
    @Test
    public void testQueryParam () {
        given().
            param("userId", "3").
        when().
            get("http://jsonplaceholder.typicode.com/posts/").
        then().
            statusCode(200).
            log().all();
    }
}
