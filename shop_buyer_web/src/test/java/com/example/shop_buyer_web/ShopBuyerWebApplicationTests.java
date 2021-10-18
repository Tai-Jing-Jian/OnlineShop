package com.example.shop_buyer_web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class ShopBuyerWebApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        redisTemplate.opsForValue().set("timeOutKey", "timeOut", 15, TimeUnit.SECONDS);
        String timeOutValue = redisTemplate.opsForValue().get("timeOutKey");
        System.out.println("通过set(K key, V value, long timeout, TimeUnit unit)方法设置过期时间， 过期之前获取的数据:"+timeOutValue);
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timeOutValue = redisTemplate.opsForValue().get("timeOutKey");
        System.out.print(",等待10s过后，获取的值:"+timeOutValue);
    }

}
