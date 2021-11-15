package com.atguigu.gmall.user.listener;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.service.UserService;
import com.atguigu.gmall.user.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.List;

/*
* 继承ApplicationListener，是自定义的类变成监听器。
* 重写onApplicationEvent方法，完成我们的业务需求
* */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //先获取application上下文
        ApplicationContext applicationContext = event.getApplicationContext();
        //获取对应的service
        UserService userService = applicationContext.getBean(UserService.class);
        //调用接口，获取数据
        List<UmsMember> httpCachs = userService.getHttpCachs();
        //将数据保存在ServletContext域对象中,严格意义上讲 ServletContext  在 ApplicationContext里面
        //ApplicationContext > ServletContext  ,ServletContext 可以存放Attribute域属性,而ApplicationContext则没有
        ServletContext application = applicationContext.getBean(ServletContext.class);//ServletContext是从Spring上下文中获取
        application.setAttribute("umsMemberList",httpCachs);
        /*
        * 上面是什么意思呢：
        * ContextRefreshedEvent事件，会在Spring容器初始化完成会触发该事件。
        * 一个最简单的方式就是，让我们的bean <MyServletContextListener>实现ApplicationListener接口，
        * 这样当发布事件时，[spring]的ioc容器初始化完成后，就会以容器的实例对象作为事件源类，
        * 并从中找到事件的监听者，此时ApplicationListener接口实例中的onApplicationEvent方法就会被调用
        * */

    }
}
