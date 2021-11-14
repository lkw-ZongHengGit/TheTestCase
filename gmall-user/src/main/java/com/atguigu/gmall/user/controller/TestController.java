package com.atguigu.gmall.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/TestDemo")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/simmpleDemo")
    public String simmpleDemo(){
        logger.debug("====测试日志debug级别打印====");
        logger.info("====测试日志info级别打印====");
        logger.error("====测试日志error级别打印====");
        logger.warn("====测试日志warn级别打印====");

        String str = "www.jiujiure.com";
        String str1 = "www.baidu.com";

        logger.info("======最好看的网站：{}；最博学的网站：{}",str,str1);

        return "你好，刘sir";
    }

}
