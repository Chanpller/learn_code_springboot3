package com.chanpller.chapter3data.controller;

import com.chanpller.chapter3data.entity.User;
import com.chanpller.chapter3data.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/user")
    public List<User> getUser() {
        return userMapper.selectAll();
    }
}
