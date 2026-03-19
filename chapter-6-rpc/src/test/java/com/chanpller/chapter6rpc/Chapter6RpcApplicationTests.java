package com.chanpller.chapter6rpc;

import com.chanpller.chapter6rpc.service.BingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@SpringBootTest
class Chapter6RpcApplicationTests {

    @Test
    public void contextLoads() throws InterruptedException {
        //1、创建客户端
        WebClient client = WebClient.builder().baseUrl("https://cn.bing.com").codecs(clientCodecConfigurer -> {
            clientCodecConfigurer.defaultCodecs().maxInMemorySize(256 * 1024 * 1024);
        //响应数据量太大有可能会超出BufferSize，所以这里设置的大一点
        }).build();
        //2、创建工厂

        //HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();这段代码错误，因为WebClientAdapter.forClient()方法已弃用,在3.0.5版本中可用

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();//3.5.11
        //3、获取代理对象
        BingService bingService = factory.createClient(BingService.class);


        //4、测试调用
        Mono<String> search = bingService.search("尚硅谷");
        System.out.println("==========");
        search.subscribe(str -> System.out.println(str));
        Thread.sleep(100000);
    }

}
