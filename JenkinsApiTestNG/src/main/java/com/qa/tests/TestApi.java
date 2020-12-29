package com.qa.tests;

import com.alibaba.fastjson.JSON;
import com.qa.base.TestBase;
import com.qa.util.ReportUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;


public class TestApi extends TestBase {

    /**
     * api请求跟路径
     */
    private static String rootUrl;

    /**
     * 所有公共header，会在发送请求的时候添加到http header上
     */
    private static Header[] publicHeaders;

    /**
     * 是否使用form-data传参 会在post与put方法封装请求参数用到
     */
    private static boolean requestByFormData = false;

    /**
     * 跟路径是否以‘/’结尾
     */
    private static boolean rooUrlEndWithSlash = false;


    // TODO

    /**
     * 封装请求方法
     *
     * @param url
     *            请求路径
     * @param method
     *            请求方法
     * @param param
     *            请求参数
     * @return 请求方法
     * @throws UnsupportedEncodingException
     */
    private HttpUriRequest parseHttpRequest(String url, String method, String param) throws UnsupportedEncodingException {
        // 处理url
        url = parseUrl(url);
        // TODO
        ReportUtil.log("method:" + method);
        ReportUtil.log("url:" + url);
        ReportUtil.log("param:" + param.replace("\r\n", "").replace("\n", ""));
        //upload表示上传，也是使用post进行请求
        if ("post".equalsIgnoreCase(method) || "upload".equalsIgnoreCase(method)) {
            // 封装post方法
            HttpPost postMethod = new HttpPost(url);
            postMethod.setHeaders(publicHeaders);
            //如果请求头的content-type的值包含form-data 或者 请求方法为upload(上传)时采用MultipartEntity形式
            HttpEntity entity  = parseEntity(param,requestByFormData || "upload".equalsIgnoreCase(method));
            postMethod.setEntity(entity);
            return postMethod;
        } else if ("put".equalsIgnoreCase(method)) {
            // 封装put方法
            HttpPut putMethod = new HttpPut(url);
            putMethod.setHeaders(publicHeaders);
            HttpEntity entity  = parseEntity(param,requestByFormData );
            putMethod.setEntity(entity);
            return putMethod;
        } else if ("delete".equalsIgnoreCase(method)) {
            // 封装delete方法
            HttpDelete deleteMethod = new HttpDelete(url);
            deleteMethod.setHeaders(publicHeaders);
            return deleteMethod;
        } else {
            // 封装get方法
            HttpGet getMethod = new HttpGet(url);
            getMethod.setHeaders(publicHeaders);
            return getMethod;
        }
    }

    /**
     * 格式化参数，如果是from-data格式则将参数封装到MultipartEntity否则封装到StringEntity
     * @param param 参数
     * @param formData 是否使用form-data格式
     * @return
     * @throws UnsupportedEncodingException
     */
    private HttpEntity parseEntity(String param,boolean formData) throws UnsupportedEncodingException{
        if(formData){
            Map<String, String> paramMap = JSON.parseObject(param,
                    HashMap.class);
            // TODO
            MultipartEntity multiEntity = new MultipartEntity();
            for (String key : paramMap.keySet()) {
                String value = paramMap.get(key);
                // TODO
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
    }

    /**
     * 格式化url,替换路径参数等。
     *
     * @param shortUrl
     * @return
     */
    private String parseUrl(String shortUrl) {
        // 替换url中的参数
        shortUrl = getCommonParam(shortUrl);
        if (shortUrl.startsWith("http")) {
            return shortUrl;
        }
        if (rooUrlEndWithSlash == shortUrl.startsWith("/")) {
            if (rooUrlEndWithSlash) {
                shortUrl = shortUrl.replaceFirst("/", "");
            } else {
                shortUrl = "/" + shortUrl;
            }
        }
        return rootUrl + shortUrl;
    }


}
