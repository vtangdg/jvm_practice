package com.degang.jvm_practice.classload;

/**
 * 静态分派8.3.2
 * Created by degang on 2018/11/23
 */
public class StaticDispatch {
    static abstract class Human {

    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human human) {
        System.out.println("hello guy");
    }

    public void sayHello(Man man) {
        System.out.println("hello gentleman");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        // "Human"变量的静态类型，编译期可知；"Man"变量的实际类型，运行期才确定
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sd = new StaticDispatch();
        // hello guy
        sd.sayHello(man);
        // hello guy
        sd.sayHello(woman);
    }

}
