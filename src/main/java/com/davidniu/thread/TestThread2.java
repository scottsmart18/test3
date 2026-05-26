package com.davidniu.thread;

//创建线程的第二种方法：实现runnable接口,重写run方法，执行线程需要丢入实现了runnable接口的类的实例,调用start方法
public class TestThread2 implements Runnable {

    public void run() {
        // 重写run方法，线程执行的代码
        // 模拟线程执行任务
        for (int i = 0; i < 5; i++) {
            System.out.println("线程计数: " + i);
            try {
                Thread.sleep(1000); // 暂停1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestThread2 ts2 = new TestThread2();
        new Thread(ts2).start();// 启动线程

        // 注意：不要直接调用run方法，因为这样不会开启新线程，而是会在主线程中执行run方法
        // ts.run();
        // 主线程
        for (int i=0; i < 5; i++) {
            System.out.println("主线程计数: " + i);
            try {
                Thread.sleep(500); // 暂停0.5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
