package com.fhypayaso.tittytainment.modules.security.util;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/29 10:36 下午
#   @Description   : 
# ====================================================*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    // 存入数据到缓存
    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 通过key获得数据
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 存入数据到缓存并设置过期时间（单位为秒）
    public void setValueAndExpire(String key, Object value, long time){
        redisTemplate.opsForValue().set(key, value,time,TimeUnit.SECONDS);
    }

    // 删除缓存
    public void delete(String key){
        redisTemplate.delete(key);
    }



}
