package com.atguigu.gmall.user.listener;


import com.atguigu.gmall.user.bean.User;
import com.atguigu.gmall.user.listener.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/*
* 1 自定义监听器，继承ApplicationListener，放入自定义事件
* */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        //把时间中的信息获取到
        User user = event.getUser();
        //处理事件
        System.out.println("用户名："+user.getName());
        System.out.println("用户Id："+user.getId());
        //如果是 ApplicationListener<ContextRefreshedEvent> 这个监听器
        //那么泛型里的事件，其实在启动springboot时就会触发，然后被监听器监听。

        //然后我们就可以去做我们想要的逻辑，比如通知微服务 B 去处理另一个逻辑
        // 或者微服务 A 处理完某个逻辑之后，需要将数据同步到微服务 B，这种场景非常普遍

        //---  而自定义事件需要手动去发布

    }
}
