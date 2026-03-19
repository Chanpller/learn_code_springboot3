package com.chanpller.chapter6rpc.webclient;

import com.chanpller.chapter6rpc.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientTest {
    public static void main(String[] args) {
        // 方式 3: 异步回调方式（非阻塞）
        WebClient client = WebClient.create("https://www.baidu.com");
        client.get().uri("/").accept(MediaType.ALL).retrieve()
                .bodyToMono(String.class)
                .subscribe(
                        data -> System.out.println(data), // 成功回调
                        error -> System.err.println("请求失败：" + error.getMessage()), // 错误回调
                        () -> System.out.println("请求完成") // 完成回调
                );

        // 等待一下让异步请求执行完成
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
