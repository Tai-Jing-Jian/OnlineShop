package com.example.shop_buyer_web.util;

public class ResponseResult {

    /**
     * 状态码
     */
    private int status;

    /**
     * 消息
     * */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public ResponseResult() {
    }

    /**
     * @param status 状态码
     * @param message 消息
     * @param data 返回数据
     * */
    public ResponseResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * @param status 状态码
     * @param message 消息
     * */
    public ResponseResult(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
