package com.fanc.jvm;
import java.util.*;
/**
 * @Author : fanc
 * @Date : 2019/11/6 10:21 上午
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
