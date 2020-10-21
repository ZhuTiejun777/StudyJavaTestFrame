package com.qa.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.restclient.RestClient;
import com.qa.restclient.RestClientXls;
import com.qa.util.TestUtil;
import jxl.read.biff.BiffException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.qa.util.TestUtil.*;

public class TestApiReadXls extends TestBase {

    Map<String, String> globalvariable;

    TestBase testBase;
    String host;
    RestClientXls restClientXls;
    final static org.apache.log4j.Logger Log = Logger.getLogger(TestApiReadXls.class);

    @BeforeClass
    public void beforeclass () {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        restClientXls = new RestClientXls();
        globalvariable = null;
    }

    @AfterClass
    public void afterclass () {
    }

    @Test(dataProvider = "testxlsdata")
    public void readXlsApiTest (String run, String title, String method, String url, String header, String param, String path, String result) throws IOException {
        CloseableHttpResponse response = null;
        if (run.equals("Y")) {
            Log.info("执行用例:" + run);
            Log.info("Title: " + title);
            Log.info("Method :" + method);
            if (method.equals("get")) {
                System.out.println("get");
            } else if (method.equals("post")) {
                response = restClientXls.post(host+url , header, param);
                Map<String, String> resultMap = readresult(result);
                String assertResult = readpath(response, path);
                Log.info("Response Code: " + response.getStatusLine().getStatusCode());
                Log.info("Assert: " + assertResult + " and " + resultMap.get("result"));
                Assert.assertEquals(response.getStatusLine().getStatusCode(), Integer.parseInt(resultMap.get("statuscode")));
                Assert.assertEquals(assertResult, resultMap.get("result"));
            } else if (method.equals("put")) {
                System.out.println("put");
            } else if (method.equals("delete")) {
                System.out.println("delete");
            }
        } else {
            System.out.println("跳过用例执行:" + title);
        }
    }


    @Test(dataProvider = "testxlsdata")
    public void readXlsPostApiTest (String run, String title, String method, String url, String header, String param, String path, String result) throws IOException {
        if (run.equals("Y")) {
            Log.info("执行用例:" + run);
        }
        Log.info("Title: " + title);
        Log.info("Method :" + method);
        CloseableHttpResponse response = restClientXls.post(host+url , header, param);
        Map<String, String> resultMap = readresult(result);
        //String assertResult = readpath(response, path);
        String assertResult = readjsonpath(response, path);
        Log.info("Response Code: " + response.getStatusLine().getStatusCode());
        Log.info("Assert: " + assertResult + " and " + resultMap.get("result"));
        Assert.assertEquals(response.getStatusLine().getStatusCode(), Integer.parseInt(resultMap.get("statuscode")));
        Assert.assertEquals(assertResult, resultMap.get("result"));
    }


    @DataProvider(name = "testxlsdata")
    public Object[][] testreadxls () throws IOException, BiffException {
        return TestUtil.readxls(".//data//TestData.xls");
    }


    @Test(dataProvider = "testxlsdata")
    public void ApiTest (String run, String title, String method, String url, String header, String param, String path, String result) throws IOException {
        /*System.out.println(run);
        System.out.println(title);
        System.out.println(method);
        System.out.println(url);
        System.out.println(header);
        System.out.println(param);
        System.out.println(result);*/
        /*CloseableHttpResponse response = null;
        String resultUrl = host + url;
        if (!run.equals("Y")) {
            Log.info(title);
            if (method.equals("get")) {
                response = restClient.get(resultUrl);
            } else if (method.equals("post")) {
                response = restClient.post(resultUrl, header, param);
            } else if (method.equals("put")) {
                response = restClient.put(resultUrl);
            } else if (method.equals("delete")) {
                response = restClient.delete(resultUrl);
            }
        } else {
            System.out.println("跳过用例执行:" + title);
        }*/
        if (run.equals("Y")) {
            Log.info("执行用例:" + run);
        }
        Log.info("Title: " + title);
        Log.info("Method :" + method);
        /*Log.info("Url: " + host + url);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(host + url);
        // 处理header字段,添加请求头
        for (String string : header.split(";")) {
            post.setHeader(string.split("\"")[1], string.split("\"")[3]);
            Log.info("Add Header: " + string.split("\"")[1] + "=" + string.split("\"")[3]);
        }
        // 处理param字段,添加请求数据,json格式
        JSONObject objectParam =new JSONObject();
        for (String string : param.split(";")) {
            objectParam.put(string.split("\"")[1], string.split("\"")[3]);
        }
        String stringParam = objectParam.toString();
        Log.info("Resqust Param: " + stringParam);
        post.setEntity(new StringEntity(stringParam));*/

        CloseableHttpResponse response = restClientXls.post(host+url , header, param);

        // 处理result字段,获取断言
        /*Map<String,String> maps = new HashMap<String, String>();
        for (String string : result.replaceAll("\n", "").split(";")) {
            maps.put(string.split("=")[0], string.split("=")[1]);
            Log.info("Result: " + string.split("=")[0] + "=" + string.split("=")[1]);
        }*/
        Map<String, String> maps = readresult(result);

        /*String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        Log.info("Response Param: " + content);
        JSONObject object = JSON.parseObject(content);
        String balance = object.getJSONObject("payload").getString("BodyMsg").split("&")[1];*/
        String balance = readpath(response, path);
        Log.info("Response Code: " + response.getStatusLine().getStatusCode());
        Log.info("Assert: " + balance + " and " + maps.get("balance"));
        Assert.assertEquals(response.getStatusLine().getStatusCode(), Integer.parseInt(maps.get("statuscode")));
        Assert.assertEquals(balance, maps.get("balance"));
    }


}
