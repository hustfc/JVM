package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2019/11/6 11:11 上午
 */
public class JavaVMStackSOF {
    private static int stackLength = 1;

    public static void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length:" + stackLength);
            throw e;
        }
    }
}
