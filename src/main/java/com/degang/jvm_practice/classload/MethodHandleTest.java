package com.degang.jvm_practice.classload;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;


/**
 * Method Handle基础用法演示
 * Created by degang on 2018/11/23
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println(s + " from ClassA");
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

        getPrintlnMH(obj).invokeExact("hello");

    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);

        // 在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄
        return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);

    }
}
