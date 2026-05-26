package com.davidniu.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

// 演示volatile不具有原子性
public class VDemo02 {
    //private static volatile int num = 0;//
    private static volatile AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        // 等待上面线程执行完
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"=>"+num);

    }
    public  static void add(){
        //num++;
        num.getAndIncrement();
    }
}
