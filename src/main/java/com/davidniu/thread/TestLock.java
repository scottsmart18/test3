package com.davidniu.thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2, "窗口1").start();
        new Thread(testLock2, "窗口2").start();
        new Thread(testLock2, "窗口3").start();
    }

}

class TestLock2 implements Runnable {
    int ticketnumbers = 10; // 票数
//定义可重复锁，保证线程安全
    private final ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            try {
                lock.lock(); //加锁
                if (ticketnumbers > 0) {
                    try {
                        Thread.sleep(1000); // 模拟售票的延时
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketnumbers--);
                } else {
                    break;
                }

            } finally {
                // 确保释放锁
                lock.unlock();
            }

        }
    }
}
