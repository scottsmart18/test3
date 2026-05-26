package com.davidniu.juc;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("CPU =   "+Runtime.getRuntime().availableProcessors());

        try {
            //TimeUnit.DAYS.sleep(1);
            TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public enum State {
        // 新生
        NEW,
        // 就绪
        RUNNABLE,
        // 运行
        RUNNING,
        // 阻塞
        BLOCKED,
        // 等待
        WAITING,
        // 超时等待
        TIMED_WAITING,
        // 终止
        TERMINATED


    }
}
