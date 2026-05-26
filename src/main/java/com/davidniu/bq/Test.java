package com.davidniu.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
        public static void main(String[] args) throws Exception {
                Test test = new Test();
                test.test4();
        }

        public void test1(){
            ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
                new Thread(() -> {
                    try {
                        System.out.println(queue.add("a"));
                        System.out.println(queue.add("b"));
                        System.out.println(queue.add("c"));

                        System.out.println("=====================================");
                        System.out.println(queue.remove());
                        System.out.println(queue.remove());
                        System.out.println(queue.remove());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, "AAA").start();
                /*Thread.sleep(1000);
                new Thread(() -> {
                    try {
                        System.out.println(queue.take());
                        System.out.println(queue.take());
                        System.out.println(queue.take());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, "BBB").start();*/
        }

        public void test2(){
                ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
                    new Thread(() -> {
                        try {
                            System.out.println(queue.offer("a"));
                            System.out.println(queue.offer("b"));
                            System.out.println(queue.offer("c"));
                            System.out.println(queue.offer("d"));
                            //System.out.println(queue.element());
                            System.out.println(queue.peek());
                            System.out.println("=====================================");
                            System.out.println(queue.poll());
                            System.out.println(queue.poll());
                            System.out.println(queue.poll());
                            System.out.println(queue.poll());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }, "AAA").start();
        }

    public void test3(){
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        new Thread(() -> {
            try {
                queue.put("a");
                queue.put("b");
                queue.put("c");
                //queue.put("d");
                //System.out.println(queue.element());
                //System.out.println(queue.peek());
                System.out.println("=====================================");
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
                //System.out.println(queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AAA").start();
    }

    public void test4(){
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        new Thread(() -> {
            try {
                System.out.println(queue.offer("a"));
                System.out.println(queue.offer("b"));
                System.out.println(queue.offer("c"));
                System.out.println(queue.offer("d",2, TimeUnit.SECONDS));
                //System.out.println(queue.element());
                System.out.println(queue.peek());
                System.out.println("=====================================");
                System.out.println(queue.poll());
                System.out.println(queue.poll());
                System.out.println(queue.poll());
                System.out.println(queue.poll(2, TimeUnit.SECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AAA").start();
    }
}
