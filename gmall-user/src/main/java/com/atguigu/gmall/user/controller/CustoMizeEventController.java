package com.atguigu.gmall.user.controller;


/*
* 访问我们发布自定义事件的接口，触发监听器，然后去执行监听器的逻辑
* */

import com.atguigu.gmall.user.service.UserEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customize")
public class CustoMizeEventController {
    private static final Logger logger = LoggerFactory.getLogger(CustoMizeEventController.class);
    @Resource
    UserEventService userEventService;

    @RequestMapping("/custoEvent")
    public String custoEvent(){
        userEventService.getUser2();
        return "success";
    }

}
