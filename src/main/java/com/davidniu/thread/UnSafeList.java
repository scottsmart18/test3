package com.davidniu.thread;
//线程不安全的集合类示例
public class UnSafeList {
    public static void main(String[] args) {
        // 创建一个线程不安全的集合类
        java.util.List<String> list = new java.util.ArrayList<>();

        // 创建多个线程同时操作这个集合
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    // 每个线程向集合中添加一个元素
                    list.add("元素" + Thread.currentThread().getName());
                }
            }).start();
        }

        // 等待所有线程完成
        try {
            Thread.sleep(2000); // 等待2秒，确保所有线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印集合内容
        System.out.println("集合大小: " + list.size());
        System.out.println("集合内容: " + list);
    }

}
