package com.davidniu.thread;

import java.util.concurrent.Callable;

//回顾总结线程的创建和使用
public class ThreadNew {
    public static void main(String[] args) {


        new MyThread1().start(); // 继承Thread类的方式创建线程
        new Thread(new MyThread2()).start(); // 实现Runnable接口的方式创建线程

        // 使用Callable接口和FutureTask创建线程
        MyThread3 myThread3 = new MyThread3();
        java.util.concurrent.FutureTask<Integer> futureTask = new java.util.concurrent.FutureTask<>(myThread3);
        new Thread(futureTask).start(); // 启动Callable线程
        try {
            Integer result = futureTask.get(); // 获取Callable线程的返回值
            System.out.println("Callable线程返回值: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//1. 继承Thread类
class MyThread1 extends Thread {
    public void run() {
        // 重写run方法，线程执行的代码
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread1 线程计数: " + i);
            try {
                Thread.sleep(1000); // 暂停1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//2. 实现Runnable接口
class MyThread2 implements Runnable {
    public void run() {
        // 重写run方法，线程执行的代码
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread2线程计数: " + i);
            try {
                Thread.sleep(1000); // 暂停1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//3. 使用Callable接口和FutureTask
/*import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;*/
class MyThread3 implements Callable<Integer> {
    public Integer call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Callable线程计数: " + i);
            Thread.sleep(1000); // 暂停1秒
        }
        return new Integer(10);
    }
}
