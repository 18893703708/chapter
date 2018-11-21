package com.huyun.web.modules.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * spring 中使用redis
 * redis 事务和数据库事务不一样的地方redis 不能保证原子性
 *
 */
@RequestMapping("/multi")
public class testMulti {
    @Autowired
    RedisTemplate redisTemplate;
    public Map<String,Object> TestMulti(){
        redisTemplate.opsForValue().set("key1","value1");
//        List list = (List)redisTemplate.execute((RedisOperations operations) -> {
//
//
//        });

        int a =1;
        int b = 2;
        return null;

    }
}
