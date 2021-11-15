package com.atguigu.gmall.user.controller;


import com.atguigu.gmall.user.bean.JsonResult;
import com.atguigu.gmall.user.bean.WareInfo;
import com.atguigu.gmall.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
public class AspectCtroller {
    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(AspectCtroller.class);

    @RequestMapping("/insertWareInfo")
    public JsonResult<WareInfo> insertWareInfo(){
        WareInfo wareInfo = new WareInfo();
        wareInfo.setId(12312);
        wareInfo.setAddress("高县乡2");
        wareInfo.setName("刘康为2");
        wareInfo.setAredCode("天天迟到2");
        userService.insertWareInfo(wareInfo);
        return new JsonResult<>();
    }


    @RequestMapping("/insertWareInfos")
    public JsonResult<WareInfo> insertWareInfos(){
        WareInfo wareInfo = new WareInfo();
        wareInfo.setId(12337);
        wareInfo.setAddress("太康县");
        wareInfo.setName("太康县刘康为");
        wareInfo.setAredCode("lkw天天迟到");
        userService.insertWareInfo(wareInfo);
        return new JsonResult<>();
    }

}
