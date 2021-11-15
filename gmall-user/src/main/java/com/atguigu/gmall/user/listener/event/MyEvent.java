package com.atguigu.gmall.user.listener.event;


import com.atguigu.gmall.user.bean.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/*
* 自定义事件
* 第一步 继承 ApplicationEvent，使其成为“事件“
* 重写 ApplicationEvent 方法，其实就是定义 MyEvent 构造器
* */

public class MyEvent extends ApplicationEvent {
    private User user;

    public MyEvent(Object source,User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
