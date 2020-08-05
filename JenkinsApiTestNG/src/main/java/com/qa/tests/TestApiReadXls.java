package com.qa.tests;

import com.qa.assertion.Assertion;
import com.qa.base.TestBase;
import com.qa.restclient.RestClientXls;
import com.qa.util.TestUtil;
import jxl.read.biff.BiffException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

import static com.qa.util.TestUtil.readpath;
import static com.qa.util.TestUtil.readresult;

public class TestApiReadXls extends TestBase {

    TestBase testBase;
    String host;
    RestClientXls restClientXls;
    final static org.apache.log4j.Logger Log = Logger.getLogger(TestApiReadXls.class);

    @BeforeClass
    public void beforeclass () {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        restClientXls = new RestClientXls();
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
        String assertResult = readpath(response, path);
        Log.info("Response Code: " + response.getStatusLine().getStatusCode());
        Log.info("Assert: " + assertResult + " and " + resultMap.get("result"));
        Assert.assertEquals(response.getStatusLine().getStatusCode(), Integer.parseInt(resultMap.get("statuscode")));
        Assert.assertEquals(assertResult, resultMap.get("result"));
    }


    @DataProvider(name = "testxlsdata")
    public Object[][] testreadxls () throws IOException, BiffException {
        return TestUtil.readxls(".//data//TestData.xls");
    }
}
