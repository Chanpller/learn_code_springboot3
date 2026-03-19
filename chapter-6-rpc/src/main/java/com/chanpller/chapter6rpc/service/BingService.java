package com.chanpller.chapter6rpc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface BingService {
    @GetExchange(url = "/search")
    Mono<String> search(@RequestParam("q") String keyword);
}
