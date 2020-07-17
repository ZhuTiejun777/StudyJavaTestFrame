package com.java.learn.restclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class userInfo {

    private static final String url = "http://192.168.3.224:9002/szpen-swchk-web/share/shareSubjectList";

    public static void main(String[] args) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Cookie", "JSESSIONID=2D588C0D96EF37313D9224D17BC0230E; userId=zheng; userName=%E5%AE%A2%E6%9C%8D2017");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("page", 1);
        jsonObject.put("size", 10);
        // 发送json格式数据使用StringEntity实例化
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content);
            }
        } finally {
            if (response == null) {
                response.close();
            }
        }
        client.close();
    }
}
