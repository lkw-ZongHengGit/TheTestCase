package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.WareInfo;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String getUser() {
        return userMapper.getUser();
    }

    /*
    * 测试 通用-mybatis 的 类
    * */
    @Override
    public List<UmsMember> getAllUser() {
        return userMapper.selectAll();
        //return null;//userMapper.selectAllUser();
    }
    /*
    * 测试事务的类
    * */
    @Override
    @Transactional
    public Integer insertWareInfo(WareInfo wareInfo) {
        userMapper.insertWareInfo(wareInfo);
        int i = 1;
        int c = i/0;
        return Integer.valueOf("1");
    }
    /*
    *测试 监听器的缓存，原理：将用户的信息缓存在 application上下文里
    * 首先，将从数据库获取的信息并返回
    * */

    public List<UmsMember> getHttpCachs(){
        return userMapper.selectAll() ;
    }



}
