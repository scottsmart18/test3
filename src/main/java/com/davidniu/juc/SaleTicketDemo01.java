package com.davidniu.juc;



public class SaleTicketDemo01 {
    public static void main(String[] args) {
        // 创建一个共享资源对象
        Ticket ticket = new Ticket();

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
class Ticket {
    private int number = 50; // 票的数量

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖出了一张票，"+number+" 剩余票数: " + --number);
        }
    }
}