package com.mx.minnong.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 10:26  2018/11/21
 * @Description:
 */
@Component
public class RedisUtil<T>{

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 10:30 2018/11/21
     * @param: key
     * @return: boolean
     * @Description: 是否存在键
     */
    public boolean existsKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     *
     * @param key
     */
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 设置key的生命周期
     *
     * @param key
     * @param time
     * @param timeUnit
     */
    public void pireKey(String key, long time, TimeUnit timeUnit) {
        redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 指定key在指定的日期过期
     *
     * @param key
     * @param date
     */
    public void expireKeyAt(String key, Date date) {
        redisTemplate.expireAt(key, date);
    }

    /**
     * 存集合 list
     *
     * @param key
     * @param val
     */
    public void rightPushAll(String key, List val) {
        redisTemplate.opsForList().rightPushAll(key, val);
    }

    /**
     * 存 String
     *
     * @param key
     * @param val
     */
    public void setString(String key, String val) {
        redisTemplate.opsForValue().set(key,val);
    }

    /**
     * 取 String
     *
     * @param key
     */
    public Object getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    /**
     *
     * 取集合 list
     *
     * @param key
     */
    public List<Object> range(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 取hash
     *
     * @param key
     */
    public Map<Object, Object> entries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 取hash
     *
     * @param key
     */
    public void putAll(String key, Map<?, ?> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 取keys
     *
     * @param pattern
     */
    public Set<String> keys(String pattern) {
       return  redisTemplate.keys(pattern);
    }

    /**
     * 存zset
     *
     * @param key
     * @param score
     * @param member
     *
     */
    public void zadd(String key, Object member,Integer  score ){
        redisTemplate.opsForZSet().add(key,member,score);
    }

    /**
     * 逆序取zset
     * @param  key
     * @param topNum
     */
    public Set<Object> reverseRange(String key,Integer topNum) {
        return redisTemplate.opsForZSet().reverseRange(key,0,topNum);
    }

    /**
     * score加一
     */
    public void incr(String key,Object member){
        redisTemplate.opsForZSet().incrementScore(key,member,1);
    }

    /**
     * 存set
     */
    public Long sadd(String key,Object obj){
       return redisTemplate.opsForSet().add(key,obj);
    }
}