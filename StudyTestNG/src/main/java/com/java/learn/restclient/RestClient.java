package com.java.learn.restclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class RestClient {

    private final static String url = "http://www.csdn.net/";

    public static void main(String[] args) throws IOException {
        // 创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建请求
        HttpGet httpGet = new HttpGet(url);
        // 模拟请求头
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36");
        // 关联请求
        CloseableHttpResponse response = httpclient.execute(httpGet);
        // 获取请求实例
        HttpEntity httpEntity = response.getEntity();
        // 请求转化为字符串
        String string = EntityUtils.toString(httpEntity, "UTF-8");
        System.out.println(string);
        response.close();
        httpclient.close();
    }
}
