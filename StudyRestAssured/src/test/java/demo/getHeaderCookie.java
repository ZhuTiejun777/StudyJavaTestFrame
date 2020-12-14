package demo;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

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


}
