package demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class BasicFeatures {


    @Test
    public void testEqualToMethod () {
        given().
            get("http://jsonplaceholder.typicode.com/posts/3").
        then().
            // 多个断言写在一起,用逗号隔开
            // body("id", equalTo(3), "title", equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"));
            // 多个断言分开,用and连接
            //body("id", equalTo(3)).
            //    and().
            //body( "title", equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"));
            body("id", equalTo(3)).
                and().
            body("title", containsString("exercitationem repellat"));
    }


    @Test
    public void testStatusCode () {
        given().
            get("http://jsonplaceholder.typicode.com/posts/3").
        then().
            statusCode(200)
                .log().all();
    }

    /**
     * Java原本风格的写法
     */
    @Test
    public void testStatusCodeJavaStyle() {
        //1. 创建一个RestAssured对象
        RestAssured restAssured = new RestAssured();
        //2. 创建一个请求对象
        RequestSpecification requestSpecification = restAssured.given();
        //3. 发送请求，拿到响应对象
        Response response = requestSpecification.get("https://www.baidu.com");
        //4. 判断响应状态码是不是200
        assert response.getStatusCode() == 200;
    }

    @Test
    public void testRequestWithParameter () {
        given().
            param("userId", 2).
        when().
            get("http://jsonplaceholder.typicode.com/posts").
        then().
            statusCode(200).log().all();
    }

    @Test
    public void testRequestWithParameters () {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userId", "2");
        hashMap.put("id", "14");
        given().
            params(hashMap).
        when().
            get("http://jsonplaceholder.typicode.com/posts").
        then().
            statusCode(200).log().all();;
    }

    /**
     * 测试 带一个请求头字段
     */
    @Test
    public void testRequestWithHeader() {
        //构造一个Map对象，用来存多个参数和值
        Map<String, String> headers = new HashMap<String,String>();
        headers.put("accept-encoding", "gzip,deflate");
        headers.put("accept-language", "zh-CN");

        given().
            headers(headers).
        when().log().all().
            get("http://jsonplaceholder.typicode.com/posts").
        then().log().all().
            statusCode(200);
    }

    /**
     * 测试 带多个头字段 多个参数的请求
     */
    @Test
    public void testRequestWithHeadersAndParameters() {
        //构造一个Map对象，用来存多个参数和值
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("userId", "2");
        parameters.put("id", "14");

        //构造一个Map对象，用来存多个参数和值
        Map<String, String> headers = new HashMap<String,String>();
        headers.put("accept-encoding", "gzip,deflate");
        headers.put("accept-language", "zh-CN");

        given().
            params(parameters).
            headers(headers).
        when().log().all().
            get("http://jsonplaceholder.typicode.com/posts").
        then().
            statusCode(200).log().all();
    }
}
