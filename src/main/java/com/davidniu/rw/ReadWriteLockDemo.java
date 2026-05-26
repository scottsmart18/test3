package com.davidniu.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
        public static void main(String[] args) throws Exception {
            //MyCache cache = new MyCache();
            MyCacheLock cache = new MyCacheLock();
            for (int i = 1; i <= 5; i++) {
                final int num = i;
                new Thread(() -> {
                    cache.put(num+"", num+"");
                }, String.valueOf(i)).start();
            }
            for (int i = 1; i <= 5; i++) {
                final int num = i;
                new Thread(() -> {
                    cache.get(num+"");
                }, String.valueOf(i)).start();
            }
        }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "正在写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "正在读取" + key);
        Object value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成" + value);
    }
}

class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key, Object value) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "正在写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
        lock.writeLock().unlock();
    }

    public void get(String key) {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "正在读取" + key);
        Object value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成" + value);
        lock.readLock().unlock();
    }
}