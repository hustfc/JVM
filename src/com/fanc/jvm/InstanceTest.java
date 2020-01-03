package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2020/1/3 10:38 上午
 */
public class InstanceTest {
    public static void main(String[] args) throws Exception{
        Class<?> IntegerClass = Integer.TYPE;
        Object obj1 = IntegerClass.getConstructor().newInstance(3);
        System.out.println(obj1);
        // 是Integer而不是IntegerClass
        System.out.println(obj1 instanceof Integer);
        System.out.println(IntegerClass.isInstance(obj1));

    }
}
