package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;

public class SerializationDeSerializationTest {

    @Test
    public void testSerializationUsingHashMap () {
        HashMap<String, String> inputJson = new HashMap<String, String>();
        inputJson.put("FirstName", "Anthony");
        inputJson.put("LastName", "Liu");
        inputJson.put("Age", "18");

        given().
            contentType("application/json").
            body(inputJson).
        when().
            post("http://www.thomas-bayer.com/restnames/countries.groovy").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void testSerializationUsingBeanClass () {
        User user = new User();
        user.setAge(18);
        user.setHome("China");
        user.setWeight(75);

        given().
            contentType("application/json").
            body(user).log().body().
        when().
            post("http://www.thomas-bayer.com/restnames/countries.groovy").
        then().
            statusCode(200).
            contentType("application/xml").
            log().all();
    }

    @Test
    public void test01 () {

        RestAssured.baseURI = "http://192.168.1.18";
        RestAssured.port = 8088;
        RestAssured.basePath = "/bankApi";

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        ResponseSpecification responseSpecification = responseSpecBuilder.build();

        AccountBill accountBill = new AccountBill();
        accountBill.setCustAcctId("3294000000102488");
        accountBill.setSelectFlag("2");
        accountBill.setPageNum(1);

        given().
            contentType("application/json").
            // 可指定版本
            // body(accountBill, ObjectMapperType.JACKSON_2).
            body(accountBill).
        when().
            post("/querySubaccountBalance").
        then().
            spec(responseSpecification).
            body("payload.RspMsg", is("交易成功")).
            time(lessThan(5000L)).
            log().all();
    }

    @Test
    public void test02 () {
        RestAssured.baseURI = "http://192.168.1.18";
        RestAssured.port = 8088;
        RestAssured.basePath = "/bankApi";

        AccountBill accountBill = new AccountBill();
        accountBill.setCustAcctId("3294000000102488");
        accountBill.setSelectFlag("2");
        accountBill.setPageNum(1);

        UserResponse userResponse =
        given().
            contentType("application/json").
            body(accountBill).
        when().
            post("/querySubaccountBalance").
            as(UserResponse.class);

        System.out.println(userResponse.getMsg());
        Assert.assertEquals(userResponse.getState(), "1");

    }
}
