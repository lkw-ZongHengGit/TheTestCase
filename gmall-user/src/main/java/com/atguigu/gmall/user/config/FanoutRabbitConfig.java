package com.atguigu.gmall.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    /*创建三个队列：fanout.A,fanout.B,fanout.C
    将三个队列都绑定交换机  fanoutExchange 上
    因为是扇形交换机，路由键无需配置，配置也不起作用* */
    //队列、交换机、然后绑定队列跟交换机
    @Bean
    public Queue queueA(){ return new Queue("fanout.A"); }
    @Bean
    public Queue queueB(){ return new Queue("fanout.B"); }
    @Bean
    public Queue queueC(){ return new Queue("fanout.C"); }
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExange"); }

    @Bean
    Binding bindingExchangeA(){
        return BindingBuilder.bind(queueA()).to(fanoutExchange()); }
    @Bean
    Binding bindingExangeB(){
        return BindingBuilder.bind(queueB()).to(fanoutExchange()); }
    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange()); }


}
