package com.chanpller.chapter5security.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    @RolesAllowed({"hello","world"})
    public String hello() {
        return "Hello";
    }
    @RequestMapping("/world")
//    @RolesAllowed({"world"})
    @Secured({"ROLE_world"})
    public String world() {
        return "world";
    }
}
