package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.restclient.RestClient;
import com.qa.util.TestUtil;

public class GetApiTest extends TestBase{
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;


    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host + "/api/users?page=2";

    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        restClient = new RestClient();
        closeableHttpResponse = restClient.get(url);

        //断言状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_200, "response status code is not 200");

        //把响应内容存储在字符串对象
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");

        //创建Json对象，把上面字符串序列化成Json对象
        JSONObject responseJson = JSON.parseObject(responseString);
        //System.out.println("respon json from API-->" + responseJson);

        //json内容解析
        String s1 = TestUtil.getValueByJPath(responseJson,"data[0]/first_name");
        String s2 = TestUtil.getValueByJPath(responseJson,"data[1]/id");
        String s3 = TestUtil.getValueByJPath(responseJson,"per_page");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        //常用测试断言,实际结果,预期结果,断言失败打印日志
        Assert.assertEquals(s1, "Michael", "first name is Michael");
    }
}