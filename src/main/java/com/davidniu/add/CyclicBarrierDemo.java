package com.davidniu.add;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
        public static void main(String[] args) throws Exception {
            CyclicBarrier barrier = new CyclicBarrier(7, () -> {
                System.out.println("召唤神龙成功！");
            });
            for (int i = 1; i <= 7; i++) {
                final int num = i;
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + "收集了"+num+"颗龙珠");
                    try {
                        barrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, String.valueOf(i)).start();
            }
        }
}
