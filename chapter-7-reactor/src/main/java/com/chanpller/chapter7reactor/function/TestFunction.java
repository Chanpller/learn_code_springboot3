package com.chanpller.chapter7reactor.function;

@FunctionalInterface //检查注解，帮我们快速检查我们写的接口是否函数式接口
interface MyInterface {
     void test();
     default void test2(){

     }
     static void test3(){

     }
}
class MyInterfaceImpl implements MyInterface {
    @Override
    public void test() {
        System.out.println("test");
    }
}

public class TestFunction {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.test();

        MyInterface myInterface2 = () -> System.out.println("test2");
        myInterface2.test();

    }
}
