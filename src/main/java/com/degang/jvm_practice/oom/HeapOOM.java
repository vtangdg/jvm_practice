package com.degang.jvm_practice.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Created by degang on 2018/11/13
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        int i = 0;
        while (i < 10000000) {
            i++;
            list.add(new OOMObject());
        }
        System.out.println(list.size());
    }
}
