package com.atguigu.gmall.user.service;

import jdk.nashorn.internal.ir.CallNode;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RedisService {
    /*操作Stringle类型*/
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    // 使用 opsForValue 获取 之后就可以 set 键与值
    public void setString(String key,String value){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key,value);
    }
    /*操作Stringle类型*/
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    /*操作Hash类型,使用put塞入值*/
    public void setHash(String key,String filedkey,String value){
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        stringObjectObjectHashOperations.put(key,filedkey,value);
    }
    //操作Hash类型，使用get获取值
    public String getHash(String key,String filedkey){
        return (String)stringRedisTemplate.opsForHash().get(key,filedkey);
    }
    /*操作list类型，使用leftPush塞入值*/
    public void setList(String key, String value){
        stringRedisTemplate.opsForList().leftPush(key,value);
    }
    /*操作list类型，使用range获取值*/
    public List<String> getList(String key,long start,long end){
        return stringRedisTemplate.opsForList().range(key,start,end);
    }

}
