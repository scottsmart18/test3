package com.davidniu.callable;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
        public static void main(String[] args) throws Exception {
            //Thread thread = new Thread(new Runnable() {});
            //Thread thread2 = new Thread(new FutureTask<>(new Callable() {}){});
            //Thread thread = new Thread(myThread);
            MyThread myThread = new MyThread();
            FutureTask<Integer> futureTask = new FutureTask<>(myThread);
            new Thread(futureTask,"A").start();
            new Thread(futureTask,"B").start();//结果会被缓存，第二次调用get()方法直接返回第一次的结果
            Integer i = futureTask.get();
            System.out.println("futuretask return = "+i);
        }
}
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("MyThread");
        return 1024;
    }
}