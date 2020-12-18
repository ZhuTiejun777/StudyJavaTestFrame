package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

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
}
