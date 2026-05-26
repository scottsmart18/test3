package com.davidniu.lock8;

import java.util.concurrent.TimeUnit;

public class Test3 {

    public static void main(String[] args) throws Exception {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();
        new Thread(() -> {
            try {
                phone1.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

class Phone3 {
    public static synchronized void sendEmail() throws Exception {
        Thread.sleep(3000);
        System.out.println("sendEmail");
        //Thread.sleep(3000);
    }
    public static synchronized void sendSMS() throws Exception {
        System.out.println("sendSMS");
    }
    public void sayHello() throws Exception {
        System.out.println("sayHello");
    }
}