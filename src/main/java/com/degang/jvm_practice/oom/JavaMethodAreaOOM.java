package com.degang.jvm_practice.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * java8
 * VM Args: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * throw:"java.lang.OutOfMemoryError: Metaspace"
 * Created by degang on 2018/11/13
 */
public class JavaMethodAreaOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, objects));
            enhancer.create();
        }
    }

}
