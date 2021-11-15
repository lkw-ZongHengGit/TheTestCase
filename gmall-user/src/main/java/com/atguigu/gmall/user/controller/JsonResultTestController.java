package com.atguigu.gmall.user.controller;


import com.atguigu.gmall.user.bean.JsonResult;
import com.atguigu.gmall.user.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsontest")
public class JsonResultTestController {
/*
* 测试 json返回格式，并且这里也有验证 -切面 aspect
* */
    @RequestMapping("/getCase")
    public JsonResult<User> getCase(@RequestParam("name")String name){
        User user = new User(1,"刘康为","12232");
        return new JsonResult<>(user);
    }


}
