package com.chanpller.chapter5core.listener;

import com.chanpller.chapter5core.entity.User;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.bootstrap.ConfigurableBootstrapContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("===========boot初始化之前就执行，正在启动===========");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("===========环境准备好的之后，环境准备好了==========="+environment.getSystemEnvironment());
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("===========容器准备好了，但是还没加载容器===========");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("===========容器加载了，但是还没刷新容器，还没有将实例注入进来===========");
    }

    @Override
    public void started(ConfigurableApplicationContext context, @Nullable Duration timeTaken) {
        System.out.println("===========类已经加载，项目启动完成==========="+context.getBean(User.class)+timeTaken);
    }

    @Override
    public void ready(ConfigurableApplicationContext context, @Nullable Duration timeTaken) {
        System.out.println("===========项目已经完全加载，已经准备完成==========="+context.getBean(User.class)+timeTaken);
    }

    @Override
    public void failed(@Nullable ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("===========异常时加载，启动失败==========="+context.getBean(User.class)+exception);
    }
}
