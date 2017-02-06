package com.itliusir.micro.model;

/**
 * Created by ysstech on 2017/1/24.
 */
public class ResponseInfo {
    private Integer status;

    private Object content;

    private String message;

    public ResponseInfo(){

    }

    public ResponseInfo(Integer status, Object content, String message) {
        this.status = status;
        this.content = content;
        this.message = message;
    }
    public ResponseInfo(Integer status, Object content) {
        this.status = status;
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
