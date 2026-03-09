package com.chanpller.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher implements ApplicationEventPublisherAware {
    /**
     * 底层发送事件用的组件，SpringBoot会通过ApplicationEventPublisherAware接口
     * 自动注入给我们。事件是广播出去的，所有监听这个事件的监听器都可以收到。
     */
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 发送事件，支持所有类型的 ApplicationEvent。
     *
     * @param event 要发布的事件对象
     */
    public void sendEvent(ApplicationEvent event) {
        // 调用底层API发送事件
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 会被 Spring 自动调用，将真正的事件发布器注入进来。
     *
     * @param applicationEventPublisher 用于发布事件的组件
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
