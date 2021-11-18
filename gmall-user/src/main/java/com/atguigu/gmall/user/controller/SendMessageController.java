package com.atguigu.gmall.user.controller;

import jdk.nashorn.internal.ir.CallNode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


//rabbitmq测试类
@RestController
public class SendMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate; //rabbitmq的API
    // 1： 直连交换机
    @RequestMapping("/sendMessage")
    public String sendMessage(){
        //大致摸样44e1480e-d356-409a-acee-65347606782e
        UUID uuid = UUID.randomUUID();
        String massageId = String.valueOf(uuid);
        String messageData = "测试rabbitMq,你好嘛，色篮子！";
        //获取当前时间 -->  2021-11-17T23:51:18.461  格式不对
        LocalDateTime now = LocalDateTime.now();
        //获取当前事件并格式化 -->  2021-11-17 23:51:51
        String creatTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId",massageId);
        map.put("messageData", messageData);
        map.put("creatTime", creatTime);
        //将消息携带绑定键值：TestDirectRouting,发送到自定义交换机
       //三个属性，交换机，路径，以及我们的消息
        rabbitTemplate.convertAndSend("TestDirectExchange","testDirectRouting",map);
        return "OK";
    }

    //2：主题交换机
    @RequestMapping("/sendTopicMassage1")
    public String sendTopicMassage1(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange","topic.man",manMap);
        return "Ok";
    }

    @RequestMapping("/sendTopicMassage2")
    public String sendTopicMassage2(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: Woman is all";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange","topic.woman",manMap);
        return "Ok";
    }

    //三：扇形交换机

    @RequestMapping("/sendFanoutMessage")
    public String sendFanoutMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: testFanoutMessage ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("fanoutExange",null,manMap);
        return "ok";
    }
    //测试回调的情况，第一种情况，①消息推送到server，但是在server里找不到交换机
    @GetMapping("/TestMessageAck")
    public String TestMessageAck() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: non-existent-exchange test message ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("non-existent-exchange", "TestDirectRouting", map);
        return "ok";
    }

    // ②消息推送到server，找到交换机了，但是没找到队列
    @GetMapping("/TestMessageAck2")
    public String TestMessageAck2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: lonelyDirectExchange test message ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", map);
        return "ok";
    }
    }
