package com.chanpller.chapter5core.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private String name;
    private String email;
}
