package com.chanpller.mytest.controller;

import com.chanpller.mytest.config.MyTestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private MyTestProperties myTestProperties;
    @GetMapping("/mytest")
    public String mytest() {
        return myTestProperties.getName()+"==>"+myTestProperties.getUrl();
    }
}
