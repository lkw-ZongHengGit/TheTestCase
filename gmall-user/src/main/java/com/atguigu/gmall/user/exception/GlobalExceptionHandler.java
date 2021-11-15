package com.atguigu.gmall.user.exception;


import com.atguigu.gmall.user.bean.JsonResult;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /*
     *缺少参数异常*
     * */
    //@ExceptionHandler({MissingServletRequestPartException.class})
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handlerHttpMassageNoReadableExcepthon(MissingServletRequestParameterException ex) {
        logger.error("缺少请求参数，{}", ex.getMessage());
        return new JsonResult("400", "缺少必要的请求参数");
    }
    /*
    * 空指针异常
    * */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleTypeMismatchException(NullPointerException ex){
        logger.error("空指针异常：",ex.getMessage());
        return new JsonResult("500","空指针异常了");
    }

    /*
    * 数组越界异常捕获
    * */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handleIndexOutOfBoundsException(IndexOutOfBoundsException ex){
        logger.error("数组越界异常：{}",ex.getMessage());
        return new JsonResult("501","数组越界异常");
    }

    /*
    * 拦截自定义业务异常，返回业务异常信息
    * */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handleBusiError(BusinessErrorException ex){
        String code = ex.getCode();
        String msg = ex.getMsg();
        return new JsonResult(code, msg);
    }



    /*
     * 测试异常父类
     * */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handleExcption(Exception ex){
        logger.error("异常：{}",ex.getMessage());
        return new JsonResult("502","出现了统一异常");
    }



}
