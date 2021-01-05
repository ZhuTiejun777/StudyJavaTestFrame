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
    private static final Map<String, String> saveDatas = new HashMap<String, String>();

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
    public static String getSaveDatas (String key) {
        if (key == null || !saveDatas.containsKey(key)) {
            return null;
        } else {
            return saveDatas.get(key);
        }
    }

    public static void setSaveDatas (String key, String value) {
        if (key != null && !"".equals(key)) {
            saveDatas.put(key, value);
        } else {
            System.out.println("保存全局变量失败,key为空");
        }
    }
}
