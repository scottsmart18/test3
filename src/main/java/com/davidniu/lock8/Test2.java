package com.davidniu.lock8;

import java.util.concurrent.TimeUnit;

public class Test2 {

    public static void main(String[] args) throws Exception {
        Phone2 phone = new Phone2();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                phone.sayHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

class Phone2 {
    public synchronized void sendEmail() throws Exception {
        Thread.sleep(3000);
        System.out.println("sendEmail");
        //Thread.sleep(3000);
    }
    public synchronized void sendSMS() throws Exception {
        System.out.println("sendSMS");
    }
    public void sayHello() throws Exception {
        System.out.println("sayHello");
    }
}