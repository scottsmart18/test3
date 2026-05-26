package com.davidniu.thread;
//不安全的买票程序示例
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        Thread thread1 = new Thread(buyTicket, "小明");
        Thread thread2 = new Thread(buyTicket, "小红");
        Thread thread3 = new Thread(buyTicket, "票贩子");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class BuyTicket implements Runnable {
    private int ticketNumbers = 10; // 票数
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            // 模拟售票过程
            buyTicket();
            try {
                Thread.sleep(200); // 模拟售票的延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
//同步方法，锁的是当前对象this
    private synchronized void buyTicket() {
        // 这里可以添加买票的逻辑
        // 但由于没有同步控制，多个线程可能会同时访问ticketNumbers，导致数据紊乱
        if (ticketNumbers <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "-->拿到了 第 " + ticketNumbers-- + "张票");
    }


}
