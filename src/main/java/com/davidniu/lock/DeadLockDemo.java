package com.davidniu.lock;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    public static void main(String[] args) {
//        Object lockA = new Object();
//        Object lockB = new Object();
//
//        new Thread(() -> {
//            synchronized (lockA) {
//                System.out.println(Thread.currentThread().getName() + " acquired lockA");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                synchronized (lockB) {
//                    System.out.println(Thread.currentThread().getName() + " acquired lockB");
//                }
//            }
//        }, "Thread-1").start();
//
//        new Thread(() -> {
//            synchronized (lockB) {
//                System.out.println(Thread.currentThread().getName() + " acquired lockB");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                synchronized (lockA) {
//                    System.out.println(Thread.currentThread().getName() + " acquired lockA");
//                }
//            }
//        }, "Thread-2").start();
//    }
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new MyThread(lockA, lockB), "Thread-1").start();
        new Thread(new MyThread(lockB, lockA), "Thread-2").start();
    }
}

class MyThread implements Runnable {
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " acquired "+lockA+ ",想拿"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " acquired "+lockB+",想拿"+lockA);
            }
        }
    }
}
