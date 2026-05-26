package com.davidniu.thread;

import java.lang.reflect.Proxy;
//静态代理模式总结
// 1. 静态代理模式是面向接口编程的，代理类和目标类都实现同一个接口。
// 2. 代理类和目标类的关系是组合关系，代理类持有目标类的引用。
// 3. 代理类可以在调用目标类的方法前后添加额外的逻辑，比如日志、权限检查等。
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("我爱你") ).start();
        // 创建一个代理对象
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        // 调用代理对象的方法
        weddingCompany.happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("You are getting married!");
    }
}

class WeddingCompany implements Marry {
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        System.out.println("Wedding company is preparing for the wedding.");
        target.happyMarry();
        System.out.println("Wedding company has completed the wedding.");
    }
}

