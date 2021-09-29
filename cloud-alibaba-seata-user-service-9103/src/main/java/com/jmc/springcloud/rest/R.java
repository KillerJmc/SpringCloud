package com.jmc.springcloud.rest;

import lombok.Data;

@Data
public class R {
    private Integer code;
    private String message;
    private Object data;

    private R() {}

    public static R ok() {
        R r = new R();
        r.setCode(ReturnCode.SUCCESS);
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode(ReturnCode.ERROR);
        return r;
    }

    public R msg(String message) {
        this.setMessage(message);
        return this;
    }

    public R data(Object data) {
        this.setData(data);
        return this;
    }
}
