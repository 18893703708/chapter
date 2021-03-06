package com.huyun.web.shiro;

import com.huyun.sys.model.User;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public class ShiroCache<K, V> implements Cache<K, V> {
    private static final String REDIS_SHIRO_CACHE = "fs-shiro-cache:";
    private String cacheKey;
    private RedisTemplate<K, V> redisTemplate;
    private long globExpire = 30;

    @SuppressWarnings("rawtypes")
    public ShiroCache(String name, RedisTemplate client) {
        this.cacheKey = REDIS_SHIRO_CACHE + name + ":";
        this.redisTemplate = client;
    }

    @Override
    public V get(K key) throws CacheException {
        SimplePrincipalCollection a=  (SimplePrincipalCollection) key;
        User u=(User) a.getPrimaryPrincipal();

        redisTemplate.boundValueOps(getCacheKey( u.getUserId())).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(u.getUserId())).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {

        SimplePrincipalCollection a=  (SimplePrincipalCollection) key;
        User u=(User) a.getPrimaryPrincipal();

        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(u.getUserId())).set(value);
        return old;
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        SimplePrincipalCollection a=  (SimplePrincipalCollection) key;
        User u=(User) a.getPrimaryPrincipal();
        redisTemplate.delete(getCacheKey(u.getUserId()));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    private K getCacheKey(Object k) {

        return (K) (this.cacheKey + k);
    }
}
