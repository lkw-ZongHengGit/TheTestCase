package com.atguigu.gmall.user.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyServletRequestListener implements ServletRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(MyServletRequestListener.class);
    /*
    * 通过写这个监听器，我懂了之前一句话：一次请求就是一个servlet。如果是ApplicationListenert,那它在启动时就会进入自定义方法体
    * 但HttpSessionListener与ServletRequestListener都不会，HttpSessionListener监听器是在调用getSession()才会进方法体
    * ServletRequestListener 是在请求进来时才会进入监听器的方法体。
    * 大致流程：请求进来 ---- 进入 requestInitialized 方法 ---> 进入controller方法体  ---> 方法执行完毕，进入requestDestroyed（）销毁方法
    * */
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequestEvent.getServletRequest();
        logger.info("session id 为:{}", httpServletRequest.getRequestedSessionId());
        logger.info("request url 为：{}",httpServletRequest.getRequestURL());
        httpServletRequest.setAttribute("name","刘康为"); }
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.info("request end");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequestEvent.getServletRequest();
        logger.info("request 域中保存的name值为：{}",httpServletRequest.getAttribute("name"));
    }
}
