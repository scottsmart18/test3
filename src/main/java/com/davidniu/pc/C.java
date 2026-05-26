package com.davidniu.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//线程之间的交替执行
public class C {
    public static void main(String[] args) {
        Data3 data = new Data3();
        // 创建生产者线程
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");
        // 创建消费者线程
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");
        Thread c = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C");
        Thread d = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D");
        // 启动线程
        producer.start();
        consumer.start();
        c.start();
        d.start();
    }
}
class Data3 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public void increment() throws InterruptedException {
        try {
            lock.lock();
            if (Thread.currentThread().getName().equals("A")) {
            while ( number != 0) {
                condition1.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"生产者生产了一个产品，当前库存：" + number);
            condition2.signal();
            } else if (Thread.currentThread().getName().equals("C")) {
                while (number != 0) {
                    condition3.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName()+"生产者生产了一个产品，当前库存：" + number);
                condition4.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }
    public void decrement() throws InterruptedException {
        try {
            lock.lock();
            if (Thread.currentThread().getName().equals("B")) {
                while (number == 0) {
                    condition2.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "消费者消费了一个产品，当前库存：" + number);
                condition3.signal();
            } else if (Thread.currentThread().getName().equals("D")) {
                while (number == 0) {
                    condition4.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "消费者消费了一个产品，当前库存：" + number);
                condition1.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }

    }
}