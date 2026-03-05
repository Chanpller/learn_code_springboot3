package com.chanpller.chapter4feature;

import com.chanpller.chapter4feature.entity.User;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Chapter4FeatureApplication {

    public static void main(String[] args) {
        //这是直接启动方式
//        SpringApplication.run(Chapter4FeatureApplication.class, args);


//        SpringApplication springApplication = new SpringApplication(Chapter4FeatureApplication.class);
//        //关闭后不输出spring字符信息了
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.run(args);

        //流式方法
        ConfigurableApplicationContext run = new SpringApplicationBuilder().sources(Chapter4FeatureApplication.class).child(Chapter4FeatureApplication.class).bannerMode(Banner.Mode.OFF).run(args);
//        User bean = run.getBean(User.class);
//        System.out.println(bean);


    }

}
