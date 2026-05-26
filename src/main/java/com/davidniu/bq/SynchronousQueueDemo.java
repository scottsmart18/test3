package com.davidniu.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
        public static void main(String[] args) throws Exception {
                SynchronousQueueDemo demo = new SynchronousQueueDemo();
                demo.test1();
        }

        public void test1(){
                BlockingQueue<String> queue = new SynchronousQueue<>();
                new Thread(() -> {
                        try {
                                System.out.println(Thread.currentThread().getName()+" put a");
                                queue.put("a");
                                System.out.println(Thread.currentThread().getName()+" put b");
                                queue.put("b");
                                System.out.println(Thread.currentThread().getName()+" put c");
                                queue.put("c");
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }, "AAA").start();
                new Thread(() -> {
                        try {
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println(Thread.currentThread().getName()+"->"+queue.take());
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println(Thread.currentThread().getName()+"->"+queue.take());
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println(Thread.currentThread().getName()+"->"+queue.take());
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }, "BBB").start();
        }
}
