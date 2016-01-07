package com.phenix.springrestful.entity;

/**
 * @author john
 * @version 1.0
 */
public class Resp {
    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;

    private int code;
    private String msg;

    public Resp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Resp success(String msg){
        return new Resp(SUCCESS,msg);
    }

    public static Resp failure(String msg){
        return new Resp(FAILURE,msg);
    }


}
