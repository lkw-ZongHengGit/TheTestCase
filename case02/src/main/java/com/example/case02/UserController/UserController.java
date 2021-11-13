package com.example.case02.UserController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("test01")
    public String test01(){
        return "hello!";
    }

}
