package com.qa.base;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONPath;
import com.qa.bean.ApiDataBean;
import com.qa.util.*;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.testng.Assert;

public class TestBase {

    // public Properties prop;
    protected String host;
    protected String url;
    protected String excelPath;
    protected String sheetName;
    protected String contentType;
    protected String cookie;

    final Logger Log = Logger.getLogger(TestBase.class);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    /**
     * 公共参数数据池（全局可用）
     */
    protected static final Map<String, String> saveDatas = new HashMap<String, String>();

    /**
     * 替换符，如果数据中包含“${}”则会被替换成公共参数中存储的数据
     */
    protected static Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");

    /**
     * 截取自定义方法正则表达式：__xxx(ooo)
     */
    // protected Pattern funPattern = Pattern.compile("__(\\w*?)\\((([\\w\\\\\\/:\\.\\$]*,?)*)\\)");// __(\\w*?)\\((((\\w*)|(\\w*,))*)\\)
    // __(\\w*?)\\(((\\w*,?\\w*)*)\\)

    //写一个构造函数
    public TestBase() {

        /*Logger logger = Logger.getLogger(TestBase.class);
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
            Log.info("正在读取配置文件...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.error("配置文件没有找到");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        url = resourceBundle.getString("HOST");
        host = resourceBundle.getString("HOST");
        excelPath = resourceBundle.getString("ExcelPath");
        sheetName = resourceBundle.getString("SheetName");
        contentType = resourceBundle.getString("ContentType");
        cookie = resourceBundle.getString("COOKIE");
        /*String className = this.getClass().getName();
        logger = Logger.getLogger(className);
        // PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);*/
    }

    /**
     * 根据配置读取测试用例
     * @param excelPathArr
     *            本次需要过滤的excel文件名
     * @param sheetNameArr
     *            本次需要过滤的sheet名
     * @return 返回数据
     */
    protected List<ApiDataBean> readExcelData(String[] excelPathArr, String[] sheetNameArr) {
        List<ApiDataBean> allExcelData = new ArrayList<ApiDataBean>();// excel文件數組
        List<ApiDataBean> temArrayList = new ArrayList<ApiDataBean>();
        // 遍历excel文件数组
        for (String excelPath : excelPathArr) {
            // 获取文件路径
            File file = Paths.get(System.getProperty("user.dir"), excelPath).toFile();
            //temArrayList.clear();
            if (sheetNameArr.length == 0 || "".equals(sheetNameArr[0])) {
                // 如果没有去读到sheet值
                temArrayList = ExcelUtil.readExcel(file.getAbsolutePath());
            } else {
                for (String sheetName : sheetNameArr) {
                    temArrayList.addAll(ExcelUtil.readExcel(file.getAbsolutePath(), sheetName));
                }
            }
            // 遍历列表中的实例类，并添加变量ExcelName属性
            temArrayList.forEach((bean) -> {
                bean.setExcelName(file.getName());
            });
            allExcelData.addAll(temArrayList); // 将excel数据添加至list
        }
        return allExcelData;
    }

    /**
     * 获取公共数据池中的数据
     * @param key 公共数据的key
     * @return 对应的value
     */
    private static String getSaveData(String key) {
        if ("".equals(key) || !saveDatas.containsKey(key)) {
            return null;
        } else {
            return saveDatas.get(key);
        }
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
            saveDatas.put(key, value);
        }
    }

    /**
     * 提取json串中的值保存至公共池中
     * @param json 将被提取的json串。
     * @param allSave
     *            所有将被保存的数据：xx=$.jsonpath.xx;oo=$.jsonpath.oo，将$.jsonpath.
     *            xx提取出来的值存放至公共池的xx中，将$.jsonpath.oo提取出来的值存放至公共池的oo中
     */
    protected void saveResult(String json, String allSave) {
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
            saveDatas.put(key, value);
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
            value = getSaveData(replaceKey);
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
