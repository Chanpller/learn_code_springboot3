package com.chanpller.chapter5core.event;

import com.chanpller.chapter5core.entity.User;
import org.springframework.context.ApplicationEvent;

public class LoginOnSuccessEvent extends ApplicationEvent {
    public LoginOnSuccessEvent(User source) {
        super(source);
    }

}
