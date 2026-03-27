package com.chanpller.chapter7reactor.function;

import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        list.stream().forEach(System.out::println);
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

        Stream<Integer> integerStream = list.stream().filter(i -> {
                    System.out.println("中间过程执行"+i);
                    return i % 2 == 0;
                }
        );
        integerStream.count();
    }
}
