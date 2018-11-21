package com.huyun.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置
 */
@Configuration
public class RedisConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     *  实例化 RedisTemplate 对象
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> functionDomainRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 创建RedisTemplate 对象自动创建连接
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }


    /**
     * 设置数据存入 redis 的序列化方式
     *  redis 实现了序列化接口后就可以将对象以序列化的方式进行存取
     *  也可以将二进制的字符串反序列化转换为对象
     *  这样redis 就可以将对象以字符串的形式存取
     *  使用字符串序列化器
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.setHashValueSerializer(new RedisObjectSerializer());
        redisTemplate.setValueSerializer(new RedisObjectSerializer());
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * 使用redisCallback和sessionCallback 接口
     * 主要作用是让redis 进行回调可以在同一条连接下执行多个redis命令
     */
    public void useSessionCallback(RedisTemplate<String,Object> redisTemplate){
        redisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations ro) throws DataAccessException {
                ro.opsForValue().set("key1","huyunqiang");
                ro.opsForHash().put("hash","filed","hvalue");
                return null;
            }
        });
    }

    /**
     * 使用lambda 优化代码
     * @param redisTemplate
     */
//    public void useSessionCallback1(RedisTemplate<String,Object> redisTemplate){
//        redisTemplate.execute((RedisOperations os) -> {
//                ro.opsForValue().set("key1","huyunqiang");
//                ro.opsForHash().put("hash","filed","hvalue");
//                return null;
//        });
//    }


    /**
     * 实例化 HashOperations 对象,可以使用 Hash 类型操作
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * 实例化 ValueOperations 对象,可以使用 String 操作
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 实例化 ListOperations 对象,可以使用 List 操作
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 实例化 SetOperations 对象,可以使用 Set 操作
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 实例化 ZSetOperations 对象,可以使用 ZSet 操作
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }

    public static void main(String[] args){


    }
}
