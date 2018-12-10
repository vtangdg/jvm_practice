package com.degang.jvm_practice.concurrency;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 变量并发下的运算并不安全
 * Created by degang on 2018/12/6
 */
@Slf4j
public class VolatileTest {
    public static volatile int race = 0;
    public static volatile int syncRace = 0;
    public static AtomicInteger atomicRace = new AtomicInteger(0);

    public static void increase() {
        race++;
    }

    public synchronized static void syncIncrease() {
        syncRace++;
    }

    // 性能优于sync
    public static void nonBlockSyncIncrease() {
        atomicRace.incrementAndGet();
    }

    public static void main(String[] args) {
        int THREAD_COUNT = 20;

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                    syncIncrease();
                    nonBlockSyncIncrease();
                    // log.info("{}:{}",Thread.currentThread().getName(), race);
                }
            });

            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        log.info("finally race value is :{}", race);
        log.info("finally syncRace value is :{}", syncRace);
        log.info("finally atomicRace value is :{}", atomicRace);

    }
}
