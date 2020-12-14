package com.qa.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BasicFeaturesContentType {

    /**
     * 验证响应文件类型是html
     */
    @Test
    public void testResponseContentType2() {
        // given().
        when().
                get("https://www.baidu.com").
                then().
                statusCode(200).
                contentType(ContentType.HTML);
    }

    /**
     * 验证响应文件类型是 json
     */
    @Test
    public void testResponseContentType() {
        given().
                get("http://jsonplaceholder.typicode.com/photos/1").
                then().
                statusCode(200).
                contentType(ContentType.JSON);
    }

    /**
     * 验证响应文件类型是xml
     */
    /*@Test
    public void testResponseContentType3() {
        given().
                get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
                then().
                statusCode(200).
                contentType(ContentType.XML);
    }*/

    /**
     * json schema约束
     */
    @Test
    public void testJsonSchema() {
        given().
                get("xxxxxx").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("test-json-schema.json"));
    }
}
