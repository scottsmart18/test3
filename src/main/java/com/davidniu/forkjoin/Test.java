package com.davidniu.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class Test {
        public static void main(String[] args) {
            //test1();//415ms
            try {
                test2();//117ms
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //test3();//166ms
        }

        public static void test1(){
            long startTime = System.currentTimeMillis();
            long sum = 0;
            for (long i = 1l; i <= 10_0000_0000l; i++) {
                sum += i;
            }
            System.out.println(sum);
            long endTime = System.currentTimeMillis();
            System.out.println("耗时:" + (endTime - startTime) + "ms");
        }
        public static void test2() throws Exception{
            long startTime = System.currentTimeMillis();
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            ForkJoinTask<Long> myForkJoin = new ForkJoinDemo(0l,10_0000_0000l);
            ForkJoinTask<Long> submit = forkJoinPool.submit(myForkJoin);
            Long result = submit.get();
            System.out.println(result);
            long endTime = System.currentTimeMillis();
            System.out.println("耗时:" + (endTime - startTime) + "ms");
        }
        public static void test3(){
            long startTime = System.currentTimeMillis();
            //stream流式计算，底层也是ForkJoinPool
            long sum = LongStream.rangeClosed(1l,10_0000_0000l).parallel().reduce(0, Long::sum);
            System.out.println(sum);
            long endTime = System.currentTimeMillis();
            System.out.println("耗时:" + (endTime - startTime) + "ms");
        }
}
