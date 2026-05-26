package com.davidniu.thread;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestJUC {
    // 测试Java并发包（java.util.concurrent）中的一些类和方法
    // JUC提供了更高级的并发工具，如线程池、锁、原子变量等
    // 主要用于简化多线程编程，提供更好的性能和可维护性

    public static void main(String[] args) {
        // 这里可以添加测试代码，演示JUC的使用
        System.out.println("测试Java并发包（JUC）");
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                // 使用CopyOnWriteArrayList，线程安全的写入操作
                list.add(Thread.currentThread().getName() + " - " + System.currentTimeMillis());
            }).start();
        }
        // 等待所有线程完成
        try {
            Thread.sleep(3000); // 等待5秒，确保所有线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出列表大小
        System.out.println("列表大小: " + list.size());
    }
}