package com.chanpller.chapter2web.controller;

import com.chanpller.chapter2web.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class WebFunction {
    @Bean
    public RouterFunction<ServerResponse> personroutes(PersonHandler personHandler) {
        return RouterFunctions.route()
            .GET("/person", personHandler::getPerson)
            .build();
    }
    @Bean
    public RouterFunction<ServerResponse> otherRoutes(PersonHandler personHandler) {
        return RouterFunctions.route()
                .GET("/other/person", personHandler::getPerson)
                .build();
    }
}
