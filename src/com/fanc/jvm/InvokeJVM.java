package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2020/1/8 8:59 下午
 */

import java.lang.reflect.*;

public class InvokeJVM {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception{
        Class<?> klass = Class.forName("com.fanc.jvm.InvokeJVM");
        Method method = klass.getMethod("target", int.class);
        method.invoke(klass.newInstance(), 0);
    }

}
