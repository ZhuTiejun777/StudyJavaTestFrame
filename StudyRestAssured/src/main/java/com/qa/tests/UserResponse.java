package com.qa.tests;

import java.util.HashMap;

public class UserResponse {

    private String msg;
    private HashMap<String, Object> payload;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(HashMap<String, Object> payload) {
        this.payload = payload;
    }

}
