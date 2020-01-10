package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2020/1/8 8:52 下午
 */
import java.lang.reflect.*;

class MethodClass {
    public final int fuck = 2;

    private int privateMethod(int a, int b) {
        return a * b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}

public class GetMethodTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = Class.forName("com.fanc.jvm.MethodClass");
        Object obj = c.newInstance();
        System.out.println("getDeclaredMethods方法的输出");
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        System.out.println("getMethods方法输出");
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("调用确定的方法");
        Method add = c.getMethod("add", int.class, int.class);
        System.out.println(add.invoke(obj, 1, 2));
    }
}

