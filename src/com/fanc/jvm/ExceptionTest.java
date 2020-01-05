package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2020/1/5 7:52 下午
 */
public class ExceptionTest {
    public static void mayThrowException(){

    }

    public static void main(String[] args) {
        try {
            mayThrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
