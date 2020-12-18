package com.qa.tests;

public class querySubaccountBalance {

    String custAcctId;
    String selectFlag;
    int pageNum;

    public querySubaccountBalance () {
        super();
    }

    public querySubaccountBalance (String custAcctId, String selectFlag, int pageNum) {
        super();
        this.custAcctId = custAcctId;
        this.selectFlag = selectFlag;
        this.pageNum = pageNum;
    }

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
