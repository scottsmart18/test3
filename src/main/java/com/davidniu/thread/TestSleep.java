package com.davidniu.thread;

public class TestSleep implements Runnable {
    private int ticketnumbers = 10; // 票数

    @Override
    public void run() {

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

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        Thread thread1 = new Thread(testSleep, "小明");
        Thread thread2 = new Thread(testSleep, "小红");
        Thread thread4 = new Thread(testSleep, "票贩子");

        thread1.start();
        thread2.start();
        thread4.start();
    }
}
