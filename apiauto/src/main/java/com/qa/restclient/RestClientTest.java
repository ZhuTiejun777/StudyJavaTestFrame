package com.qa.restclient;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RestClientTest {


    //1. Get 请求方法
    public void get(String url) throws ClientProtocolException, IOException {

        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);
        //执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);

        //拿到Http响应状态码，例如和200,404,500去比较
        int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("response status code -->" + responseStatusCode);

        //把响应内容存储在字符串对象
        String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        //创建Json对象，把上面字符串序列化成Json对象
        JSONObject responseJson = JSON.parseObject(responseString);
        System.out.println("respon json from API-->" + responseJson);

        //获取响应头信息,返回是一个数组
        Header[] headerArray = httpResponse.getAllHeaders();
        //创建一个hashmap对象，通过postman可以看到请求响应头信息都是Key和value得形式，所以我们想起了HashMap
        HashMap<String, String> hm = new HashMap<String, String>();
        //增强for循环遍历headerArray数组，依次把元素添加到hashmap集合
        for (Header header : headerArray) {
            hm.put(header.getName(), header.getValue());
        }

        //打印hashmap
        System.out.println("response headers -->" + hm);

    }

}