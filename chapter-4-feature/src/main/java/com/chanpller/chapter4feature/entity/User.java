package com.chanpller.chapter4feature.entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"dev","prd"})
@Component
public class User {
}
