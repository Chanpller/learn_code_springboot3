package com.chanpller.chapter2web.controller;

import com.chanpller.chapter2web.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentnegotiationController {
    @GetMapping("/person")
    public Person person(){
        return new Person(1L,"chanpller","test@pac.com",18);
    }

}
