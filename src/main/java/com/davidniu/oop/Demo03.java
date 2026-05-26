package com.davidniu.oop;
//引用传递 ：对象  但是本质还是值传递
public class Demo03 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("a.name = " + a.name); // 输出 null，因为 name 没有被初始化
        change(a);
        System.out.println("a.name = " + a.name);
    }
    public static void change(A a) {
        a.name = "davidniu"; // 修改对象的属性
    }
}

class A {
    String name;
}