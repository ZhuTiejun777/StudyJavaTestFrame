package com.qa.httptest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class TestHttpClient {

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("");
        HttpResponse response = httpClient.execute(httpPost);
        // CloseableHttpResponse
        // DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

    }
}
