package com.chanpller.mytest;

import com.chanpller.mytest.config.MyTestProperties;
import com.chanpller.mytest.controller.TestController;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@AutoConfiguration
@EnableConfigurationProperties(MyTestProperties.class)
//@Import(TestController.class)
@ComponentScan(basePackages = "com.chanpller.mytest")
public class MyTestAutoConfiguration {
}
