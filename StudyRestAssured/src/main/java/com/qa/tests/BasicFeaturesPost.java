package com.qa.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicFeaturesPost {

    /**
     * 一个post请求举类
     */
    @Test
    public void testAPostMethod () {
        given().
            param("name","Anthony123").
            param("job", "tester").
            header("Content-Type", "text/html").
        when().
            post("https://reqres.in/api/users").
        then().
            statusCode(201).
            //body("id", equalTo("")).
            log().all();
    }

    /**
     * 使用path方法提取内容
     */
    @Test
    public void testExtractDetailsUsingPath () {
        String href =
                // given().
                when().
                    get("http://jsonplaceholder.typicode.com/photos/1").
                then().
                    contentType(ContentType.JSON).
                    body("albumId", equalTo(1)).
                extract().
                    path("url");
        System.out.println(href);

        when().get(href).then().statusCode(200);
    }

    /**
     * 使用path方法提取内容,一行代码写法
     */
    @Test
    public void testExtractDetailsUsingPath2() {
        String href = get("http://jsonplaceholder.typicode.com/photos/1").path("url");
        System.out.println(href);
        when().get(href).then().statusCode(200);

        //第二种写法
        String href1 = get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().getString("url");
        System.out.println(href1);
        when().get(href1).then().statusCode(200);
    }

    /**
     * 先拿到响应对象，然后再解析
     */
    @Test
    public void testFirstGetResponseThenDoActions() {
        Response resp = get("http://jsonplaceholder.typicode.com/photos/1").
                then().
                extract().
                response();
        // 解析响应
        System.out.println("Context Type: " + resp.contentType());
        System.out.println("Status Code: " + resp.statusCode());
        System.out.println("Href: " + resp.path("url"));
    }

    /**
     * 以字符串的方式拿到全部响应
     */
    @Test
    public void getResponseAsString() {
        String responseAsString = get("https://reqres.in/api/users/2").asString();
        System.out.println("The Response: \n\n" + responseAsString);
    }

    /**
     * 以InputStream方式拿到响应对象
     * @throws IOException
     */
    @Test
    public void testGetResponseAsInputStream() throws IOException {
        InputStream responseAsInputStream = get("https://reqres.in/api/users/2").asInputStream();
        System.out.println("The Response: \n\n" + responseAsInputStream.toString().length());
        responseAsInputStream.close();
    }

    /**
     * 以字节数组方式拿到响应对象
     * @throws IOException
     */
    @Test
    public void testGetResponseAsByteArray() throws IOException {
        byte[] bytes = get("https://reqres.in/api/users/2").asByteArray();
        System.out.println("The Response: \n\n" + bytes.length);
        //遍历这个字节数组看看
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
    }

    /*{
        "RestResponse":{
        "message" :"abcddd",
                "result":{
            "name":"tom",
                    "age" : 18,
                    "gender": "man"
        }
    }
    }*/
    // 通过路径匹配数据
    /*@Test
    public void testWithoutRoot() {
        given().
                get("xxxxxxxurlxxxxx").
                then().
                rootPath("RestResponse.result").
                body("name", is("tom")).
                body("age", is("18")).
                body("gender", is("man"));
    }*/
}
