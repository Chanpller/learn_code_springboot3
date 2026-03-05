package com.chanpller.chapter3data;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.chanpller.chapter3data.mapper")
public class Chapter3DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter3DataApplication.class, args);
    }

}
