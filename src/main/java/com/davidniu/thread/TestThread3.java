package com.davidniu.thread;

//多个线程共享同一个对象的属性，线程不安全 数据紊乱
public class TestThread3 implements Runnable {

    private int ticketnumbers = 10; // 票数

    @Override
    public void run() {
        synchronized (this) { // 同步代码块，锁定当前对象
            while (true) {
                // 模拟售票过程
                if (ticketnumbers <= 0)
                    break;
                try {
                    Thread.sleep(200); // 模拟售票的延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->拿到了 第 " + ticketnumbers-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        Thread thread1 = new Thread(testThread3, "小明");
        Thread thread2 = new Thread(testThread3, "小红");
        Thread thread4 = new Thread(testThread3, "票贩子");

        thread1.start();
        thread2.start();
        thread4.start();
    }
}
