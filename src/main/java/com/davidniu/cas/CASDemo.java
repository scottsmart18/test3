package com.davidniu.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {
        private static int count = 0;


        public static void main(String[] args) {
            //AtomicInteger atomicInteger = new AtomicInteger(2026);
            //如果泛型的包装类是Integer，Long，Short，Byte，Character等基本类型的包装类，那么在进行CAS操作时会有一个问题：
            // 当值为-128~127之间的数时，会使用对象池中的对象，而当值不在这个范围内时，会创建新的对象，这就导致了ABA问题。
            // 解决ABA问题的方式是使用AtomicStampedReference类，它在进行CAS操作时会同时比较值和版本号，从而避免了ABA问题。
            //正常情况下 AtomicStampedReference<Integer>，这里会是一个对象。
            AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(1, 1);

            new Thread(() -> {
                int stamp = atomicInteger.getStamp();
                System.out.println("A线程第一次版本号："+stamp);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicInteger.compareAndSet(1, 2, stamp, stamp + 1);
                System.out.println("A线程第二次版本号："+atomicInteger.getStamp());
                atomicInteger.compareAndSet(2, 1, atomicInteger.getStamp(), atomicInteger.getStamp() + 1);
                System.out.println("A线程第三次版本号："+atomicInteger.getStamp());
            }, "A").start();

                new Thread(() -> {
                    int stamp = atomicInteger.getStamp();
                    System.out.println("B线程第一次版本号："+stamp);
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boolean result = atomicInteger.compareAndSet(1, 3, stamp, stamp + 1);
                    System.out.println("B线程CAS结果："+result);
                    System.out.println("B线程第二次版本号："+atomicInteger.getStamp());
                },"B").start();

//            atomicInteger.compareAndSet(2026, 2027);
//            System.out.println(atomicInteger.get());
//            System.out.println(atomicInteger.compareAndSet(2027, 2026));
//            System.out.println(atomicInteger.get());
//            System.out.println(atomicInteger.compareAndSet(2026, 2028));
//            System.out.println(atomicInteger.get());
//            for (int i = 0; i < 10000; i++) {
//                new Thread(() -> {
//                    for (int j = 0; j < 10000; j++) {
//                        count++;
//                    }
//                }).start();
//            }
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(count);
        }
}
