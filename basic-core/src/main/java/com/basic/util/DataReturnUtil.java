package com.basic.util;

import java.util.List;

public class DataReturnUtil {
    private Integer code = 0;
    private String msg = "";
    private Long count;
    private List<?> data;

    public DataReturnUtil() {
    }

    public DataReturnUtil(Long count, List<?> data) {
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
