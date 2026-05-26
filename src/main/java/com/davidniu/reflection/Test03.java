package com.davidniu.reflection;

public class Test03 {
    static{
        System.out.println("Test03的静态代码块");
    }

    public static void main(String[] args) {
        //主动引用
        //Son s = new Son();
        //反射也会产生主动引用
        /* try {
             Class.forName("com.davidniu.reflection.Son");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }*/
        //System.out.println(Son.m);
        //不会产生类的引用的方法
        //System.out.println(Son.b);
        //Son[] sons = new Son[10];
        System.out.println(Son.M);

    }
}

class Father{
    static int b =2;
    static {
        System.out.println("父类的静态代码块");
    }

}

class Son extends Father{
    static {
        System.out.println("子类的静态代码块");
        m=300;
    }

    static int m = 100;
    static final int M=1;
}
