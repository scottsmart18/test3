package com.davidniu.oop;

import com.davidniu.study.Father;

public class Application {

    public static void main(String[] args) {
        /*
        Student xiaoming = new Student();
    Student xiaohong = new Student();
    xiaoming.setName("xiaoming");
    xiaoming.setAge(18);
    xiaohong.setName("xiaohong");
    xiaohong.setAge(20);
    System.out.println("学生姓名：" + xiaoming.getName() + "，年龄：" + xiaoming.getAge());
    System.out.println("学生姓名：" + xiaohong.getName() + "，年龄：" + xiaohong.getAge());
    // 调用方法
    xiaoming.sayHello(); */
    //new Teacher("张三", 30);
   //new DEmo02(2);

        //重写override和静态方法没有关系,只有非静态方法才有override
        /*Son s = new Son();
        s.test();
        Father f = new Son();
        f.test();
         Object daughter  = new Daughter();
        System.out.println(daughter instanceof Daughter);
        System.out.println(daughter instanceof Father);
        System.out.println(daughter instanceof Object);
        System.out.println(daughter instanceof Son);
        System.out.println(daughter instanceof String);
        System.out.println("========================================");
        Father father = new Daughter();
        System.out.println(father instanceof Daughter);
        System.out.println(father instanceof Father);
        System.out.println(father instanceof Object);
        System.out.println(father instanceof Son);
        //System.out.println(father instanceof String); //编译报错
        System.out.println("========================================");
        Son son = new Son();
        System.out.println(son instanceof Son);
        System.out.println(son instanceof Father);
        System.out.println(son instanceof Object);
        //System.out.println(son instanceof Daughter);//编译报错
        //System.out.println(son instanceof String);//编译报错
        Father f = new Son();
        ((Son) f).go(); // 向下转型，调用 Son 类的 go 方法 */
        Demo08 d = new Demo08();
        d.out();
        Demo08.inner din = d.new inner();
        din.in();
        din.getId();
    }



}