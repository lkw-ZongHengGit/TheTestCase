package com.atguigu.gmall.user.eunm;

/*
* 自定义异常枚举类
* */
public enum BusinessMsEnum {
    /*参数异常*/
    PARMETER_EXCEPTION("102", "参数异常！"),
    SERVICE_TIME_OUT("103","调用服务超时！"),
    PARMTER_BIG_EXCEPTION("104","输入的图片数量不能超过50张"),
    UNEXPECTED_EXCEPTION("500","系统发生异常，请联系管理员"),
    NOLOGIN_EXCEPTION("501","用户未登录，请联系管理员");

    /*
    * 消息码以及消息内容
    * */
    private String code;
    private String msg;

    BusinessMsEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
