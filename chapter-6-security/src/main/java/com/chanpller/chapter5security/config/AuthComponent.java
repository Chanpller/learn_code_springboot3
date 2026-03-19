package com.chanpller.chapter5security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class  AuthComponent{
//    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //authorizeHttpRequests认证配置
        http.authorizeHttpRequests(
                (registry) ->
                        registry
                                .requestMatchers("/")///是首页，不需要认证
                                .permitAll()//允许所有请求
                                .requestMatchers("/hello").hasAnyRole("hello","world")
                                .requestMatchers("/world").hasRole("world")///是首页，不需要认证
                                .anyRequest()//其他请求需要认证
                                .authenticated()//需要认证
        );
        http.formLogin(withDefaults());//开启表单登录，默认登录页面是/login
//        http.httpBasic(withDefaults());
        return http.build();
    }
}