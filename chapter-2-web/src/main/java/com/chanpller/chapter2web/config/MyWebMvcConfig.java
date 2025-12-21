package com.chanpller.chapter2web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

//@EnableWebMvc // 开启SpringMVC,会禁用boot默认的配置
@Configuration //这是一个配置类
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //保留以前规则
//        WebMvcConfigurer.super.addResourceHandlers(registry);
        //自己写新的规则。
        registry.addResourceHandler("/mystatic/**")//路径匹配
                .addResourceLocations("classpath:/a/","classpath:/b/")//静态资源路径
                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
    }
}
