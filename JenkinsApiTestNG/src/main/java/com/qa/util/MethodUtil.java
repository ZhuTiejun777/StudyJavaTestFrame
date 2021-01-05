package com.qa.util;

import com.qa.bean.ApiDataBean;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.qa.base.TestBase.getCommonParam;

public class MethodUtil {

    final static Logger Log = Logger.getLogger(MethodUtil.class);

    /**
     * 封装请求方法
     * @param url 请求路径
     * @param method 请求方法
     * @param param 请求参数
     * @return 请求方法
     * @throws UnsupportedEncodingException
     */
    public static HttpUriRequest parseHttpRequest(ApiDataBean apiDataBean,String url, String param) throws UnsupportedEncodingException {
        Header[] headers = parseHeader(apiDataBean.getHeader());
        String method = apiDataBean.getMethod();
        // TODO  log日志 先不看
        Log.info("method:" + method);
        Log.info("url:" + url);
        Log.info("param:" + param);
        //upload表示上传，也是使用post进行请求，equalsIgnoreCase忽略大小写判断
        if ("post".equalsIgnoreCase(method) || "upload".equalsIgnoreCase(method)) {
            // 封装post方法
            HttpPost postMethod = new HttpPost(url);
            postMethod.setHeaders(headers);
            //如果请求头的content-type的值包含form-data 或者 请求方法为upload(上传)时采用MultipartEntity形式
            // TODO from和upload格式数据
            // HttpEntity entity  = parseEntity(param,requestByFormData || "upload".equalsIgnoreCase(method));
            // HttpEntity entity  = parseEntity(param,false);
            HttpEntity entity = new StringEntity(param, "UTF-8");
            postMethod.setEntity(entity);
            return postMethod;
        } else if ("put".equalsIgnoreCase(method)) {
            // 封装put方法
            // TODO
            HttpPut putMethod = new HttpPut(url);
            putMethod.setHeaders(headers);
            // HttpEntity entity  = parseEntity(param,requestByFormData );
            HttpEntity entity  = new StringEntity(param, "UTF-8");
            putMethod.setEntity(entity);
            return putMethod;
        } else if ("delete".equalsIgnoreCase(method)) {
            // 封装delete方法
            // TODO
            HttpDelete deleteMethod = new HttpDelete(url);
            deleteMethod.setHeaders(headers);
            return deleteMethod;
        } else {
            // 封装get方法
            HttpGet getMethod = new HttpGet(url);
            getMethod.setHeaders(headers);
            return getMethod;
        }
    }

    /**
     * 格式化url,替换路径参数等。
     *
     * @param shortUrl
     * @return
     */
    public static String parseUrl(String shortUrl, String rootUrl) {
        // 替换url中的参数，判断xls中的url
        shortUrl = getCommonParam(shortUrl);
        boolean rooUrlEndWithSlash = rootUrl.endsWith("/");
        // 如果url以http开头，直接返回，判断xls中的url
        if (shortUrl.startsWith("http")) {
            return shortUrl;
        }
        // 配置项不以"/"结尾false，判读读取文件中的url是否以"/"开头(可能以http开头的全路径url)
        if (rooUrlEndWithSlash == shortUrl.startsWith("/")) {
            // 判断是否配置项以"/"结尾
            if (rooUrlEndWithSlash) {
                // 以"/"结尾，去掉xls中url第一个"/"
                shortUrl = shortUrl.replaceFirst("/", "");
            } else {
                // 加上"/"开头
                shortUrl = "/" + shortUrl;
            }
        }
        // 返回配置项中的url参数，拼接上xls中读取的url
        return rootUrl + shortUrl;
    }

    public static Header[] parseHeader (String header) {
        List<Header> headers = new ArrayList<Header>();
        // headers.add(new BasicHeader("Content-Type", contentType));
        if (!"".equals(header)) {
            for (String stringHeader : header.split(";")) {
                headers.add(new BasicHeader(stringHeader.split("\"")[1], stringHeader.split("\"")[3]));
            }
        }
        return headers.toArray(new Header[headers.size()]);
    }

    /**
     * 格式化参数，如果是from-data格式则将参数封装到MultipartEntity否则封装到StringEntity
     * @param param 参数
     * @param formData 是否使用form-data格式
     * @return
     * @throws UnsupportedEncodingException
     *//*
    private HttpEntity parseEntity(String param,boolean formData) throws UnsupportedEncodingException{
        // 判断请求方式
        // TODO
        if(formData){
            Map<String, String> paramMap = JSON.parseObject(param,
                    HashMap.class);
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
            // json格式直接返回，调用getCommonParam方法替换请求参数
            // param = getCommonParam(param);
            return new StringEntity(param, "UTF-8");
        }
    }*/
}
