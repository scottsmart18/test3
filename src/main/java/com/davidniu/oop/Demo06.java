package com.davidniu.oop;

public abstract class Demo06 {

    private String name = "默认名称";

    // 抽象类的构造器
    public Demo06() {
        System.out.println("Demonstrate 构造器被调用，name = " + name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void doSomeThing() {
        // 抽象方法可以有默认实现 ;
        System.out.println("默认实现的 doSomeThing 方法");
        }
    public abstract void doOtherThing(); // 抽象方法，没有实现


}