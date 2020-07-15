package com.java.learn.restclient;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class SpiderTestCase {

    private static final String url = "http://192.168.3.192/newDzka/QA/Defect/GetDefects";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // 添加请求头信息
        httpPost.setHeader("cookie", "ASP.NET_SessionId=4nd3cyupojx4bmdiy5exhn51; __RequestVerificationToken_L25ld0R6a2E1=Cv0VAGIt7UAYSQZcygUTKrj36e8-aJWnTv23MG4wlkZ8RUazDqjrBJ7BAaQxlCm1SdCfL9uNAlg8KIrBCF-FzpFyXGkrcQ4-k2CbNiGQa_M1; PowerProject2Auth=CD35E5AE58D521C27A7AEDC4A3EE92F0139039C299D142ED361D2D6B83E8F828EC1AD8D822FE645C9A864FADD57A732747B9D272F1DCF89307FE5CEBD25E2B001A9BA98E1351FFC234E8FD94B2E2350AA260DA26C4AB7BE105BBACB36B96CD14;");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        // 添加请求参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("relate", "所有缺陷");
        jsonObject.put("state", "新问题");
        jsonObject.put("dateType", "提交时间");
        jsonObject.put("versionType", "发现版本");
        jsonObject.put("sort", "提交日期");
        jsonObject.put("order", "desc");
        // httpPost.setEntity(new StringEntity(jsonObject.toString(), Charset.forName("UTF-8")));


        /*MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        if (params != null) {
            for (String key : params.keySet()) {
                builder.addPart(key,
                        new StringBody(params.get(key), ContentType.create("text/plain", Consts.UTF_8)));
            }
        }

        HttpEntity reqEntity = builder.build();*/

        CloseableHttpResponse response = null;

        try {
            response = client.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response == null) {
                response.close();
            }
        }
        client.close();
    }

     /*public ArrayList<String> resquesttestcase(String url, JSONObject jsonobject, String cookie) {

    }*/


}
