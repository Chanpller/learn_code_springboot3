package com.chanpller.chapter1logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Slf4j
public class HelloController {
    //@Slf4j 相当于下面这句话
//    Logger logger = Logger.getLogger(HelloController.class.getName());
    @GetMapping("/hello")
    public String hello() {
        log.info("你好呀");
        return "hello world";
    }
}
