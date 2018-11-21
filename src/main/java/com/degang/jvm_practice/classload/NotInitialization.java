package com.degang.jvm_practice.classload;

/**
 * Created by degang on 2018/11/20
 */
public class NotInitialization {
    public static void main(String[] args) {
        // "SuperClass init"
        // "123"
        System.out.println(SubClass.value);

        // 引用类的方式都不会触发初始化，称之为被动引用
        // 不会输出"SuperClass init"
        SuperClass[] s = new SuperClass[10];
    }
}
