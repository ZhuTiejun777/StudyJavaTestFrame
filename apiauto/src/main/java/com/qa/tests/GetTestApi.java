package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.restclient.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetTestApi extends TestBase {

    TestBase testBase;
    String host;
    String url;
    RestClient restClient;

    @BeforeClass
    public void setUp(){
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host + "/api/users";
    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        restClient = new RestClient();
        restClient.get(url);
    }
}
