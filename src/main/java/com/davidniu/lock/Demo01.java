package com.davidniu.lock;


public class Demo01 {

    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        //Thread.sleep(1000);
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

class Phone {
    public synchronized void sendEmail() throws Exception {
        //Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+" sendEmail");
        //Thread.sleep(3000);
        sendSMS();
    }
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName()+" sendSMS");
    }
    public void sayHello() throws Exception {
        System.out.println("sayHello");
    }
}