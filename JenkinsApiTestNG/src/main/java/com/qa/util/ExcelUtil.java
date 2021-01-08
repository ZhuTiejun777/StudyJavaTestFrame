package com.qa.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.bean.ApiDataBean;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelUtil {

    /**
     * 获取excel表所有sheet数据
     * @param path
     * @return
     */
    public static List<ApiDataBean> readExcel(String path) {
        System.out.println(path);
        if (null == path || "".equals(path)) {
            return null;
        }
        InputStream inputStream;
        Workbook workBook;
        // 获取到workbook实例
        try {
            inputStream = new FileInputStream(path);
            if (path.endsWith(".xls")) {
                workBook = new HSSFWorkbook(inputStream);
            } else {
                workBook = new XSSFWorkbook(inputStream);
            }
            inputStream.close();
            // 获取所有sheet数量
            int sheetNumber = workBook.getNumberOfSheets();
            List<ApiDataBean> allData = new ArrayList<ApiDataBean>();
            // 遍历所有sheet
            for (int i = 0; i < sheetNumber; i++) {
                // 返回数据bean列表
                if (workBook.getSheetName(i) == null) {
                    throw new RuntimeException("转换excel文件失败：");
                }
                allData.addAll(transToObject(workBook, workBook.getSheetName(i)));
            }
            return allData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("转换excel文件失败：" + e.getMessage());
        }
    }

    /**
     * 获取excel表指定sheet表数据
     * @param path
     * @param sheetName
     * @return
     */
    public static List<ApiDataBean> readExcel(String path, String sheetName) {
        if (null == path || "".equals(path)) {
            return null;
        }
        InputStream inputStream;
        Workbook workbook;
        try {
            inputStream = new FileInputStream(path);
            if (path.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else {
                workbook = new XSSFWorkbook(inputStream);
            }
            inputStream.close();
            return transToObject(workbook, sheetName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("转换excel文件失败：" + e.getMessage());
        }

    }

    /**
     * 读取Sheet中的数据
     * @param workbook
     * @param sheetName
     * @return
     */
    private static List<ApiDataBean> transToObject (Workbook workbook, String sheetName) throws IOException {
        //取出第一张表，遍历行
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<HashMap<String, String>>();
        Sheet sheet = workbook.getSheet(sheetName);
        Map<Integer, String> keymap = new HashMap<Integer, String>();
        Row row = null;
        //遍历行 getPhysicalNumberOfRows获取物理行 getFirstRowNum获取有数据的第一行行数
        for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
            try {
                row = sheet.getRow(i);
            } catch (Exception e) {
                e.getStackTrace();
            }
            // 当读取行为空时
            if (row == null) {
                continue;
            }
            HashMap<String, String> hashMap = new HashMap<String, String>();
            // 取出每一行的列数据
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                if (i == 0) {//表头栏
                    keymap.put(j, row.getCell(j).getStringCellValue());
                } else {//数据栏
                    //将每列的表头同每列的数据放入json
                    if (row.getCell(j) != null) {
                        Cell cell = row.getCell(j);
                        //row.getCell(j).setCell(CellType.STRING);
                        cell.setCellType(CellType.STRING);
                        hashMap.put(keymap.get(j), row.getCell(j).getStringCellValue());
                    } else {
                        hashMap.put(keymap.get(j), null);
                    }
                }
            }
            //将每行数据json放入json数组
            if (hashMap.size() > 0) {
                dataArray.add(hashMap);
            }
        }
        //判断dataArray是否有数据，有的话调用instantiationBean方法，将map转换为bean
        // ApiDataBean apiDataBean = new ApiDataBean();
        List<ApiDataBean> apiDataBeanList = new ArrayList<>();
        if (dataArray.size() > 0) {
            apiDataBeanList = instantiationBean(dataArray, sheetName);
            // apiDataBeanList = instantiationBean(dataArray);
        }
        return apiDataBeanList;
    }

    public static List<ApiDataBean> instantiationBean (List<HashMap<String, String>> list) throws JsonProcessingException {
        List<ApiDataBean> arrayList = new ArrayList<>();
        for (HashMap<String, String> hashMap : list) {
            /*JSONObject jsonObject = JSON.parseObject(String.valueOf(hashMap));
            ApiDataBean apiDataBean = JSON.parseObject(String.valueOf(hashMap), new TypeReference<ApiDataBean>() {});*/
            // 序列化 将map转换为json
            String string = new ObjectMapper().writeValueAsString(hashMap);
            ApiDataBean apiDataBean = new ObjectMapper().readValue(string, ApiDataBean.class);
            arrayList.add(apiDataBean);
        }
        return arrayList;
    }

    /**
     * 将列表数据转为bean
     *
     *
     */
    public static List<ApiDataBean> instantiationBean (List<HashMap<String, String>> list, String sheetName) {
        List<ApiDataBean> apiDataBeanArrayList = new ArrayList<ApiDataBean>();
        try {
            //本段处理将行上数据匹配到对应实体类中，可一条条数据逐个保存，也可将匹配不同实体类放入集合，统一保存，按实际需求选择
            if (list != null && !list.isEmpty()) {
                Map<String, String[]> keymap = new HashMap<String, String[]>();
                //遍历表格每一行信息 k表头  v行信息
                for (HashMap<String, String> hashMap : list) {
                    ApiDataBean apiDataBean = new ApiDataBean();
                    apiDataBean.setSheetName(sheetName);
                    //获得表头信息集合
                    Set<String> keySet = hashMap.keySet();
                    //遍历表头信息集合，与实体类字段匹配，自己跟据实际情况添加
                    for (String key : keySet) {
                        String value = hashMap.get(key);
                        switch (key){
                            case "run":{
                                apiDataBean.setRun(value.equals("Y"));
                            }
                            case "desc":{
                                apiDataBean.setDesc(value);
                                break;
                            }
                            case "url":{
                                apiDataBean.setUrl(value);
                                break;
                            }
                            case "header":{
                                apiDataBean.setHeader(value);
                                break;
                            }
                            case "method":{
                                apiDataBean.setMethod(String.valueOf(value));
                                break;
                            }
                            case "param":{
                                apiDataBean.setParam(value);
                                break;
                            }
                            case "status":{
                                apiDataBean.setStatus(parseIntStatus(value));
                                break;
                            }
                            case "contains":{
                                // TODO
                                apiDataBean.setContains(judgeContains(value));
                            }
                            case "verify":{
                                apiDataBean.setVerify(value);
                                break;
                            }
                            case "save":{
                                apiDataBean.setSave(value);
                                break;
                            }
                            case "preParam":{
                                apiDataBean.setPreParam(value);
                                break;
                            }
                            case "sleep":{
                                apiDataBean.setSleep(parseIntSleep(value));
                                break;
                            }
                        }
                    }
                    apiDataBeanArrayList.add(apiDataBean);
                }
            }
            // System.out.println(apiDataBeanArrayList.size());
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
        return apiDataBeanArrayList;
    }

    private static boolean judgeContains (String string) {
        // TODO
        return false;
    }

    private static int parseIntStatus (String string) {
        if (string == null || "".equals(string)) {
            return 0;
        } else {
            return Integer.parseInt(string);
        }
    }

    private static int parseIntSleep (String string) {
        if (string == null || "".equals(string)) {
            return 0;
        } else {
            return Integer.parseInt(string);
        }
    }

    // 将row数据读取存储到list
    /*private static List<Object> getRow(Row row) {
        List<Object> cells = new ArrayList<Object>();
        if (row != null) {
            for (short cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                Cell cell = row.getCell(cellNum);
                cells.add(getValue(cell));
                // cells.add(cell.getStringCellValue());
            }
        }
        return cells;
    }*/

    // TODO 不做转换
    // 判断字符串中类型并返回
    /*public static String getValue(Cell cell) {
        if (null == cell) {
            return "";
        } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(cell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(cell.getStringCellValue());
        }
    }*/

    /**
     * 获取sheet数据
     * @param clz
     * @param path
     * @param sheetName
     * @return ApiDataBean
     */
    /*private static <T> List<T> transToObject(Class<T> clz, Workbook workbook, String sheetName)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        List<T> list = new ArrayList<T>();
        Sheet sheet = workbook.getSheet(sheetName);
        // 获取第一张行数据，判断为空，直接返回空列表
        Row firstRow = sheet.getRow(0);
        if(null == firstRow){
            return list;
        }
        // 将表中第一行数据存入list，然后序列化bean
        List<Object> heads = getRow(firstRow);
        // 添加sheetName字段，用于封装至bean中，与bean中的字段相匹配。
        heads.add("sheetName");
        // TODO
        Map<String, Method> headMethod = getSetMethod(clz, heads);
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            try {
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }
                T t = clz.newInstance();
                List<Object> data = getRow(row);
                //如果发现表数据的列数小于表头的列数，则自动填充为null，最后一位不动，用于添加sheetName数据
                while(data.size()+1<heads.size()){
                    data.add("");
                }
                data.add(sheetName);
                setValue(t, data, heads, headMethod);
                list.add(t);
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }*/

    /*private static Map<String, Method> getSetMethod(Class<?> clz, List<Object> heads) {
        Map<String, Method> map = new HashMap<String, Method>();
        // 反射，通过类获取类的属性（成员，方法）
        Method[] methods = clz.getMethods();
        for (Object head : heads) {
            // boolean find = false;
            for (Method method : methods) {
                if (method.getName().toLowerCase().equals("set" + head.toString().toLowerCase())
                        && method.getParameterTypes().length == 1) {
                    map.put(head.toString(), method);
                    // find = true;
                    break;
                }
            }
            // if (!find) {
            // map.put(head, null);
            // }
        }
        return map;
    }*/

    /*private static void setValue(Object obj, List<Object> data, List<Object> heads, Map<String, Method> methods)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        for (Map.Entry<String, Method> entry : methods.entrySet()) {
            Object value = "";
            int dataIndex = heads.indexOf(entry.getKey());
            if (dataIndex < data.size()) {
                value = data.get(heads.indexOf(entry.getKey()));
            }
            Method method = entry.getValue();
            Class<?> param = method.getParameterTypes()[0];
            if (String.class.equals(param)) {
                method.invoke(obj, value);
            } else if (Integer.class.equals(param) || int.class.equals(param)) {
                if(value.toString()==""){
                    value=0;
                }
                method.invoke(obj, new BigDecimal(value.toString()).intValue());
            } else if (Long.class.equals(param) || long.class.equals(param)) {
                if(value.toString()==""){
                    value=0;
                }
                method.invoke(obj, new BigDecimal(value.toString()).longValue());
            } else if (Short.class.equals(param) || short.class.equals(param)) {
                if(value.toString()==""){
                    value=0;
                }
                method.invoke(obj, new BigDecimal(value.toString()).shortValue());
            } else if (Boolean.class.equals(param)
                    || boolean.class.equals(param)) {
                method.invoke(obj, Boolean.valueOf(value.toString())
                        || value.toString().toLowerCase().equals("y"));
            } else if (JSONObject.class.equals(param)
                    || JSONObject.class.equals(param)) {
                method.invoke(obj, JSONObject.parseObject(value.toString()));
            }else {
                // Date
                method.invoke(obj, value);
            }
        }
    }*/
}
