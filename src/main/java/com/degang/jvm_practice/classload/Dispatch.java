package com.degang.jvm_practice.classload;

/**
 * 单分派、多分派演示
 * Created by degang on 2018/11/23
 */
public class Dispatch {
    static class QQ {}
    static class _360{}

    public static class Father {
        public void hardChoice(QQ qq) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        @Override
        public void hardChoice(QQ qq) {
            System.out.println("son choose qq");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();

        // father choose 360
        father.hardChoice(new _360());
        // son choose qq
        son.hardChoice(new QQ());
    }



}
