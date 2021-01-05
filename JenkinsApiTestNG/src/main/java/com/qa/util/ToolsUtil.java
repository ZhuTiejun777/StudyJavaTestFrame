package com.qa.util;

import com.alibaba.fastjson.JSONPath;
import com.qa.bean.ApiDataBean;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.qa.base.TestBase.*;

public class ToolsUtil {


    final static Logger Log = Logger.getLogger(ToolsUtil.class);

    /**
     * 替换符，如果数据中包含“${}”则会被替换成公共参数中存储的数据
     */
    private static final Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");

    /**
     * 断言响应结果
     *
     */
    public static void verifyResult(String sourchData, String verifyStr) {
        if (null == sourchData || "".equals(sourchData)) {
            return;
        }
        // 全局变量替换断言数据
        String allVerify = getCommonParam(verifyStr);
        // 通过';'分隔，通过jsonPath进行一一校验
        for (String stringVerify : allVerify.split(";")) {
            String actualValue = JSONPath.read(sourchData, stringVerify.split("=")[0]).toString();
            String exceptValue = stringVerify.split("=")[1].trim();
            Log.info("actualValue:" + actualValue);
            Log.info("exceptValue:" + exceptValue);
            Assert.assertEquals(actualValue, exceptValue);
        }
    }

    /**
     * 参数处理
     *
     */
    public static String buildRequestParam(ApiDataBean apiDataBean) {
        // 分析处理预参数 （函数生成的参数）
        // TODO PreParam参数保存来自那里，优化去掉这个方法
        // String preParam = buildParam(apiDataBean.getPreParam());
        String preParam = apiDataBean.getPreParam();
        if (!"".equals(preParam)) {
            preParam = getCommonParam(preParam);
            savePreParam(preParam);// 保存预存参数 用于后面接口参数中使用和接口返回验证中
        }
        // 处理参数
        // String apiParam = buildParam(apiDataBean.getParam());
        // return apiParam;
        // return buildParam(apiDataBean.getParam());
        String apiParam = apiDataBean.getParam();
        apiParam = getCommonParam(apiParam);
        return apiParam;
    }

    /**
     * 将preParam中的参数加入公共池
     * @param preParam 公共数据的key
     */
    public static void savePreParam(String preParam) {
        // 通过';'分隔，将参数加入公共参数map中
        // TODO 更改成不调用方法
        if (null == preParam || "".equals(preParam)) {
            return;
        }
        String[] preParamArr = preParam.split(";");
        String key, value;
        for (String prepar : preParamArr) {
            if (null == prepar || "".equals(prepar)) {
                continue;
            }
            key = prepar.split("=")[0];
            value = prepar.split("=")[1];
            //ReportUtil.log(String.format("存储%s参数，值为：%s。", key, value));
            setSaveDatas(key, value);
        }
    }

    /**
     * 提取json串中的值保存至公共池中
     * @param json 将被提取的json串。
     * @param allSave
     *            所有将被保存的数据：xx=$.jsonpath.xx;oo=$.jsonpath.oo，将$.jsonpath.
     *            xx提取出来的值存放至公共池的xx中，将$.jsonpath.oo提取出来的值存放至公共池的oo中
     */
    public static void saveResult(String json, String allSave) {
        if (null == json || "".equals(json) || null == allSave || "".equals(allSave)) {
            return;
        }
        allSave = getCommonParam(allSave);
        String[] saves = allSave.split(";");
        String key, value;
        for (String save : saves) {
            key = save.split("=")[0].trim();
            value = JSONPath.read(json, save.split("=")[1].trim()).toString();
            Log.info(String.format("存储公共参数   %s值为：%s.", key, value));
            setSaveDatas(key, value);
            /*Pattern pattern = Pattern.compile("([^;=]*)=([^;]*)");
            Matcher m = pattern.matcher(save.trim());
            while (m.find()) {
                key = getBuildValue(json, m.group(1));
                value = getBuildValue(json, m.group(2));

                // ReportUtil.log(String.format("存储公共参数   %s值为：%s.", key, value));
                saveDatas.put(key, value);
            }*/
        }
    }

    /**
     * 取公共参数 并替换参数
     * url header
     * @param param 需要替换的参数
     * @return param
     */
    public static String getCommonParam(String param) {
        if (null == param || "".equals(param)) {
            return "";
        }
        Matcher matcher = replaceParamPattern.matcher(param);// 取公共参数正则
        while (matcher.find()) {
            // 返回第一个()中的内容
            String replaceKey = matcher.group(1);
            String value;
            // 从公共参数池中获取值
            value = getSaveDatas(replaceKey);
            // 如果公共参数池中未能找到对应的值，该用例失败。
            Assert.assertNotNull(value,
                    String.format("格式化参数失败，公共参数中找不到%s。", replaceKey));
            param = param.replace(matcher.group(), value);
        }
        return param;
    }

    /**
     * 获取格式化后的值
     *
     * @param sourchJson
     * @param key
     * @return
     */
    /*private String getBuildValue(String sourchJson, String key) {
        key = key.trim();
        Matcher funMatch = funPattern.matcher(key);
        if (key.startsWith("$.")) {// jsonpath
            key = JSONPath.read(sourchJson, key).toString();
        } else if (funMatch.find()) {
            // String args;
            // if (funMatch.group(2).startsWith("$.")) {
            // args = JSONPath.read(sourchJson, funMatch.group(2)).toString();
            // } else {
            // args = funMatch.group(2);
            // }
            String args = funMatch.group(2);
            String[] argArr = args.split(",");
            for (int index = 0; index < argArr.length; index++) {
                String arg = argArr[index];
                if (arg.startsWith("$.")) {
                    argArr[index] = JSONPath.read(sourchJson, arg).toString();
                }
            }
            String value = FunctionUtil.getValue(funMatch.group(1), argArr);
            key = StringUtil.replaceFirst(key, funMatch.group(), value);

        }
        return key;
    }*/
}
