package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;
import static org.hamcrest.Matchers.*;

public class testAssert {

    @AfterTest
    public void testAfter () {
        // RestAssured.proxy("http://jsonplaceholder.typicode.com", 8888);
        // RestAssured.proxy = host("http://jsonplaceholder.typicode.com").withPort(80);
    }

    @Test
    public void testStatusInResponse () {
        given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusCode(200).log().all();
        given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusLine("HTTP/1.1 200 OK");
        // containsString()断言包含
        given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusLine(containsString("OK"));
        // allOf()正则匹配
        given().get("http://jsonplaceholder.typicode.com/photos/").then().statusLine(allOf()).log().all();
        given().get("http://jsonplaceholder.typicode.com/photos/").then().body(allOf()).log().all();
    }

    @Test
    public void testResponseHeader () {
        given().
            get("http://jsonplaceholder.typicode.com/photos").
        then().
            assertThat().header("X-Powered-By","Express");
        given().
            get("http://jsonplaceholder.typicode.com/photos").
        then().
            assertThat().headers("Vary","Origin, Accept-Encoding","Content-Type", containsString("json"));
    }

    @Test
    public void testContentTypeInResponse () {
        given().
            get("http://jsonplaceholder.typicode.com/photos").
        then().
            assertThat().
            contentType(ContentType.JSON);
    }

    /**
     * 响应正文 文本断言
     */
    /*@Test
    public void testBodyTextInResponse() {
        String responseString = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").asString();
        given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").
                then().assertThat().body(equalTo(responseString));
    }*/
}
