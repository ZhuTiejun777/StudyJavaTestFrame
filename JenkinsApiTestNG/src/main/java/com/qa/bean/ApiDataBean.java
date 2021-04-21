package com.qa.bean;


public class ApiDataBean {
    private boolean run;
    private String desc; // 接口描述
    private String url;
    private String header;
    private String method;
    private String param;  // 请求参数
    private int status;
    private boolean contains; // 包含数据
    private String verify; // 断言验证
    private String save; // 响应数据加入公共池
    private String preParam; // 请求数据加入公共池
    private int sleep;  // 休眠时间
    private String excelName;
    private String sheetName;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }
    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isContains() {
        return contains;
    }

    public void setContains(boolean contains) {
        this.contains = contains;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getPreParam() {
        return preParam;
    }

    public void setPreParam(String preParam) {
        this.preParam = preParam;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("desc:%s,method:%s,url:%s,param:%s", this.desc,
                this.method, this.url, this.param);
    }

}

