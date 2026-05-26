package com.davidniu.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        // 创建一个共享资源对象
        Ticket2 ticket = new Ticket2();

        // 创建多个线程来模拟售票员
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        }, "售票员A");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        }, "售票员B");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        }, "售票员C");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }


}
class Ticket2 {
    private int number = 30; // 票的数量
    Lock lock = new ReentrantLock();
    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出了一张票，"+number+" 剩余票数: " + --number);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
}