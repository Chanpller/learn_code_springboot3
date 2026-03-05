package com.chanpller.chapter2web.controller;

import com.chanpller.chapter2web.model.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentnegotiationController {
    @PostMapping("/person")
    public Person person(){
        return new Person(1L,"chanpller","test@pac.com",18);
    }

}
