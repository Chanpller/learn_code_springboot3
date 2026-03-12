package com.chanpller.chapter5core.listener;

import com.chanpller.chapter5core.entity.User;
import com.chanpller.chapter5core.event.LoginOnSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class AccountListener implements ApplicationListener<LoginOnSuccessEvent> {

    @Override
    public void onApplicationEvent(LoginOnSuccessEvent event) {
        System.out.println("=======AccountListener====感知到事件");
        User user = (User)event.getSource();
        addAccount(user);
    }
    public void addAccount(User user) {
        System.out.println("给用户" + user.getName() + "添加1积分");
    }
}
