package com.davidniu.tvolatile;

import java.util.concurrent.TimeUnit;

public class JMMDemo {
    private static volatile int num = 0;
    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    num++;
//                }
//            }).start();
//        }
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }
        new Thread(()->{while (num ==0) { }}).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        num=1;
        System.out.println(num);
    }
}
