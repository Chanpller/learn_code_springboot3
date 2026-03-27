package com.chanpller.chapter6actuator.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MyService{
    Counter counter;
    public MyService(MeterRegistry meterRegistry){
        //自动一获取一个Counter计数器
        counter = meterRegistry.counter("myservice.method.running.counter");
    }
    public void hello() {
        counter.increment();
    }
}