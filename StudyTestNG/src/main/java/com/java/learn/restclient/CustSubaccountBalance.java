package com.java.learn.restclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;

/**
 * 请求参数为JSON格式的post请求
 */

public class CustSubaccountBalance {
    private static final String url = "http://192.168.1.18:8088/bankApi/queryCustSubaccountBalance";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // 设置请求头
        // httpPost.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        // 设置请求参数
        JSONObject obj = new JSONObject();
        obj.put("custAcctId", "3294000000101887");
        // 关联请求参数
        StringEntity stringEntity = new StringEntity(obj.toString());
        // 设置请求编码
        stringEntity.setContentEncoding("UTF-8");
        // 设置请求ContentType
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        try {
            // 发送请求
            response = client.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
                // string转化为json格式,Json字符串转换成JSONObject对象
                JSONObject jsonObject=JSONObject.parseObject(content);
                JSONObject jsonObject1 = jsonObject.getJSONObject("payload");
                String string = jsonObject1.getString("BodyMsg");
                System.out.println(string.split("&")[1]);
                System.out.println(string.split("&")[2]);
                //Assert.assertEquals(string.split("&")[2], "0.00");
                //System.out.println(jsonObject1.getString("BodyMsg"));
                //System.out.println(jsonObject);
                // json格式转化为string
                String text = jsonObject.toJSONString();
                //System.out.println(text);
            }
        } finally {
            if (response == null) {
                response.close();
            }
        }
        client.close();
    }
}
