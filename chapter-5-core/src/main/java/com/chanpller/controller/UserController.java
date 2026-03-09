package com.chanpller.controller;

import com.chanpller.entity.User;
import com.chanpller.event.LoginOnSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    public UserController(){
        System.out.println("Bean初始化");
    }

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    //自己创建EventPublisher
//    @Autowired
//    private EventPublisher EventPublisher;
    @GetMapping("/login")
    public String login(String name, String password) {

        applicationEventPublisher.publishEvent(new LoginOnSuccessEvent(new User(name, password)));
        //使用EventPublisher发送事件
//        EventPublisher.sendEvent(new LoginOnSuccessEvent(new User(name, password)));
        return "login success";
    }
}
