package com.davidniu.thread;
// 测试生产者消费者模式 信号灯法 通过标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        Program program = new Program(); // 创建节目对象
        Player player = new Player(program); // 创建演员线程
        Watcher watcher = new Watcher(program); // 创建观众线程

        player.start(); // 启动演员线程
        watcher.start(); // 启动观众线程

        try {
            player.join(); // 等待演员线程结束
            watcher.join(); // 等待观众线程结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//生产者 演员
class Player extends Thread{
    private final Program program;

    public Player(Program program) {
        this.program = program;
    }

    @Override
    public void run() {

           for (int i = 0; i < 20; i++) {
                if(i%2==0) {
                    program.play("节目内容:  快乐大本营"); // 演员表演节目
                } else {
                    program.play("抖音: 记录美好生活"); //    节目
                }
            }
    }
}
//消费者 观众
class Watcher extends Thread{
    private final Program program;

    public Watcher(Program program) {
        this.program = program;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            program.watch();
        }

    }
}
//产品 节目
class Program {
    //演员表演的时候 观众等待 true
    //观众观看的时候 演员等待 false
    String voice; // 节目内容
    boolean flag = true; // 标志位，表示节目是否已准备好
    //表演
    public synchronized void play(String voice) {
        if (!flag) { // 如果节目未准备好，等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice; // 设置节目内容
        System.out.println("演员表演了: " + voice);
        flag = !this.flag; // 节目已准备好，设置标志位为false
        notifyAll(); // 唤醒等待的观众
    }

    //观看
    public synchronized void watch() {
        if (flag) { // 如果节目未准备好，等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了: " + voice);
        flag = !this.flag; // 节目已观看，设置标志位为true
        notifyAll(); // 唤醒等待的演员
}

}
