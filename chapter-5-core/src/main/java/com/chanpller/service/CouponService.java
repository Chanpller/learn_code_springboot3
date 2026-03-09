package com.chanpller.service;

import com.chanpller.entity.User;
import com.chanpller.event.LoginOnSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    @EventListener
    @Order(1)
    public void onEvent(LoginOnSuccessEvent event){
        System.out.println("=======CouponService====感知到事件");
        sendCoupon((User)event.getSource());
    }

    private void sendCoupon(User source) {
        System.out.println("给用户" + source.getName() + "发送优惠券");
    }
}
