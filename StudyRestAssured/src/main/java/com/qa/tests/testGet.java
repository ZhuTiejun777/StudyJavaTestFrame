package com.qa.tests;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class testGet {

    @AfterTest
    public void afterTest() {

    }

    /**
     * get请求参数数据设置：queryParam
     * http://jsonplaceholder.typicode.com/posts/?userId=3
     */
    @Test
    public void testQueryParam () {
        given().
            queryParam("userId", "3").
        when().
            get("http://jsonplaceholder.typicode.com/posts/").
        then().
            statusCode(200).
            log().all();
    }

    /**
     * POST请求参数设置：formParam()
     */
    @Test
    public void testFormParam() {
        given().
            formParam("name", "Tom1").
            formParam("job", "Tester").
        when().
            get("https://reqres.in/api/users").
        then().
            statusCode(200).log().all();
    }

    @Test
    public void testAPostMethod() {
        given().
                param("name", "Anthony123").
                param("job", "tester").
                header("Content-Type", "text/html").
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201).log().all();
    }

    @Test
    public void testPostParam () throws JsonProcessingException {
        querySubaccountBalance querySubaccountBalance = new querySubaccountBalance("3294000000102488", "2", 1);
        JSONObject jsonObject = JSON.parseObject(new ObjectMapper().writeValueAsString(querySubaccountBalance));
        // String string = new ObjectMapper().writeValueAsString(querySubaccountBalance);
        given().
            header("Content-Type", "application/json").
            body(jsonObject).
        when().
            post("http://192.168.1.18:8088/bankApi/querySubaccountBalance").
        then().statusCode(200).
            body("payload.RspMsg", is("交易成功")).
            log().all();
    }

    /**
     * 请求参数设置：多参数
     */
    /*@Test
    public void testMulParams() {
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        given().
                param("key1", "val1","val2","val3").
                param("B").
                param("C", list).
                when().
                get("https://xxxx/api/users").
                then().
                statusCode(400);
    }*/

}
