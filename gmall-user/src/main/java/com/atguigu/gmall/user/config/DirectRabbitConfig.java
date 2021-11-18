package com.atguigu.gmall.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
* 配置rabbitmq
* 配置类装配了一些bean,交由springboot框架代理
* 实则上：配置了交换机、队列以及路由
* 然后我们在controller层将消息发送出去，就
* */
@Configuration
public class DirectRabbitConfig {

    //队列，给队列起名,@bean是配置这些类，不能忽略这个注解
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue", true);
    }
    //直连型交换机
    //direct交换机,给交换器起名TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange", true, false);//名字自定义
    }
    //绑定交换机跟队列，并设置用于匹配的键
    @Bean
    Binding bingingDirect(){
        //帮i的那个队列 到 交换机  并  设置路由
        //名字自定义
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("testDirectRouting");
    }
    @Bean
    DirectExchange lonelyDirectExchange(){
        return new DirectExchange("lonelyDirectExchange");
    }

}
