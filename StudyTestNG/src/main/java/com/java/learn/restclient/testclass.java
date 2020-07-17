package com.java.learn.restclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class testclass {

    public static void main(String[] args) throws IOException {

        /*Object object = "K/DA 伊芙琳";
        String name = null;
        System.out.println(object.toString().substring(1, 2));
        if (!object.toString().substring(1, 2).equals("/")) {
            System.out.println("test");
            name = "sss";
        } else {
            name = object.toString().substring(0, 1) + object.toString().substring(2);
        }
        System.out.println(name);*/

        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://game.gtimg.cn/images/lol/act/img/js/hero/46.js";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = client.execute(httpGet);
        System.out.println(response.getStatusLine().getStatusCode());


    }
}
