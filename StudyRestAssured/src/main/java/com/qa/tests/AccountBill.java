package com.qa.tests;

public class AccountBill {

    private String custAcctId;
    private String selectFlag;
    private int pageNum;

    public String getCustAcctId() {
        return custAcctId;
    }

    public void setCustAcctId(String custAcctId) {
        this.custAcctId = custAcctId;
    }

    public String getSelectFlag() {
        return selectFlag;
    }

    public void setSelectFlag(String selectFlag) {
        this.selectFlag = selectFlag;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
