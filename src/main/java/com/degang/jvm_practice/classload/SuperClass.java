package com.degang.jvm_practice.classload;

/**
 * Created by degang on 2018/11/20
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

}
