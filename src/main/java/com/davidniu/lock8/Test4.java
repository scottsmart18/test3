package com.davidniu.lock8;

import java.util.concurrent.TimeUnit;

public class Test4 {

    public static void main(String[] args) throws Exception {
        Phone4 phone = new Phone4();
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
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

class Phone4 {
    public static synchronized void sendEmail() throws Exception {
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