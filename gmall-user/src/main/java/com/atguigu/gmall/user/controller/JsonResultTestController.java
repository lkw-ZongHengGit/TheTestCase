package com.atguigu.gmall.user.controller;


import com.atguigu.gmall.user.bean.JsonResult;
import com.atguigu.gmall.user.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsontest")
public class JsonResultTestController {

    @RequestMapping("/user")
    public JsonResult<User> getUser(){
        User user = new User(1,"刘康为","12232");
        return new JsonResult<>(user);

    }


}
