package com.chanpller.chapter5core.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("===========MyApplicationListener=============");
    }

    @Override
    public boolean supportsAsyncExecution() {
        System.out.println("===========MyApplicationListener=============");
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
