package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2019/12/21 4:43 下午
 */
public class Foo {
    private String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        System.out.println(new Foo().hello());
    }
}
