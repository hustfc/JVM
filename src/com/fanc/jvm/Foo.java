package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2019/12/21 4:43 下午
 */
public class Foo {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            System.out.println("Hello, Java!");
        }
        if (flag == true) {
            System.out.println("Hello, JVM!");
        }
    }
}