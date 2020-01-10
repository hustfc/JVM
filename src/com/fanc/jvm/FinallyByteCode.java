package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2020/1/6 9:22 下午
 */
public class FinallyByteCode {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }
}
