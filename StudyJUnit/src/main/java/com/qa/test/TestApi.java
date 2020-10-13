package com.qa.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class TestApi {

    static String url = "http://192.168.1.18:8088/bankApi/queryCustSubaccountBalance";

    public static void main(String[] args) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("custAcctId", "3294000000037057");
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(httpPost);
        //System.out.println(response.getStatusLine().getStatusCode());
        /*String string = response.getEntity().toString();
        System.out.println(string);*/
        String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
        //System.out.println(responseString);
        JSONObject responsejson = JSON.parseObject(responseString);
        //System.out.println(responsejson);
        String jsonpath = "$.payload.BodyMsg";
        String result = JSONPath.read(responseString, jsonpath).toString();
        // --8475.14  --8300.14  --8001.14  --7878.54  --7353.54 --7003.54
        System.out.println(result.split("&")[2]);
        //System.out.println(result);
    }
}
