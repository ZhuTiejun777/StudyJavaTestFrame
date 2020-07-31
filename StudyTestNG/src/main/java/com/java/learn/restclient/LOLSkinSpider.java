package com.java.learn.restclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.Map;

public class LOLSkinSpider {

    private static final String jointurl = "https://game.gtimg.cn/images/lol/act/img/js/hero/";
    private static final String basepath = "C:\\Users\\Administrator\\Desktop\\英雄联盟";

    public static void main(String[] args) throws IOException {

        File basefile = new File(basepath);
        if (!basefile.exists()) {
            basefile.mkdir();
        }
        CloseableHttpClient client = HttpClients.createDefault();
        for (int i = 1; i <= 100; i ++) {
            String url = jointurl + i + ".js";
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = null;
            try {
                response = client.execute(httpGet);
                /*System.out.println(i);
                System.out.println(response.getStatusLine().getStatusCode());*/
                if (response.getStatusLine().getStatusCode() == 404) {
                    continue;
                }
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject jsonObject = JSONObject.parseObject(content);
                String name = jsonObject.getJSONObject("hero").getString("name");
                System.out.println("开始下载" + name + "皮肤");
                JSONArray jsonArray = jsonObject.getJSONArray("skins");
                String namepath = basefile + "\\" + name;
                File namefile = new File(namepath);
                if (!namefile.exists()) {
                    namefile.mkdir();
                }
                for (int j = 0; j < jsonArray.size(); j ++) {
                    Map<String, Object> map = JSON.parseObject(jsonArray.getString(j));
                    if (!map.get("mainImg").equals("")) {
                        System.out.println(map.get("mainImg"));
                        CloseableHttpClient savepictureclient = HttpClients.createDefault();
                        HttpGet savepicturehttpget = new HttpGet(map.get("mainImg").toString());
                        CloseableHttpResponse pictureresponse = savepictureclient.execute(savepicturehttpget);
                        HttpEntity httpEntity = pictureresponse.getEntity();
                        byte[] bytes = EntityUtils.toByteArray(httpEntity);
                        String picturepath = null;
                        if (!map.get("name").toString().substring(1, 2).equals("/")) {
                            picturepath = namepath + "\\" + map.get("name") + ".png";
                        } else {
                            picturepath = namepath + "\\" + map.get("name").toString().substring(0, 1) + map.get("name").toString().substring(2) + ".png";
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(picturepath));
                        bufferedOutputStream.write(bytes);
                        System.out.println(map.get("name") + "图片,保存成功!");
                        bufferedOutputStream.close();
                    }
                }
            System.out.println("--------------------");
            } finally {
                if (response == null) {
                    response.close();
                }
            }
        }
        client.close();
    }
}
