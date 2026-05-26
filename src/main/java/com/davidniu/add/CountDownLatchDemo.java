package com.davidniu.add;

import java.util.concurrent.CountDownLatch;

//计数器
public class CountDownLatchDemo {
        public static void main(String[] args) throws Exception {
            //MyCountDownLatch latch = new MyCountDownLatch(5);
                CountDownLatch latch = new CountDownLatch(6);
            for (int i = 1; i <= 6; i++) {
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + "离开了");
                    latch.countDown();
                }, String.valueOf(i)).start();
            }
            latch.await();
            System.out.println("所有人都离开了，主线程才继续执行");
        }
}
