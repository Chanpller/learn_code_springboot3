package com.chanpller.chapter6nosql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate   redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redisTemplate")
    public String redisTemplate() {
        redisTemplate.opsForValue().set("redisTemplate", "redisTemplateValue");
        return redisTemplate.opsForValue().get("redisTemplate").toString();
    }
    @GetMapping("/stringRedisTemplate")
    public String stringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("stringRedisTemplate", "stringRedisTemplateValue");
        return stringRedisTemplate.opsForValue().get("stringRedisTemplate");
    }
}
