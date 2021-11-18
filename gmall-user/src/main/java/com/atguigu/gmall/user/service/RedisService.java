package com.atguigu.gmall.user.service;

import jdk.nashorn.internal.ir.CallNode;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    /*操作Stringle类型*/
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;
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

    /*
    * redis拓展
    * */

    //redis 写入缓存
    public boolean setSession(String key,String value){
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
    //写入缓存时间
    public boolean setSessionEX(final String key,Object value,long expireTime){
        boolean result = false;
        try{
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key,value);
            redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            result = true;
        }catch (Exception e){
           e.printStackTrace();
        }

        return result;
    }

    //读取缓存

    public Object getSession(String key){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    //删除对应的key
    public boolean remove(final String key){
        if(exists(key)){
            Boolean delete = redisTemplate.delete(key);
            return delete;
        }
        return false;
    }

    //校验key是否存在
    public boolean exists(final String key) {
        boolean result = false;
        ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
        if(Objects.nonNull(valueOperations.get(key))){//判断是否为null
            result = true;
        }
        return result;
    }

}
