package com.davidniu.thread;
//测试守护线程的类
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God(); // 创建上帝线程
        You1 you = new You1(); // 创建你线程
        Thread godThread = new Thread(god); // 将上帝线程封装为Thread对象
        Thread youThread = new Thread(you); // 将你线程封装为Thread对象

        godThread.setDaemon(true); // 设置上帝线程为守护线程  默认是false
        godThread.start(); // 启动上帝线程
        youThread.start(); // 启动你线程
    }

}

class God implements Runnable {
    public void run() {
while (true) {
            System.out.println("上帝在看着你，守护着你！");
            /*try {
                Thread.sleep(1000); // 每秒钟输出一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}




class You1 implements Runnable {
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心地活着，享受生活的每一天！" + i);
        }
        System.out.println("你活了" + 36500 + "天，终于good bye了！");
    }
}