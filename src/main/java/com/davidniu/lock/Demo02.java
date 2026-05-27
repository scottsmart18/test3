package com.davidniu.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo02 {

    public static void main(String[] args) throws Exception {
        Phone2 phone = new Phone2();

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

class Phone2 {
    Lock lock = new ReentrantLock();

    public void sendEmail() throws Exception {
        //Thread.sleep(3000);
        //锁必须配对 lock 就要有 unlock
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" sendEmail");
            sendSMS();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
        //Thread.sleep(3000);

    }
    public void sendSMS() throws Exception {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" sendSMS");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
    public void sayHello() throws Exception {
        System.out.println("sayHello");
    }
}