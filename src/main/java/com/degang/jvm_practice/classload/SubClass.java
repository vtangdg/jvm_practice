package com.degang.jvm_practice.classload;

/**
 * Created by degang on 2018/11/20
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}
