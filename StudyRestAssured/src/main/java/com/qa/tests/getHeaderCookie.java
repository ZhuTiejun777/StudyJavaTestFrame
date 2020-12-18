package com.qa.tests;

import io.restassured.http.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getHeaderCookie {

    /**
     * 得到响应头
     */
    @Test
    public void testGetResponseHeaders () {
        Response response = get("http://jsonplaceholder.typicode.com/photos");
        // 得到一个响应header中字段
        String headerCFRAY = response.getHeader("CF-RAY");
        System.out.println("CF-RAY: " + headerCFRAY);
        // 得到全部的headers
        Headers headers = response.getHeaders();
        for (Header h : headers) {
            System.out.println(h.getName() + ":" + h.getValue());
        }
    }

    /**
     * 得到cookies
     */
    @Test
    public void getCookies() {
        Response response = get("http://jsonplaceholder.typicode.com/photos");
        Map<String, String> cookies = response.getCookies();
        //遍历集合，拿到每一个cookies
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 得到cookies详细信息
     */
    @Test
    public void getCookiesDetailsInfo() {
        Response response = get("http://jsonplaceholder.typicode.com/photos");
        //得到一个详细cookies对象
        Cookie cookie = response.getDetailedCookie("__cfduid");
        System.out.println("判断这个cookies是否有过期时间设定: " + cookie.hasExpiryDate());
        System.out.println("打印cookies的过期时间: " + cookie.getExpiryDate());
        System.out.println("判断是否值: " + cookie.hasValue());
    }

    @Test
    public void testSetContentType() {
        given().
            contentType(ContentType.JSON).
            contentType("applicatipn/json;charset=UTF-8").
        when().
            get("http://jsonplaceholder.typicode.com/photos").
        then().
            statusCode(200);
    }

    /**
     * path parameters type1
     */
    /*@Test
    public void testPataParametersType1() {
        given().
                pathParam("type","json").
                pathParam("section","Domains").
                when().
                get("https://xxxx/api/{type}/{section}/").
                then().
                statusCode(400);
    }*/

    /**
     * pathParam 参数匹配到url路径上
     */

    @Test
    public void testPataParametersType1() {
        given().
            pathParam("section","posts").
            pathParam("id","3").
        when().
            get("http://jsonplaceholder.typicode.com/{section}/{id}").
            //get("http://jsonplaceholder.typicode.com/{section}/{id}", "posts", "3").
        then().
            statusCode(200);
    }

    /*
     * set cookies
     */
    /*@Test
    public void testSetCookiesInRequest() {
        given().
                cookie("__utmt","1").
                when().
                get("http://xxxxx.com/globalweather.asmx?op=GetCitiesByCountry").
                then().
                statusCode(404);
    }*/

    /*
     * set mul cookies
     */
    /*@Test
    public void testMulCookiesInRequest() {
        // 设置多个value
        given().cookie("key", "va1", "va2"); // 会创建两个cookies， key=va1, key=va2
        // 通过创建cookies对象设置详细cookies信息
        Cookie cookie = new Cookie.Builder("some_cookie", "some_value")
                .setSecured(true).setComment("some comment").build();
        given().cookie(cookie).when().get("/xxx/xxx").then().assertThat().body(equalTo("xxx"));

        // 设置多个详细cookies
        Cookie cookie1 = new Cookie.Builder("some_cookie", "some_value")
                .setSecured(true).setComment("some comment").build();
        Cookie cookie2 = new Cookie.Builder("some_cookie", "some_value")
                .setSecured(true).setComment("some comment").build();
        Cookies cookies = new Cookies(cookie1, cookie2);
        given().cookies(cookies).when().get("xxx/xx").then().body(equalTo("xxx"));

    }*/


    /**
     * set Header or Headers
     */
    /*@Test
    public void testSetHeader() {
        given().
                header("key", "value").
                header("key2","va1","va2").
                headers("k1","va1","k2","va2","k3","va3").
                when().
                get("http://xxx/xxx").
                then().
                statusCode(404);
    }*/
}
