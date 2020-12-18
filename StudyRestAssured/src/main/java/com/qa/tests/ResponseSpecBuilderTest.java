package com.qa.tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * 模式复用
 */

public class ResponseSpecBuilderTest {

    /**
     * 断言响应中的内容
     * */

    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup () {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
        // responseSpecBuilder.expectHeader("Cache-Control", "public, max-age=14400");
        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void test1 () {
        given().
            get("http://jsonplaceholder.typicode.com/posts").
        then().
            spec(responseSpecification).
            time(lessThan(3000L));
    }
}
