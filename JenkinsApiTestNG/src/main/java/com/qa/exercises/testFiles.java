package com.qa.exercises;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class testFiles {

    String filePath = "/Users/tiejunzhu/Desktop/文件存放/图片存放/车辆图片/cheliangtupian.jpg";
    String fileUrl_4_1 = "http://122.224.69.187:57200//kwl/2021/1/21/kwl-022d882f-4eb5-41e1-85d9-8235fd8b6c5c.jpg";
    String fileUrl_1_1 = "https://gss0.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/w=580/sign=0e864d0c36a85edffa8cfe2b795509d8/c556c0fdfc039245643fc5538594a4c27c1e257f.jpg";
    String fileUrl_1_2 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=355671372,1997750189&fm=26&gp=0.jpg";
    String fileUrl_1_4 = "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2FyE9IRkFdrdtpEXYb81Hf347A9gMFzNBt7D9%3D7Lw3VRbaW1529916621298.jpg&thumbnail=650x2147483647&quality=80&type=jpg";
    String fileUrl_1_5 = "https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/3812b31bb051f819e5e89412dcb44aed2f73e79d.jpg";
    String fileUrl_1_6 = "http://img.mp.sohu.com/upload/20170613/22284fa8eb024cea89601ae00a20c756_th.png";
    String fileUrl_2_1 = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3033305210,3938206008&fm=26&gp=0.jpg";
    String fileUrl_2_2 = "http://5b0988e595225.cdn.sohucs.com/images/20180830/d5f50bf1eab34d1fa1717681076c067c.jpeg";
    String fileUrl_2_3 = "http://pimg.39.net/PictureLib/A/f76/20170125/org_905692.jpg";
    String fileUrl_2_4 = "http://img.mp.itc.cn/upload/20170813/9a7d46e31a02460e8f429a03989f55c8_th.jpg";
    //String fileUrl_3_2 = "";
    String linuxFilePath_4_1 = "/usr/local/etc-manager/kwe-manager-webapp/filePath/kwl-022d882f-4eb5-41e1-85d9-8235fd8b6c5c.jpg";
    String linuxFilePath_1_1 = "/usr/local/etc-manager/kwe-manager-webapp/filePath/c556c0fdfc039245643fc5538594a4c27c1e257f.jpg";

    @Test
    public void testFile () {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String url = "https://test.etczj.com:8080/ocr";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("filePath", fileUrl_2_4);
        jsonObject.put("ocrType", 2);
        jsonObject.put("side", "front");
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            /* FileBody fileBody = new FileBody(new File(filePath));
            StringBody ocrTypeBody = new StringBody("4", ContentType.create("text/plain", Consts.UTF_8));
            StringBody sideBody = new StringBody("front", ContentType.create("text/plain", Consts.UTF_8));
            HttpEntity httpEntity = MultipartEntityBuilder.create().
                                                addPart("filePath", fileBody).
                                                addPart("ocrType", ocrTypeBody).
                                                addPart("side", sideBody).
                                                build();*/
            HttpEntity httpEntity = new StringEntity(jsonObject.toString(), "UTF-8");
            // httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            // httpPost.setHeader("Cookie", "UM_distinctid=176a7569df02a1-0d23bf735f4f2d-16386153-1ea000-176a7569df19d8; CNZZDATA1278868486=1375510069-1609125240-%7C1611283284; JSESSIONID=EE48EE09B67DB499DA7D94BB97B42FCA");
            httpPost.setEntity(httpEntity);
            response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            // 获取响应对象
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                // 打印响应长度
                System.out.println("Response content length: " + resEntity.getContentLength());
                // 打印响应内容
                System.out.println(EntityUtils.toString(resEntity, "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 格式化参数，如果是from-data格式则将参数封装到MultipartEntity否则封装到StringEntity
     * @param param 参数
     * @param formData 是否使用form-data格式
     * @return
     * @throws UnsupportedEncodingException
     */
    /*private HttpEntity parseEntity(String param,boolean formData) throws UnsupportedEncodingException {
        if(formData){
            Map<String, String> paramMap = JSON.parseObject(param, HashMap.class);
            MultipartEntity multiEntity = new MultipartEntity();
            for (String key : paramMap.keySet()) {
                String value = paramMap.get(key);
                Matcher m = funPattern.matcher(value);
                if (m.matches() && m.group(1).equals("bodyfile")) {
                    value = m.group(2);
                    multiEntity.addPart(key, new FileBody(new File(value)));
                } else {
                    multiEntity.addPart(key, new StringBody(paramMap.get(key)));
                }
            }
            return multiEntity;
        }else{
            return new StringEntity(param, "UTF-8");
        }
    }*/
}
