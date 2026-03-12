package com.chanpller.mytest.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.my.test")
@Data
public class MyTestProperties {
    private String name;
    private String url;
}
