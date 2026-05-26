package com.davidniu.oop;

public class Teacher extends Person {

// public Teacher() {
    // 默认构造方法

   // System.out.println("Teacher 的默认构造方法被调用");
//}
    public Teacher(String name, int age) {
        // 调用父类的构造方法
        //super();
        System.out.println("Teacher 的带参数构造方法被调用");
    }


}
