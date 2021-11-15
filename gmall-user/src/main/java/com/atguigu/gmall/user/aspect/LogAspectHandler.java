package com.atguigu.gmall.user.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
* 首先定义一个切面类
* */
@Aspect
@Component
public class LogAspectHandler {
    private static final Logger logger = LoggerFactory.getLogger(LogAspectHandler.class);
    //定义一个切入点,拦截 aop目录下所有的方法
    @Pointcut("execution(* com.atguigu.gmall.user.aop..*.*(..))")
    public void pointCut(){
        //方法体不生效
    }

    //定义一个切入点，指定类{aspectCtroller}去拦截
    @Pointcut("execution(* com.atguigu.gmall.user.controller..AspectCtroller.*(..))")
    public void pointExemple(){
        logger.info("====某个类的切入点准备测试====");
        logger.info("====某个类的切入点测试中====");
        logger.info("====某个类的切入点测试完成====");
        logger.warn("====某个类的切入点准备测试====");
        logger.warn("====某个类的切入点测试中====");
        logger.warn("====某个类的切入点测试完成====");
    }

    //定义一个切入点，指定类{JsonResultTestController 中的 case方法}去拦截
    @Pointcut("execution(* com.atguigu.gmall.user.controller..JsonResultTestController.case(..))")
    public void pointTo(){
        logger.info("====某个类的某个方法点准备测试====");
        logger.info("====某个类的某个方法点测试中====");
        logger.info("====某个类的某个方法点测试完成====");
        logger.error("====某个类的某个方法点准备测试====");
        logger.error("====某个类的某个方法点测试中====");
        logger.error("====某个类的某个方法点测试完成====");
    }

    //定义切入点，在切入点上使用注解增加切入规则
    @Before("pointCut()")
    public void deBefore(JoinPoint joinPoint){
        logger.info("===doBefore方法进入===");
        //获取签名  Signature：签名
        Signature signature = joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        //获取即将执行的方法名
        String name = signature.getName();
        logger.info("即将执行方法为：{}，属于{}包",name,declaringTypeName);

    }




}
