package com.davidniu.oop;


public class Test {
    public static void main(String[] args) {
        // 没有名字初始化类，不用保存实例
        new Apple().eat();
        new Service() {
            @Override
            public void hello() {
                System.out.println("Hello, World!");
            }
        }.hello(); // 匿名内部类实现接口并调用方法

        // 使用匿名内部类创建一个 Service 的实例
        Service service = new Service() {
            @Override
            public void hello() {
                System.out.println("Hello from the anonymous class!");
            }
        };
        service.hello(); // 调用匿名内部类的方法
    }


}

class Apple {
    public void eat() {
        System.out.println("吃苹果");
    }

}
interface Service {
    void hello();
}