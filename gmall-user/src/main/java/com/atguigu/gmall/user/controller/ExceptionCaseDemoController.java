package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.JsonResult;
import com.atguigu.gmall.user.eunm.BusinessMsEnum;
import com.atguigu.gmall.user.exception.BusinessErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exception")
public class ExceptionCaseDemoController {

    private static final Logger logger =   LoggerFactory.getLogger(ExceptionCaseDemoController.class);

/*
* 参数缺失
* */
    @RequestMapping("/test")
    public JsonResult test(@RequestParam("name")String name,
                           @RequestParam("pass")String pass){
        logger.info("name:{}",name);
        logger.info("pass:{}",pass);
        return new JsonResult();
    }

    /*
    数组越界异常
    * */
    @RequestMapping("/testIndex")
    public JsonResult testIndex(@RequestParam("name")String name,
                           @RequestParam("pass")String pass){
        List<Map<String,String>> list = new ArrayList<>();
        Object o = list.get(0).get("测试");
        return new JsonResult();
    }

    /*
    * 空指针异常
    * */
    @RequestMapping("/testnull")
    public JsonResult testnull(@RequestParam("name")String name,
                               @RequestParam("pass")String pass){
        List<Map<String,String>> list = null;
        Map<String, String> stringStringMap = list.get(0);
        return new JsonResult();
    }

    /*
     * 除0异常，判断是否被捕获,经过测试，是可以的！而且不影响其他异常
     * */
    @RequestMapping("/testByZero")
    public JsonResult testByZero(@RequestParam("name")String name,
                               @RequestParam("pass")String pass){
        int i = 1;
        int c = i/0;
        return new JsonResult();
    }

/*
* 自定义异常*/
    @RequestMapping("/castoMize")
    public JsonResult castoMize(@RequestParam("name")String name,
                                 @RequestParam("pass")String pass){
        try {
            /*
            * 业务异常，因为我知道要获取的服务接口是干嘛的，那此时我就可以自定义异常，比如获取用户
            * 我就可以直接自定义一个用户失败异常，因为是我自定义，所以更有伸缩性
            * */
            int i = 1;
            int c = i / 0;
        }catch (Exception e){
            throw new BusinessErrorException(BusinessMsEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }



}
