package com.davidniu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    // 测试线程池
    // 线程池可以复用线程，减少创建和销毁线程的开销，提高性能
    // 使用Executors创建线程池
    // 线程池可以控制最大线程数，避免过多线程导致资源耗尽

    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new MyThread(1));
        executorService.execute(new MyThread(2));
        executorService.execute(new MyThread(3));
        executorService.execute(new MyThread(4));

        /*for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("执行任务: " + taskId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }*/

        executorService.shutdown(); // 关闭线程池
    }
}

class MyThread implements Runnable {
    private int taskId;

    public MyThread(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        //for (int i = 0; i < 100; i++) {
            System.out.println("执行任务: " + taskId + " by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // 模拟任务执行时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}
    }
}
