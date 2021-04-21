package com.qa.exercises;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.google.gson.annotations.Until;
import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.xmlbeans.impl.piccolo.xml.Entity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class InsertSql {

    public static void main(String[] args) throws IOException {

        // 表单格式请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://122.224.69.187:57145/sso/login?service=http%3A%2F%2F122.224.69.187%3A57139%2Fmember%2Flogin%2Fhome");
        // httpGet.setHeader("", "application/json; charset=utf-8");
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("repeatSubmitToken","3851c68c-f9c2-452e-9c45-73a7b1c3ba69"));
        nvps.add(new BasicNameValuePair("loginflag","common"));
        nvps.add(new BasicNameValuePair("loginTab","common"));
        nvps.add(new BasicNameValuePair("login","true"));
        nvps.add(new BasicNameValuePair("needVerifyCode",null));
        nvps.add(new BasicNameValuePair("userId","JTWL05"));
        nvps.add(new BasicNameValuePair("password","linxy1990"));
        nvps.add(new BasicNameValuePair("verifyCode","7473"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String resultResponse = EntityUtils.toString(responseEntity, "UTF-8");
        System.out.println(resultResponse);
    }

    @Test
    public String loginGetCookie () throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://test.etczj.com:8080/member/toLogin");

        httpPost.setHeader("Accept","application/json, text/plain, */*");
        // httpPost.setHeader("Accept-Encoding","gzip, deflate, br");
        // httpPost.setHeader("Accept-Language","zh-CN,zh;q=0.9");
        // httpPost.setHeader("JSESSIONID", "94CB583A8E30099DA37D1A8705156134");
        httpPost.setHeader("Cookie", "UM_distinctid=176a7569df02a1-0d23bf735f4f2d-16386153-1ea000-176a7569df19d8; CNZZDATA1278868486=1375510069-1609125240-%7C1615968281; " + loginVerifyCode());
        httpPost.setHeader("Content-Type","application/json;charset=UTF-8");
        httpPost.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.192 Safari/537.36");
        // httpPost.setHeader("Host","test.etczj.com:8080");
        //httpPost.setHeader("","");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("acctId", "15094666644");
        jsonObject.put("password", "qwe12345");
        jsonObject.put("checkCode", "6666");

        // StringEntity stringEntity = new StringEntity(jsonObject.toString(), "UTF-8");
        HttpEntity httpEntity = new StringEntity(jsonObject.toString(), "UTF-8");
        httpPost.setEntity(httpEntity);

        CloseableHttpResponse response = client.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        // System.out.println(result);
        String cookie = null;
        if (JSONPath.read(result, "$.msg").equals("成功")) {
            Header[] headers = response.getHeaders("Set-Cookie");
            for (Header header : headers) {
                // System.out.println(header.getName());
                System.out.println(header.getValue().split(";")[0]);
                cookie = header.getValue().split(";")[0];
                // System.out.println("-----------");
            }
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
        return cookie;
    }

    @Test
    public String loginVerifyCode () throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://test.etczj.com:8080/createCaptcha?verifyCodeSize=null&amp;tmp=0.22059576956969984");

        httpGet.setHeader("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
        // httpGet.setHeader("JSESSIONID", "6628B27AFD781B097178E87448D3DB82");
        // httpGet.setHeader("Cookie", "UM_distinctid=176a7569df02a1-0d23bf735f4f2d-16386153-1ea000-176a7569df19d8; CNZZDATA1278868486=1375510069-1609125240-%7C1615968281; JSESSIONID=204028A0171BC62FF255631A7345B05A");
        httpGet.setHeader("Referer", "https://test.etczj.com:8080/");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36");
        // httpGet.setHeader("", "");
        String jsessionid = null;
        CloseableHttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        // System.out.println(response);
        Header[] headers = response.getHeaders("Set-Cookie");
        for (Header header : headers) {
            // System.out.println(header.getName());
            // System.out.println(header.getValue());
            jsessionid = header.getValue().split(";")[0];
            // System.out.println("-----------");
        }
        // System.out.println(jsessionid);
        return jsessionid;
    }

    @Test
    public void getViewMember () throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://test.etczj.com:8080/member/viewMember");
        httpPost.setHeader("Cookie", "UM_distinctid=176a7569df02a1-0d23bf735f4f2d-16386153-1ea000-176a7569df19d8; CNZZDATA1278868486=1375510069-1609125240-%7C1615968281; " + loginGetCookie());
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        // 设置响应时间
        RequestConfig config = RequestConfig.custom().setConnectTimeout(10000)
                .setSocketTimeout(10000).build();
        httpPost.setConfig(config);
        CloseableHttpResponse response = client.execute(httpPost);
        // 在同一个httpclient中只能有一个获取entity的方法
        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(result);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(JSONPath.read(result, "$.payload.account"), "15094666644");
        Assert.assertEquals(JSONPath.read(result, "$.payload.customerId"), "666666");
    }

    //使用httpclient请求保存图片
    @Test
    public void test05 () throws IOException {
        String url_1 = "https://www.mayiwenku.com/FileRoot1/2018-4/26/1764faaf-8f95-4308-b383-29b1ab864e04/1764faaf-8f95-4308-b383-29b1ab864e04";
        String url_2 = "https://www.mayiwenku.com/FileRoot1/2018-6/10/602a6d08-34f3-4a69-ba1e-edb30d349bfc/602a6d08-34f3-4a69-ba1e-edb30d349bfc";
        String url_3 = "https://www.mayiwenku.com/FileRoot1/2018-11/15/3a23b918-b79e-43fb-a035-1ef57a58b126/3a23b918-b79e-43fb-a035-1ef57a58b126";
        String url_4 = "https://www.mayiwenku.com/FileRoot2/2019-3/21/424d14b5-c80b-4718-b633-70606fe1d3bc/424d14b5-c80b-4718-b633-70606fe1d3bc";
        String url_5 = "https://www.mayiwenku.com/FileRoot2/2019-3/10/d2411400-b98f-4d25-bbf3-9990fb6ab26c/d2411400-b98f-4d25-bbf3-9990fb6ab26c";
        String url_6 = "https://www.mayiwenku.com/FileRoot1/2018-5/5/faae79df-769c-46f3-a2f1-bc8e43d82cc7/faae79df-769c-46f3-a2f1-bc8e43d82cc7";
        String url_7 = "https://www.mayiwenku.com/FileRoot2/2019-9/11/a970e48a-9497-4c38-a258-c194ab6fdf9e/a970e48a-9497-4c38-a258-c194ab6fdf9e";
        String savePath = "/Users/tiejunzhu/Desktop/images/";
        File file = new File(savePath);//创建File对象
        //如果文件夹不存在则创建
        if  (!file .exists()  && !file .isDirectory()) {
            System.out.println("//不存在");
            file.mkdir();
        } else {
            System.out.println("//目录存在");
        }
        /*if (!file.exists()) {//判断f 如果不存在,就创建
            try {
                file.createNewFile();//创建
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = null;
        for (int i = 1; i < 13; i ++) {
            String urlPin = url_7 + String.valueOf(i) + ".gif";
            httpGet = new HttpGet(urlPin);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(50000).setConnectTimeout(50000).build();
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36");
            try {
                CloseableHttpResponse response = client.execute(httpGet);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    FileUtils.copyInputStreamToFile(inputStream, new File(new File(savePath + String.valueOf(i)) + ".png"));
                    System.out.println("下载图片成功:" + urlPin);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
                throw new RuntimeException(ioException);
            } finally {
                httpGet.releaseConnection();
            }
        }
    }

    @Test
    public void test06 () throws IOException {
        String loaclPath = "/Users/tiejunzhu/Desktop/KAHMD20210324_01.txt";
        //win系统
        //String path = "c:\\hello.txt";
        FileInputStream fileInputStream = new FileInputStream(loaclPath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        List<String> loaclList = new ArrayList<>();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            // System.out.println(line.split("\\|")[0]);
            loaclList.add(line.split("\\|")[0]);
        }

        fileInputStream.close();
    }

    @Test
    public List<String> test07 () {
        String loaclPath = "/Users/tiejunzhu/Desktop/KAHMD20210324_01.txt";
        String onlinePath = "/Users/tiejunzhu/Desktop/线上KAHMD20210324_01.txt";
        List<String> resultList = new ArrayList<>();
        try {
            BufferedReader loaclBufferedReader = new BufferedReader(new FileReader(onlinePath));
            String loaclline = null;
            while ((loaclline = loaclBufferedReader.readLine()) != null) {
                // System.out.println(line.split("\\|")[0]);
                resultList.add(loaclline.split("\\|")[0]);
            }
            /*BufferedReader onlineBufferedReader = new BufferedReader(new FileReader(loaclPath));
            String onlineline = null;
            while ((onlineline = onlineBufferedReader.readLine()) != null) {
                resultList.remove(onlineline.split("\\|")[0]);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(resultList);
        try {
            BufferedReader onlineBufferedReader = new BufferedReader(new FileReader(loaclPath));
            String onlineline = null;
            while ((onlineline = onlineBufferedReader.readLine()) != null) {
                resultList.remove(onlineline.split("\\|")[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(resultList);
        System.out.println(resultList.size());
        return resultList;
    }

    @Test
    public void test08 () throws IOException {
        String url = "http://122.224.69.187:57139/member/vehicleSignManage/viewVehicleSignPage";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cardCode", "33011811230200852034");
        jsonObject.put("currPage", 1);
        jsonObject.put("cardpageSizeCode", 10);
        jsonObject.put("totalNum", 0);
        jsonObject.put("totalPage", 1);
        String result = testRequest(url, jsonObject);
        // System.out.println(JSONPath.read(result, "$.payload.resultList[0].customerId"));
        System.out.println(JSONPath.read(result, "$.payload.resultList[0].vehicleNo"));
        // System.out.println(JSONPath.read(result, "$.payload.resultList[0].fleetCustId"));
        if (Integer.parseInt((JSONPath.read(result, "$.payload.resultList[0].fleetCustId")).toString()) == 0) {
            System.out.println(JSONPath.read(result, "$.payload.resultList[0].customerId"));
        } else {
            System.out.println(JSONPath.read(result, "$.payload.resultList[0].fleetCustId"));
        }
    }

    public String testRequest (String url, JSONObject jsonObject) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("Cookie", "userId=JTWL05; JSESSIONID=FA3725CACF741463F39BE464398DBE2C");
        HttpEntity httpEntity = new StringEntity(jsonObject.toString(), "UTF-8");
        httpPost.setEntity(httpEntity);
        CloseableHttpResponse response = client.execute(httpPost);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    @Test
    public void test09 () throws IOException {
        //String url = "http://192.168.66.58:8889/hsjry/admin/admin/v1/guardUserLogin/byPassword";
        String url = "http://192.168.66.58:8889/hsjry/flow/ICommonApprovalQuery/queryPage";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        //httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        //httpPost.setHeader("Cookie", "_ga=GA1.1.992160437.1617007955; _gid=GA1.1.1475575692.1617007955");
        // 采用明文拼接
        String str = java.net.URLEncoder.encode("organName=总部&organId=100000&operatorId=admin&operatorName=超级管理员&authId=admin&token=99F9039694BF48EEB0AF0D4ECBCB74A8", StandardCharsets.UTF_8);
        System.out.println(str);
        String str1 = java.net.URLDecoder.decode("organName=总部&organId=100000&operatorId=admin&operatorName=超级管理员&authId=admin&token=99F9039694BF48EEB0AF0D4ECBCB74A8", StandardCharsets.UTF_8);
        httpPost.setHeader("Rpc-Hsjry-User-Request", "organName=总部&organId=100000&operatorId=admin&operatorName=超级管理员&authId=admin&token=99F9039694BF48EEB0AF0D4ECBCB74A8");
        httpPost.setHeader("Rpc-Hsjry-Request", "serviceScene=002&answer=969&channelNo=021&transDateTime=2021-03-31 18:21:35&ask=962&tenantId=000&sign=&idemSerialNo=V3OT5t6Hc1uMKJX3iYSH9WQNJGgKWg4w&serialNo=eTSjxxyMbvQOVllS5LqDKa5xH8lxl56D");
        httpPost.setHeader("Cache-Control", "no-cache");
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("X-Forwarded-For", "109.75.48.14");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageSize", 100);
        jsonObject.put("pageNum", 1);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("1");
        jsonArray.add("2");
        jsonArray.add("3");
        jsonArray.add("4");
        jsonArray.add("5");
        jsonArray.add("6");
        //jsonObject.put("processTypeList", "['1','2','3','4','5','6']");
        jsonObject.put("processTypeList", jsonArray.toString());
        jsonObject.put("isToDoPage", "true");
        jsonObject.put("finishFlag", "N");
        jsonObject.put("status", "020");
        //jsonObject.put("picCode", "");
        System.out.println(jsonObject.toString());
        String requestString = "{\"pageNum\":1,\"pageSize\":100,\"processTypeList\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"],\"isToDoPage\":true,\"finishFlag\":\"N\",\"status\":\"020\"}";
        httpPost.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
        //httpPost.setEntity(new StringEntity(requestString, "UTF-8"));
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
    }


    @Test
    public void test10 () {
        String hsjry1 = "YXNrPTk2MiZhbnN3ZXI9OTY5JnNlcmlhbE5vPUFGQ0FGQkI1MzQzM0Y3NDQ1MDlCODI2RjMyQ0Q5NDQ2JmlkZW1TZXJpYWxObz0yQzlCQ0FDNjI4OTZGQjQzMjdCOTlBOTI3RTFCN0UyMyZzZXJ2aWNlU2NlbmU9MDAyJnRyYW5zRGF0ZVRpbWU9MjAyMS0wMy0zMCAxNzoyMToyNiZ0ZW5hbnRJZD0wMDAmY2hhbm5lbE5vPTIxJnNpZ249MQ==";
        String hsjry2 = "YXNrPTk2MiZhbnN3ZXI9OTY5JnNlcmlhbE5vPTNBNzg5M0NCMTBDMzcyNEMzQzY4QjhDRkExRDhGRkRDJmlkZW1TZXJpYWxObz02NTlFQkE0QkRBQjg5QTQ3NEY2OTBDMUM0ODQyRTA2RiZzZXJ2aWNlU2NlbmU9MDAyJnRyYW5zRGF0ZVRpbWU9MjAyMS0wMy0zMCAxNzoyMToyNiZ0ZW5hbnRJZD0wMDAmY2hhbm5lbE5vPTIxJnNpZ249MQ==";

        String hsjry3 = "YXV0aElkPWFkbWluJnRva2VuPUQzOTdCREQ5MENDNTRFQkVBODJGNjE0QTYxMjc2NDg1Jm9wZXJhdG9ySWQ9YWRtaW4mb3BlcmF0b3JOYW1lPei2hee6p+euoeeQhuWRmCZvcmdhbklkPTEwMDAwMCZvcmdhbk5hbWU95oC76YOo";
        String hsjry4 = "YXV0aElkPWFkbWluJnRva2VuPUQzOTdCREQ5MENDNTRFQkVBODJGNjE0QTYxMjc2NDg1Jm9wZXJhdG9ySWQ9YWRtaW4mb3BlcmF0b3JOYW1lPei2hee6p+euoeeQhuWRmCZvcmdhbklkPTEwMDAwMCZvcmdhbk5hbWU95oC76YOo";

        String token2 = "D6884E4F7445104D99BC1FB1EC1EF10B";
        String token3 = "BC93EA6CAA3FF045359A8FEDB6C5080F";
        String token4 = "8C6CD5CD2617DE4497F885968F219C6B";
        String token5 = "2B87276990BE432781E076BE692348AA";
        String token6 = "2B87276990BE432781E076BE692348AA";

        String md5str = "a3f5d8b533e5e35a95c6bd6bbcad94bc";
    }
}
