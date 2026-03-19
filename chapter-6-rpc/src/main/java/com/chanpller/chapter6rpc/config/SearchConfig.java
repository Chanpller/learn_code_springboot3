package com.chanpller.chapter6rpc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class SearchConfig {
    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        //1、创建客户端
        WebClient client = WebClient.builder().baseUrl("https://cn.bing.com").codecs(clientCodecConfigurer -> {
            clientCodecConfigurer.defaultCodecs().maxInMemorySize(256 * 1024 * 1024);
            //响应数据量太大有可能会超出BufferSize，所以这里设置的大一点
        }).build();
        //2、创建工厂

        //HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();这段代码错误，因为WebClientAdapter.forClient()方法已弃用,在3.0.5版本中可用

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();//3.5.11
        return factory;
    }
}
