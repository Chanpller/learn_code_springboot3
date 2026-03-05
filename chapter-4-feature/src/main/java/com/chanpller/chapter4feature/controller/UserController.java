package com.chanpller.chapter4feature.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${test.value:没找到}")
    private String userName;
    @GetMapping("/user")
    public String getUser() {
        return userName;
    }
}
