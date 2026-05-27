package com.davidniu.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

     AtomicReference<Thread> atomicReference = new AtomicReference<>();
        //加锁
     public void myLock() {
         Thread currentThread = Thread.currentThread();
         System.out.println(currentThread.getName() + "\t come in myLock");
         //自旋锁
         while (!atomicReference.compareAndSet(null,currentThread)) {

         }
     }
        //解锁
     public void myUnLock() {
         Thread currentThread = Thread.currentThread();
         System.out.println(currentThread.getName() + "\t come in myUnLock");
         atomicReference.compareAndSet(currentThread,null);
     }


}
