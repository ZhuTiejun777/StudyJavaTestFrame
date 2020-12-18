package com.qa.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicFeaturesLog {

    /**
     * 日志打印1
     */
    @Test
    public void testLogOnly() {
        given().
            get("http://jsonplaceholder.typicode.com/photos/").
        then().
            //log().headers();
            //log().body();
            log().cookies();
    }

    /**
     * 只有发生错误 情况下才打印日志
     */
    @Test
    public void testLogOnlyError() {
        given().
            get("http://jsonplaceholder.typicode.com/phot/").
        then().
            log().ifError();
    }

    /**
     * 在特定条件下才打印日志
     */
    @Test
    public void testLogUnderConditional() {
        given().
            get("http://jsonplaceholder.typicode.com/photos/").
        then().
            log().ifStatusCodeIsEqualTo(200);
    }
}
