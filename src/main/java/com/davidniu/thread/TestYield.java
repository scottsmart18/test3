package com.davidniu.thread;
//测试礼让线程
//礼让不一定会生效，取决于CPU调度策略
public class TestYield  {
    public static void main(String[] args) {
        // 创建线程对象
        MyYield myYield = new MyYield();
        Thread thread1 = new Thread(myYield, "线程1");
        Thread thread2 = new Thread(myYield, "线程2");

        // 启动线程
        thread1.start();
        thread2.start();


    }

}

class MyYield implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }


}
