package com.atguigu.gmall.user.interceptor;

import com.atguigu.gmall.user.eunm.BusinessMsEnum;
import com.atguigu.gmall.user.exception.BusinessErrorException;
import com.atguigu.gmall.user.retention.AutoIdempotent;
import com.atguigu.gmall.user.retention.UnInterception;
import com.atguigu.gmall.user.service.RedisService;
import com.atguigu.gmall.user.service.TokenService;
import com.atguigu.gmall.user.service.impl.TokenServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/*
* 1：编写自定义拦截类，首先继承拦截器处理器
* 2：编写完成之后，然后config包去配置 自定义拦截类
* */
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    TokenServiceImpl tokenService;
    @Autowired
    RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    //执行我们的方法执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      if(handler instanceof HandlerMethod) {
          HandlerMethod handlerMethod = (HandlerMethod) handler;
          Method method = handlerMethod.getMethod();
          String methodName = method.getName();
          logger.info("=====拦截到了方法：{}，在该方法执行之前执行====", methodName);
          //返回true才会继续执行，返回false则取消当前请求
          //判断用户有没有登录,一般登录之后的用户都有一个对应的token
          String token = request.getParameter("token");
//          判断是否有 自定义注解,如果有,则放行
//          UnInterception annotation = method.getAnnotation(UnInterception.class);
//          if ((token == null || "".equals(token)) && annotation == null) {
//              logger.info("用户未登录,没有权限执行...请登录");
//              //用户未登录,抛出自定义异常
//              throw new BusinessErrorException(BusinessMsEnum.NOLOGIN_EXCEPTION);
//          }

          /*
          * 上边是springboot笔记里的写法，下面是redis拓展写法
          * */
          AutoIdempotent annotation = method.getAnnotation(AutoIdempotent.class);

          if(annotation!=null){
              try {

                  return tokenService.checkToken(request);
              }catch (Exception e){
                  throw new RuntimeException(e.getMessage());
              }
          }

      }

        //返回true才会继续执行,false的话 则取消当前请求
        return true;
    }
    //执行方法完，但在视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("执行完方法之后进，但此时还没有进行视图渲染");
    }
    //执行方法完，试图渲染完
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图");
    }
}
