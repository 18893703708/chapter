package com.huyun.web.modules.redis;

import com.huyun.users.model.Users;
import com.huyun.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * redis结合spring的缓存注解
 * // 主键回填 在插入的时候将数据放在缓存中
 * @CachePut(value = "redisCache",key = "'redis_user_'+result+id")
 * // 先在缓存中查数据 缓存中为null 在执行select 方法
 * @Cacheable(value = "redisCache",key = "'redis_user_'+id")
 *  //清空缓存  更新数据不应该在缓存中读取数据
 * @CacheEvict(value = "redisCache",key = "'redis_user_'+result+id")
 */
public class SpringCacheRedis {
    @Autowired
    UsersService usersService;
    public Users insert(Users users){
         usersService.insert(users);
         return users;
    }
}
