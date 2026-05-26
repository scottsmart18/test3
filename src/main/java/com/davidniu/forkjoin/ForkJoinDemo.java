package com.davidniu.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {
    private long start;
    private long end;
    private long temp = 10000000l;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }

    public static void main(String[] args) {
            //MyTask task = new MyTask(1, 100);
            //Integer result = ForkJoinPool.commonPool().invoke(task);
            //System.out.println(result);
        }


}
