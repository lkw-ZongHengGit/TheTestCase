package com.atguigu.gmall.user.aspect;

import com.atguigu.gmall.user.bean.JsonResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Aspect
@Component
public class AopAspectHandler {
    private static final Logger logger = LoggerFactory.getLogger(AopAspectHandler.class);
    //定义一个切入点，指定类{aspectCtroller}去拦截
    @Pointcut("execution(* com.atguigu.gmall.user.controller..JsonResultTestController.getCase(..))")
    public void pointExemple(){//方法名自定义，注解则是@Pointcut
    }

    //定义切入点，在切入点上使用注解增加切入规则
    //可以做多个切面<自定义>，以项目的业务需求为准
    //场景：比如要在某个方法调用前进行过滤时，比如权限校验、或者登录次数统计
    @Before("pointExemple()")
    public void deBefore(JoinPoint joinPoint){
        logger.info("===doBefore方法进入===");
        //获取签名  Signature：签名
        Signature signature = joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        //获取即将执行的方法名
        String name = signature.getName();
        logger.info("即将执行方法为：{}，属于{}包",name,declaringTypeName);

        //在进行方法调用之前，记录一些信息，比如获取请求的url和Ip
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();//response
        String sessionId = requestAttributes.getSessionId();//sessionId
        Cookie[] cookies = request.getCookies();//cookies信息
        String url = request.getRequestURL().toString();//url信息
        String remoteAddr = request.getRemoteAddr();//获取请求Ip
        String headName = request.getHeaderNames().toString();//headName
        String method = request.getMethod();//看下什么方法
        logger.info("用户请求的url为：{}，ip地址为：{},method方法为：{}",url,remoteAddr,method);
        logger.info("打印== response：{}",response);
        logger.info("打印== sessionId：{}",sessionId);
        logger.info("打印== cookies：{}",cookies);
        logger.info("打印== headName：{}",headName);
        Object[] args = joinPoint.getArgs();
        String arg = (String)args[0];
        logger.info("打印== 请求参数：{}",args);
    }
        //方法体执行完毕
    @After("pointExemple()")
    public void doAfter(){
        logger.info("==doAfter方法进入了");
        logger.info("方法{}已经执行完====");

    }

    /**
     * 在上面定义的切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
     * @param joinPoint joinPoint
     * @param result result
     */
    @AfterReturning(pointcut = "pointExemple()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getName();
        JsonResult result1 =  (JsonResult)result;
        logger.info("方法{}执行完毕，返回参数为：{}", classMethod, result1.toString());
        // 实际项目中可以根据业务做具体的返回值增强
        logger.info("对返回参数进行业务上的增强：{}", result1.toString() + "增强版");
    }



}
