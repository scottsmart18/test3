package com.davidniu.oop;

import com.davidniu.study.Father;

public class Daughter extends Father {
    public Daughter() {

        System.out.println("Daughter  的构造方法");
    }

    //匿名代码块，赋初始值
    {
        System.out.println("Daughter 的匿名代码块");
    }
    //静态代码块,只执行一次
    static {
        System.out.println("Daughter 的静态代码块");
    }

    public static void main(String[] args) {
        new Daughter();
        System.out.println("=========================");
        new Daughter();
    }
}
