package com.qa.restclient;

import com.alibaba.fastjson.JSONObject;
import com.qa.util.TestUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RestClientXls {

    final static Logger Log = Logger.getLogger(RestClientXls.class);

    public CloseableHttpResponse post (String url, String header, String param) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        Log.info(url);
        HttpPost httpPost = new HttpPost(url);
        // 处理header字段,添加请求头
        for (String string : header.split(";")) {
            httpPost.setHeader(string.split("\"")[1], string.split("\"")[3]);
            Log.info("Add Header: " + string.split("\"")[1] + "=" + string.split("\"")[3]);
        }
        // 处理param字段,添加请求数据,json格式
        JSONObject objectParam =new JSONObject();
        for (String string : param.split(";")) {
            objectParam.put(string.split("\"")[1], string.split("\"")[3]);
        }
        Log.info("Resqust Param: " + objectParam.toString());
        StringEntity stringEntity = new StringEntity(objectParam.toString());
        // 设置请求编码
        // stringEntity.setContentEncoding("UTF-8");
        // 设置请求ContentType
        // stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        //httpPost.setEntity(TestUtil.disposeParam(param));
        return client.execute(httpPost);
    }

}
