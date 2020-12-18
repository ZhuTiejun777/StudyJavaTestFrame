package com.qa.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * 模式复用
 */

public class RequestSpecBuilderTest {

    /**
     * 将请求封装到一起
     */

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setup () {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addParam("userId", "2");
        requestSpecBuilder.addHeader("Accept-Encoding", "gzip, deflate");
        requestSpecification = requestSpecBuilder.build();
    }

    @Test
    public void test1 () {
        given().
            spec(requestSpecification).log().all().
        when().
            get("http://jsonplaceholder.typicode.com:80/posts").
        then().
            statusCode(200).log().all();
    }

}
