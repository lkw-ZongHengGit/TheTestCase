package com.atguigu.gmall.user.aop;

import com.atguigu.gmall.user.bean.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {
    private static final Logger logger = LoggerFactory.getLogger(AopController.class);

    @RequestMapping("/aopTest")
    public JsonResult aopTest(@RequestParam("name")String name){
        logger.info("======测试======");
        logger.info("======测试======");
        logger.info("======测试======");
        return new JsonResult();
    }


}
