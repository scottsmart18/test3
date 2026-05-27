package com.davidniu.lock;

import java.util.concurrent.TimeUnit;

public class TestSpinLock {

    public static void main(String[] args) throws Exception {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLockDemo.myUnLock();
            }

        }, "A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            spinLockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                spinLockDemo.myUnLock();
            }
        }, "B").start();
    }
}
