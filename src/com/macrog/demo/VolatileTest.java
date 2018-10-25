package com.macrog.demo;

/**
 * @author guohong
 * @date 2018/10/24
 */
public class VolatileTest {
    public static volatile int race = 0;

    public synchronized static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        System.out.println("激活线程数:" + Thread.activeCount());
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 10000; j++) {
                        increase();
                    }
                    System.out.println(Thread.currentThread().getName() + "完成计算");
                }
            });
            threads[i].start();
        }

        //等待所有累加线程都结束
        while(Thread.activeCount() > 2) {
            System.out.println("激活线程数:" + Thread.activeCount());
            Thread.yield();
        }
        System.out.println(race);
    }
}