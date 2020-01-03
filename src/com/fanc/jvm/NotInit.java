package com.fanc.jvm;


class SuperClass {
    public static int value = 666;
    static {
        System.out.println("父类初始化");
    }
}

class SubClass extends SuperClass{
    static {
        System.out.println("子类初始化");
    }
}
/**
 * @Author : fanc
 * @Date : 2020/1/2 10:24 下午
 */
public class NotInit {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
