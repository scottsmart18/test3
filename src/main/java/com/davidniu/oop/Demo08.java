package com.davidniu.oop;

public class Demo08 {

    private int id = 10;

    public void out() {
        System.out.println("这是外部类的方法");
    }

    class inner {
        public void in() {
            System.out.println("这是内部类的方法");
        }

        public void getId() {
            // 访问外部类的成员变量,含私有的
            System.out.println("外部类的id = " + id);
        }
    }

    static class sinner {
        public void sin() {
            System.out.println("这是静态内部类的方法");
        }
    }

    public void method() {
        class D{
            public void d() {
                System.out.println("这是局部内部类的方法");
            }
        }
    }
}
//一个class文件只能有一个public类，类名和文件名必须一致
class C{
    public static void main(String[] args) {
        Demo08 demo08 = new Demo08();
        demo08.out(); // 调用外部类的方法

        Demo08.inner innerClass = demo08.new inner();
        innerClass.in(); // 调用内部类的方法
        innerClass.getId(); // 访问外部类的私有成员变量

        Demo08.sinner staticInnerClass = new Demo08.sinner();
        staticInnerClass.sin(); // 调用静态内部类的方法
    }
}
