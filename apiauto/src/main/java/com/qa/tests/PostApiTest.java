package com.qa.tests;

import java.io.*;
import java.util.*;

import com.qa.util.TestUtil;
import jxl.read.biff.BiffException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.restclient.RestClient;

public class PostApiTest extends TestBase {

    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;
    final static Logger Log = Logger.getLogger(TestBase.class);

    @BeforeClass
    public void setUp() {
        host = prop.getProperty("HOST");
        url = host + "/bankApi/queryCustSubaccountBalance";
        restClient = new RestClient();
    }

    @Test(dataProvider = "custacctid")
    public void postApiTest(String id, String custacctid, String balance) throws IOException {
        restClient = new RestClient();
        //准备请求头信息
        HashMap<String,String> headermap = new HashMap<String,String>();
        headermap.put("Content-Type", "application/json"); //这个在postman中可以查询到

        //对象转换成Json字符串
        /*Users user = new Users("Anthony","tester");
        String userJsonString = JSON.toJSONString(user);*/
        //System.out.println(userJsonString);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("custAcctId", custacctid);
        String userJsonString = jsonObject.toString();

        closeableHttpResponse = restClient.post(url, userJsonString, headermap);

        //验证状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_200,"status code is not 200");

        //断言响应json内容中name和job是不是期待结果
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = JSON.parseObject(responseString);
        //String string = responseJson.getJSONObject("payload").getString("BodyMsg").split("&")[1];
        String string = responseJson.getJSONObject("payload").getString("BodyMsg").split("&")[1];
        System.out.println(responseString);
        System.out.println(id + ":" +string + ":" + balance);
        System.out.println(Double.parseDouble(balance) - Double.parseDouble(string));
        Assert.assertEquals(string,balance);
        /*Assert.assertEquals(string, balance, "Are equal in amount");*/
        /*String name = TestUtil.getValueByJPath(responseJson, "name");
        String job = TestUtil.getValueByJPath(responseJson, "job");*/
        /*String bodymsg = TestUtil.getValueByJPath(responseJson, "payload[0]/BodyMsg");
        System.out.println(bodymsg);*/
        /*Assert.assertEquals(name, "Anthony","name is not same");
        Assert.assertEquals(job, "tester","job is not same");*/

    }


    @DataProvider(name = "custacctid")
    public Object[][] custacctid () throws IOException {
        return TestUtil.readcsv(".//data//custacctid.csv");
    }


    /*@DataProvider(name = "custacctid")
    public Object[][] custacctid () throws FileNotFoundException {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
        *//*FileInputStream fileInputStream = new FileInputStream(".//date//custacctid.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);*//*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(".//date//custacctid.csv")));

    }*/

    /*@DataProvider(name = "custacctid")
    public Object[][] custacctid () {
        Object[][] objects = new Object[2][2];
        objects[0][0] = "custAcctId";
        objects[0][1] = "3294000000037057";
        objects[1][0] = "custAcctId";
        objects[1][1] = "3294000000102488";
        return objects;
    }*/

}