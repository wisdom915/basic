package com.basic.util;

public class JsonUtil {
    private Integer result = 1;//默认成功
    private Boolean flag = true;//默认成功
    private Object object;
    private String message;//响应文本

    public JsonUtil(Integer result, Boolean flag, String message) {
        this.result = result;
        this.flag = flag;
        this.message = message;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static JsonUtil success(String message){
        return new JsonUtil(1,true,message);
    }
    public static JsonUtil error(String message){
        return new JsonUtil(0,false,message);
    }
}
