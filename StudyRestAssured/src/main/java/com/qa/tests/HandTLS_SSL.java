package com.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;


public class HandTLS_SSL {

    @BeforeClass
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void testInvalidSSLException() {
        // 如果这样访问无效证书的https开头的网站，会报SSLPeerUnverifiedException异常
        given().get("证书无效或者证书过期的测试环境").then().statusCode(200).log().all();
    }

    /**
     * 处理无效SSL证书过期 不对的异常
     */
    @Test
    public void testRelaxedHTTPValide() {
        // 使用useRelaxedHTTPSValidation 就可以忽略这种证书无效的异常, 默认是SSL协议
        given().relaxedHTTPSValidation().when().get("证书无效或者证书过期的测试环境").then().statusCode(200).log().all();
    }

    /**
     * 处理TLS 异常
     */
    public void testTLSExceptin() {
        given().relaxedHTTPSValidation("TLS").when().get("证书无效或者证书过期的测试环境").then().statusCode(200).log().all();
    }
}