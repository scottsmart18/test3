package com.davidniu.thread;

public class TestStop implements Runnable {
    //测试stop
    // 建议线程正常停止，利用次数，不建议死循环
    // 通过设置一个标志位来控制线程的停止
    //不要使用Thread.stop()或Thread.destroy等过时的方法，因为它会强制终止线程，可能导致资源泄露或数据不一致。
    private Boolean flag = true;

    public void run() {
        int i=0;
        while (flag) {
            System.out.println("线程正在运行..."+i++);
        }
    }

    public void stop() {
        flag = false; // 设置标志位为false，停止线程}
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程计数: " + i);
            if( i == 90 ){
                testStop.stop();
                System.out.println("线程停止了");
            }
        }
    }


}