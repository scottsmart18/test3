package com.davidniu.oop;

public interface Demo07 {
    int age = 18; // 接口中的常量，默认是 public static final 的
    String name = "牛力"; // 接口中的常量，默认是 public static final 的


    //void doSomething();
    //String getName();
    //int getAge();

    // 接口中的方法默认是 public abstract 的，不需要显式声明
    void add(int a, int b);
    void delete(int id);
    void update(int id, String name);
    void find(int id);

}
