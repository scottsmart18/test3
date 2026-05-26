package com.davidniu.oop;

public class B extends Demo06 {

    // 抽象类的子类必须实现父类的抽象方法，除非子类也是抽象类
    @Override
    //抽象类的子类必须实现父类的抽象方法，除非子类也是抽象类
    public void doOtherThing() {
        System.out.println("Doing other thing in class B");
    }

public static void main(String[] args) {
    // 创建 B 类的实例
    B b = new B();
    b.setName("davidniu"); // 调用父类的 setter 方法设置 name 属性
    // 调用父类的抽象方法
    b.doSomeThing();
    System.out.println(b.getName()); // 调用父类的 getter 方法获取 name 属性

    // 调用子类实现的抽象方法
    b.doOtherThing();
}


}



