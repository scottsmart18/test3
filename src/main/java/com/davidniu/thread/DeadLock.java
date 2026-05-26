package com.davidniu.thread;
// 测试死锁 多个线程互相持有对方需要的资源，导致无法继续执行
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"灰姑娘");
        Makeup g2 = new Makeup(1,"白雪公主");
        g1.start();
        g2.start();


    }
}

//口红
class LipStick {
     /* public synchronized void apply(Lipstick lipstick) {
        System.out.println(Thread.currentThread().getName() + "正在使用口红");

        try {
            Thread.sleep(1000); // 模拟使用口红的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "使用口红完毕");
        lipstick.apply(this); // 互相调用，可能导致死锁//
    }*/
}

//镜子
class Mirror {
    /*public synchronized void apply(LipStick lipstick) {
        System.out.println(Thread.currentThread().getName() + "正在使用镜子");
        try {
            Thread.sleep(1000); // 模拟使用镜子的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "使用镜子完毕");
    }*/
}

// 化妆
class Makeup extends Thread {
    static private LipStick lipstick = new LipStick();
    static private Mirror mirror = new Mirror();
    int choice; // 用于选择使用口红还是镜子
    // 0表示使用口红，1表示使用镜子
    String girlName; // 用于记录线程名称

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        // 模拟化妆过程
        try{
            System.out.println(this.girlName + "开始化妆");
            makeup(); // 调用化妆方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeup() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
                try {
                    Thread.sleep(1000); // 模拟使用口红的时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //synchronized (mirror){
                  //  System.out.println(this.girlName+"获得镜子的锁");
                // 互相调用可能导致死锁}
            }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }


        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //synchronized (lipstick){
                  //  System.out.println(this.girlName+"获得口红的锁");
                // 互相调用可能导致死锁}
            }
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
            }


        }
    }


}