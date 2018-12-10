package com.degang.jvm_practice.concurrency;

/**
 * Created by degang on 2018/12/6
 */
public class HappensBefore {

    static class Obj {
        private int value = 0;

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static class VolatileObj {
        private volatile int value = 0;

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static class SyncObj {
        private int value = 0;

        public synchronized void setValue(int value) {
            this.value = value;
        }

        public synchronized int getValue() {
            return value;
        }
    }


    public static void main(String[] args) {
        Obj obj = new Obj();
        VolatileObj volatileObj = new VolatileObj();
        SyncObj syncObj = new SyncObj();

        Thread thread = new Thread(() -> {
            volatileObj.setValue(1);
            syncObj.setValue(1);
            obj.setValue(1);
        });
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(obj.getValue());
        }

        System.out.println("=======");
        for (int i = 0; i < 5; i++) {
            System.out.println(volatileObj.getValue());
        }

        System.out.println("=======");
        for (int i = 0; i < 5; i++) {
            System.out.println(syncObj.getValue());
        }
    }



}
