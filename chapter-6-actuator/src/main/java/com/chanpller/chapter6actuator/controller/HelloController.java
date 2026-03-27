package com.chanpller.chapter6actuator.controller;

import com.chanpller.chapter6actuator.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private MyService myService;
    @GetMapping("/hello")
    public String hello() {
        myService.hello();
        return "hello world";
    }
}
