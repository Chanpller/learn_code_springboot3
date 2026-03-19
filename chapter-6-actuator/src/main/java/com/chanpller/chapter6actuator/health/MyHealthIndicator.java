package com.chanpller.chapter6actuator.health;

import com.chanpller.chapter6actuator.component.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
    @Autowired
    private MyComponent myComponent;
    @Override
    public Health health() {
        int errorCode = myComponent.check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build
                    ();
        }
        return Health.up().build();
    }
}

//Health build = Health.down()
//        .withDetail("msg", "error service")
//        .withDetail("code", "500")
//        .withException(new RuntimeException())
//        .build();