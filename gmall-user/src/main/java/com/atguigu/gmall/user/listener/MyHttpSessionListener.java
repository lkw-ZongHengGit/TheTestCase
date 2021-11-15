package com.atguigu.gmall.user.listener;


import org.apache.catalina.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
* 使用httpSessionListener统计在线用户数量
* */
@Component
public class MyHttpSessionListener implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);
    public Integer count =0;
    /*
    第一步继承HttpSessionListener，变成监听器，
    然后重写sessionCreated与sessionDestroyed方法
    * */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("=====新用户上线了====");
        count++;
        httpSessionEvent.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("=====用户下线了====");
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count",count);

    }
}
