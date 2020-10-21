package com.qa.practice;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class PracticeHttpClient {

    String url = "https://www.baidu.com";

    public void get(String url) throws IOException {
        //1.实例化浏览器对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.实例化get请求对象
        HttpGet httpget = new HttpGet(url);
        //3.发送请求，关联实例化浏览器httpclient和实例化get请求httpget
        CloseableHttpResponse getresponse = httpclient.execute(httpget);
        //4.获取请求的响应体
        HttpEntity getentity = getresponse.getEntity();

        //响应乱码转换“utf-8”
        StringBuilder result = new StringBuilder();//响应正文
        if (getentity != null) {
            InputStream instream = getentity.getContent();
            byte[] bytes = new byte[4096];
            int size = 0;
            try {
                while ((size = instream.read(bytes)) > 0) {
                    String str = new String(bytes, 0, size, "utf-8");
                    result.append(str);
                }
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            System.out.println(result.toString());

//        //响应乱码转换“utf-8”
//        StringBuilder result = new StringBuilder();//响应正文
//        if (getentity != null) {
//            String charset = getContentCharSet(getentity);
//            InputStream instream = getentity.getContent();
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    instream,"utf-8"));
//            String temp = "";
//            while ((temp = br.readLine()) != null) {
//                result.append(temp+"\n");
//            }
//        }
//        System.out.println(result.toString());


//        //5.打印响应状态
//        System.out.println(getresponse.getStatusLine());
//        //6.判断响应体是否为空,打印响应长度和响应内容
//        if (null != getentity) {
//            //响应长度
//            System.out.println("Response content length:" + getentity.getContentLength());
//            //响应体
//            System.out.println("Response content is:\n" + EntityUtils.toString(getentity));
//        }

        //7.关闭接口请求
        getresponse.close();
        //8.关闭实例化浏览器对象，释放资源
        httpclient.close();
    }

    public static void main(String[] args) throws IOException {
        PracticeHttpClient cc = new PracticeHttpClient();
        System.out.println(cc.url);
        cc.get(cc.url);
    }
}
