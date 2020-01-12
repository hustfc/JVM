package com.fanc.jvm;

import java.lang.reflect.*;
/**
 * @Author : fanc
 * @Date : 2020/1/10 8:47 下午
 */
public class InvokeJVMV1 {
    public static void target(int i ) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception{
        Class<?> kclass = Class.forName("com.fanc.jvm.InvokeJVMV1");
        Method method = kclass.getMethod("target", int.class);
        for (int i = 0; i < 20; i ++) {
            method.invoke(null, i);
        }
    }
}
