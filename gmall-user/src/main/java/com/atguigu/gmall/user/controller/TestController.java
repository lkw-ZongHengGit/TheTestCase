package com.atguigu.gmall.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/TestDemo")
public class TestController {

    @GetMapping("/simmpleDemo")
    public String simmpleDemo(){

        return "你好，刘sir";
    }

}
