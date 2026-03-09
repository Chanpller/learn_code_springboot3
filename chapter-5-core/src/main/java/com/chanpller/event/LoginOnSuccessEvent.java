package com.chanpller.event;

import com.chanpller.entity.User;
import org.springframework.context.ApplicationEvent;

public class LoginOnSuccessEvent extends ApplicationEvent {
    public LoginOnSuccessEvent(User source) {
        super(source);
    }

}
