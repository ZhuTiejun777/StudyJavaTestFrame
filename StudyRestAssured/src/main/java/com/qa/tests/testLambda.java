package com.qa.tests;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testLambda {

    /**
     * 响应正文中的属性使用匿名类来断言
     */
    @Test
    public void testBodyParameterInResponse() {
        given().
                get("http://jsonplaceholder.typicode.com/photos/1/").
                then().
                body("thumbnailUrl", new ResponseAwareMatcher<Response>() {
                    public Matcher<?> matcher(Response response) throws Exception {
                        return equalTo("https://via.placeholder.com/150/92c952");
                    }
                });

        // 响应正文中的属性使用lambda表达式来断言
        given().
                get("http://jsonplaceholder.typicode.com/photos/1/").
                then().
                body("thumbnailUrl", response -> equalTo("https://via.placeholder.com/150/92c952"));

        given().
                get("http://jsonplaceholder.typicode.com/photos/1/").
                then().
                body("thumbnailUrl", endsWith("92c952"));
    }

    /**
     * test cookies in response
     */
    @Test
    public void testCookieInResponse () {
        given().
            get("http://jsonplaceholder.typicode.com/photos/1/").
        then().
            log().all().
            assertThat().cookie("__cfduid","d1a3f103abe250b3de6902576be4db5da1608083141");
    }

    /**
     * 响应时间
     * 这个包含，http请求加响应处理时间 加上我们使用rest assured这个工具产生的时间之和
     */
    @Test
    public void testResponseTime () {
        // long getTime = given().get("http://jsonplaceholder.typicode.com/photos/1/").time();
        given().get("http://jsonplaceholder.typicode.com/photos/").then().time(lessThan(5000L));
        long getTime = given().get("http://jsonplaceholder.typicode.com/photos/1/").timeIn(TimeUnit.SECONDS);
        System.out.println(getTime);
    }

}
