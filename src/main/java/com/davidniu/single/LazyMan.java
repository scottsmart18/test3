package com.davidniu.single;

import java.lang.reflect.Constructor;

//懒汉模式
public class LazyMan {
    private volatile static LazyMan lazyMan;
    private static boolean flag = false;

    private LazyMan() {
        synchronized (LazyMan.class) {
            if(flag == false){
                flag=true;
            } else {
                if (lazyMan != null) {
                    throw new RuntimeException("不要试图使用反射破坏单例");
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "ok");
    }
    //双重检测锁 DCL=Double Check Lock
    public LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();//不是一个原子性操作，分为三步：1.分配内存空间 2.执行构造方法 3.把这个对象指向这个空间
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazyMan instance = new LazyMan().getInstance();
//            }).start();
//        }
        //LazyMan instantce = new LazyMan().getInstance();

        try {
            Constructor<LazyMan> constructor = LazyMan.class.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            LazyMan instantce = constructor.newInstance();
            LazyMan instance1 = constructor.newInstance();
            System.out.println(instantce);
            System.out.println(instance1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
