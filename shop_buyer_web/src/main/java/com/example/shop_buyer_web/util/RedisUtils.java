package com.example.shop_buyer_web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Author：汤小洋
 * Date：2018-07-25 9:48
 * Description：Redis工具类
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 当数据库中不存在key时，增加一个键值对key-value，并设置一个失效时间time（单位为秒）
     * @param key 键，类型：String
     * @param value 值，类型：String
     * @param time 失效时间，单位：秒
     * @return true:添加成功；false:添加失败
     */
    public Boolean setnx(String key, String value, long time) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 返回给定key的剩余过期时间，以秒为单位
     * @param key 键，类型：String
     */
    public long ttl(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 根据key删除数据
     * @param key 键，类型：String
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }
}