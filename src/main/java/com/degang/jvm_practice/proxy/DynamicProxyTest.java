package com.degang.jvm_practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by degang on 2018/11/27
 */
public class DynamicProxyTest {
    interface Hello {
        void sayHello();
    }

    static class HelloImpl implements Hello {
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }

    static class HelloProxy implements InvocationHandler {
        private Object originObj;

        Object bind(Object originObj) {
            this.originObj = originObj;
            return Proxy.newProxyInstance(originObj.getClass().getClassLoader(), originObj.getClass().getInterfaces(), this);
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originObj, args);
        }
    }

    public static void main(String[] args) {
        Hello hello = (Hello) new HelloProxy().bind(new HelloImpl());
        hello.sayHello();
    }
}
