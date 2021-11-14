package com.atguigu.gmall.user.exception;

import com.atguigu.gmall.user.eunm.BusinessMsEnum;

import java.util.logging.Logger;


/*
* 自定义异常
* */
public class BusinessErrorException extends RuntimeException {
    private static final long serialVersionUID=-878328926618011L;
    /*
    * 异常码
    * */
    private String code;
    private String msg;

    public BusinessErrorException(BusinessMsEnum businessMsEnum) {
        this.code = businessMsEnum.getCode();
        this.msg = businessMsEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
