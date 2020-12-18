package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

public class BaseUrlPath {

    @BeforeClass
    public void setup () {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        // 默认端口是8080
        RestAssured.port = 80;
        RestAssured.basePath = "/posts";
        // 基本认证（登录认证）
        // RestAssured.authentication = basic("username", "password");
        // RestAssured.filters() = // 一个list对象 // 过滤器
        // RestAssured.requestSpecification = 默认requestspecification
        // RestAssured.responseSpecification = 默认responseSepecification
        RestAssured.urlEncodingEnabled = true;
        RestAssured.defaultParser = Parser.JSON;
        // 将将所有配置项恢复默认
        // RestAssured.reset();
    }

    /**
     * 在BeforeClass中提前设置好了basePath 和baseURI
     * 这里只需要填写end points就行
     */
    @Test
    public void test1() {
        given().get("/1").then().statusCode(200).log().all();
    }

    @Test
    public void test2() {
        given().get("/1/comments").then().statusCode(200).log().body();
    }

    @Test
    public void test3() {
        given().get("?userId=1").then().statusCode(200).log().headers();
    }

}
