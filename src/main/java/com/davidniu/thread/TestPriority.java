package com.davidniu.thread;
//测试线程的优先级
public class TestPriority {
    public static void main(String[] args) {
        //主线程的默认优先级
        System.out.println(Thread.currentThread().getName() + "的优先级是：" + Thread.currentThread().getPriority());
        //创建线程对象
        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority, "线程1");
        Thread thread2 = new Thread(myPriority, "线程2");
        Thread thread3 = new Thread(myPriority, "线程3");
        Thread thread4 = new Thread(myPriority, "线程4");
        Thread thread5 = new Thread(myPriority, "线程5");
        Thread thread6 = new Thread(myPriority, "线程6");
        //先设置线程的优先级
        thread4.setPriority(Thread.MAX_PRIORITY); // 设置线程4的优先级为最高
        thread4.start();
        thread1.start();
        thread2.setPriority(Thread.MIN_PRIORITY); // 设置线程2的优先级为最低
        thread2.start();
        thread3.setPriority(4); // 设置线程3的优先级为4
        thread3.start();

        /*thread5.setPriority(-1); // 设置线程5的优先级为-1（无效，因为优先级范围是1-10）
        thread5.start();
        thread6.setPriority(11); // 设置线程6的优先级为11（无效，因为优先级范围是1-10）
        thread6.start();*/
        thread5.setPriority(8); // 设置线程5的优先级为8
        thread5.start();
        thread6.setPriority(7); // 设置线程6的优先级为7
        thread6.start();

    }

}

class MyPriority implements Runnable{

    @Override
    public void run() {
        // 获取当前线程的优先级
        int priority = Thread.currentThread().getPriority();
        System.out.println(Thread.currentThread().getName() + "的优先级是：" + priority);

    }
}
