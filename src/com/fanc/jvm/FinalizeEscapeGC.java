package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2019/11/20 9:39 下午
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC save = null;
    public void isAlive() {
        System.out.println("yes, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        save = this;
    }

    public static void main(String[] args) throws Exception{
        save = null;
        System.gc();
        Thread.sleep(500);
        if (save != null) {
            save.isAlive();
        }
        else {
            System.out.println("no, i am dead!");
        }

        save = null;
        System.gc();
        Thread.sleep(500);
        if (save != null) {
            save.isAlive();
        }
        else {
            System.out.println("no, i am dead!");
        }

    }
}
