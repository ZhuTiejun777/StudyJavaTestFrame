package com.qa.experiment;

import com.qa.base.TestBase;
import com.qa.restclient.RestClientXls;
import com.qa.tests.MemberTestApi;
import com.qa.util.TestUtil;
import jxl.read.biff.BiffException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import static com.qa.util.TestUtil.readpath;
import static com.qa.util.TestUtil.readresult;

public class CustomParameterSettings extends TestBase{

    TestBase testBase;
    String host;
    String cookie;
    RestClientXls restClientXls;
    final static org.apache.log4j.Logger Log = Logger.getLogger(MemberTestApi.class);

    @BeforeClass
    public void beforeclass() {
        testBase = new TestBase();
        // 读取配置文件设为全局变量
        // host = prop.getProperty("HOST");
        // cookie = prop.getProperty("COOKIE");
        restClientXls = new RestClientXls();
    }

    @AfterClass
    public void afterclass() {
    }

    @Test(dataProvider = "testxlsdata")
    public void readXlsApiTest(String run, String title, String method, String url, String header, String param, String path, String result, String global) throws IOException {
        CloseableHttpResponse response = null;
        if (run.equals("Y") && method.equals("post")) {
            Log.info("Title: " + title);
            // System.out.println(param);
            // String paramstring = MessageFormat.format(param, global);
            // 发送请求
            response = restClientXls.postCookie(host + url, header, param, cookie);
            Log.info("Response Code: " + response.getStatusLine().getStatusCode());
            // 读取断言结果
            Map<String, String> resultMap = readresult(result);
            // 根据路径获取响应体内容
            String assertResult = readpath(response, path);
            Log.info("Assert: " + assertResult + " and " + resultMap.get("result"));
            Log.info(global);
            Assert.assertEquals(response.getStatusLine().getStatusCode(), Integer.parseInt(resultMap.get("statuscode")));
            Assert.assertEquals(assertResult, resultMap.get("result"));
        } else {
            System.out.println("跳过用例执行:" + title);
        }
    }

    // 读取excel内容
    @DataProvider(name = "testxlsdata")
    public Object[][] testreadxls() throws IOException, BiffException {
        return TestUtil.readxls(".//data//TestFormat.xls");
    }
}
