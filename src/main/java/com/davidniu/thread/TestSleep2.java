package com.davidniu.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TestSleep2 {

    public static void main(String[] args) {
        //new TestSleep2().tenDown(); // 调用 tenDown 方法
        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            try{
                Thread.sleep(1000); // 暂停1秒
                System.out.println("开始时间: " + new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void tenDown(){
        int num = 10;
        while(true){
            System.out.println(Thread.currentThread().getName() + " 计数: " + num);
            num--;
            try {
                Thread.sleep(1000); // 暂停1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num == 0){
                break;
            }
        }
    }
}
