package com.atguigu.gmall.user.service;

import com.atguigu.gmall.user.bean.User;
import com.atguigu.gmall.user.listener.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEventService {
    @Resource
    private ApplicationContext applicationContext;
    /*
    * 发布事件
    * */
    public User getUser2(){
        User user = new User(27,"Liuk","789");
        //这里我们讲user的内容放入自定义事件中，做业务时，如果需要把某些更改的信息通知别的服务，那么可以：
        // 1:先将信息 写成自定义事件的属性
        //2:这些信息经过组装、分装，然后就发布
        MyEvent event = new MyEvent(this,user);
        //下面发布事件
        applicationContext.publishEvent(event);
        return user;
    }

}
