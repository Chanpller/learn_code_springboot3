package com.chanpller.chapter3data.mapper;

import com.chanpller.chapter3data.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
