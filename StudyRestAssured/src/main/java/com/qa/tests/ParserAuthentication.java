package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

public class ParserAuthentication {

    /**
     * 指定全局响应类型
     */
    @Test
    public void testDefaultParser() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.defaultParser = Parser.XML;
        RestAssured.defaultParser = Parser.HTML;

    }

    @Test
    public void testDefaultParser2() {
        // 局部指定
        //given().get("http://www.thomas-bayer.com/restnames/countries.groovy").then().using().defaultParser(Parser.JSON).log().all();
        given().get("http://www.thomas-bayer.com/restnames/countries.groovy").then().using().defaultParser(Parser.XML);
    }

    // 自定义类型
    @Test
    public void testCustomerParser1(){
        RestAssured.registerParser("application/vnd.uoml+xml", Parser.XML);
        RestAssured.unregisterParser("application/vnd.uoml+xml");
    }
    // 自定义类型
    @Test
    public void testCustomerParser2() {
        given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").then().using().parser("application/vnd.uoml+xml", Parser.XML);
    }

    @Test
    public void testBasicChallengeAuthentication () {
        given().
            auth().basic("admin", "admin").
        when().
            get("http://192.168.3.134:8080/han/login_index.do").
        then().
            log().all().
            statusCode(200);
    }

    @Test
    public void testBasicAuthentication() {
        RestAssured.authentication = basic("admin", "admin");
        given().
            get("http://192.168.3.134:8080/han/login_index.do").
        then().
            statusCode(200);
    }

    @Test
    public void testBasicPreemptiveAuthentication() {
        given().
            auth().preemptive().basic("tom", "123").
        when().
            get("https://www.xxx.com").
        then().
            statusCode(200);
    }

    @Test
    public void testDigestAuthentication() {
        given().
            auth().digest("tom", "123").
        when().
            get("https://www.xxx.com").
        then().
            statusCode(200);
    }
}
