package com.davidniu.thread;
//观察测试线程状态
// 线程状态包括：NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
//死亡后的线程不能再次启动
public class TestState {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000); // 模拟线程执行任务
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=======");
        });

        Thread.State state = t1.getState();
        System.out.println("线程状态：" + state); // NEW

        t1.start();
        state = t1.getState();
        System.out.println("线程状态：" + state); // RUNNABLE

        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100); // 等待线程执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t1.getState(); // 获取线程状态
            System.out.println("线程状态：" + state); // 可能是RUNNABLE或TIMED_WAITING等
        }
        t1.start();// 线程已经结束，不能再次启动

    }

}
