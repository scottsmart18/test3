package com.davidniu.pool;


import java.util.concurrent.*;

public class Demo01 {
        public static void main(String[] args) {
            //ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程池
            //ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩线程池
            //ExecutorService threadPool = Executors.newFixedThreadPool(5);//固定线程池
            ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(2),
                    //new ThreadPoolExecutor.AbortPolicy());
                    //new ThreadPoolExecutor.CallerRunsPolicy());
                    //new ThreadPoolExecutor.DiscardPolicy());
                    new ThreadPoolExecutor.DiscardOldestPolicy());
            System.out.println(Runtime.getRuntime().availableProcessors());
            for (int i = 1; i <= 10; i++) {
                final int num = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务" + num);
                });
            }
                threadPool.shutdown();
        }
}
