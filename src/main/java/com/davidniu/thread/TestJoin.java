package com.davidniu.thread;
//测试Join方法的使用 想象成插队

public class TestJoin implements Runnable {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("VIP 来了 : " + i);

        }

    }

    public static void main(String[] args) {

        TestJoin tj = new TestJoin();
        Thread thread1 = new Thread(tj, "线程1");
        //Thread thread2 = new Thread(tj, "线程2");
        //Thread thread3 = new Thread(tj, "线程3");
        thread1.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                try {
                    thread1.join(); // 等待线程1执行完毕后再继续执行主线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程计数: " + i);
        }

    }
}
