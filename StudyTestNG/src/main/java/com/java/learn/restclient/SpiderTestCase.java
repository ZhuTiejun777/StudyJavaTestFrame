package com.java.learn.restclient;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpiderTestCase {

    private static final String url = "http://192.168.3.192/newDzka/QA/Defect/GetDefects";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // 添加请求头信息
        httpPost.setHeader("cookie", "PowerProject2Auth=55F46D336BB4455E84334A5386488A7936A787AED4C72F5FCBF2D67477A012F5C2C347E730E3D438F258457E035C274FDF31B3E6BFB28FAD757FF792FA2135A67B9E18E69DAA83CB3C54ED8845A2C2B86FD2369F9B09588ED3FE12F053DFBF89; ASP.NET_SessionId=stpzcx55o4jad0puoogiepdk; Cookie_ProjectId=e04a00f0-3a6e-48d0-9b6a-b6b420e9d1f5; Cookie_DefectState=所有缺陷");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        // 添加请求参数,发送表单格式数据使用List<NameValuePair>实例化数据
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("relate", "所有缺陷"));
        parameters.add(new BasicNameValuePair("state", "新问题"));
        parameters.add(new BasicNameValuePair("dateType", "提交时间"));
        parameters.add(new BasicNameValuePair("versionType", "发现版本"));
        parameters.add(new BasicNameValuePair("sort", "提交日期"));
        parameters.add(new BasicNameValuePair("order", "desc"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        /*formEntity.setContentType("application/x-www-form-urlencoded");
        formEntity.setContentEncoding("UTF-8");*/
        httpPost.setEntity(formEntity);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
                JSONObject jsonObject = JSON.parseObject(content);
                System.out.println(jsonObject);
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
