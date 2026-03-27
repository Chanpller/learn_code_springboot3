package com.chanpller.chapter7reactor.function;

import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
//        Function<String,Integer> function = (s)-> Integer.parseInt(s);
        //一个入，一个出
        //String,Integer，前面String是入参，Inter是出餐一个参数，一个返回值，函数式接口
        Function<String,Integer> function = Integer::parseInt;
        System.out.println(function.apply("123"));

        //消费者，binary 双份，两个参数的，String,String都是入参
        //都是入，没有出
        BiConsumer<String,String> biConsumer = (s1,s2)-> System.out.println(s1+s2);

        biConsumer.accept("123","456");

        //没有入，只有出
        //生产者
        Supplier<String> stringSupplier = ()-> UUID.randomUUID().toString();
        System.out.println(stringSupplier.get());

        //没入，没出
        Runnable runnable = ()-> System.out.println("runnable");
        runnable.run();

        //Predicate断言
        Predicate<Integer> predicate = (i)-> i%2==0;
        System.out.println(predicate.test(2));
        System.out.println(predicate.negate().test(2));
    }
}
