package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.JsonResult;
import com.atguigu.gmall.user.retention.AutoIdempotent;
import com.atguigu.gmall.user.service.TokenService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {


    @Autowired
    private TokenService tokenService;

    @GetMapping("/get/token")
    public JsonResult getToken() {
        String token = tokenService.createToken();
        return new JsonResult(token);
    }


    @AutoIdempotent
    @GetMapping("/test/Idempotence")
    public Object testIdempotence() {
        String token = "接口幂等性测试";
        return new JsonResult(token);
    }
}
