package com.chanpller.chapter2web.handler;

import com.chanpller.chapter2web.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class PersonHandler {
    public ServerResponse getPerson(ServerRequest serverRequest) {
        return ServerResponse.ok().body(new Person(1L,"chanpller","test@pac.com",18));
    }
    public ServerResponse delete(ServerRequest serverRequest) {
        return ServerResponse.ok().build();
    }
}
