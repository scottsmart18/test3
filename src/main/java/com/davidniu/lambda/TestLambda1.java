package com.davidniu.lambda;

public class TestLambda1 {
    static class MyClass1 implements MyInterface {
        @Override
        public void lambda() {
            System.out.println("Hello Lambda1!");
        }
    }
    public static void main(String[] args) {


        // 使用Lambda表达式创建一个Runnable对象
        // Runnable runnable = () -> System.out.println("Hello, Lambda!");

        // 启动一个线程，执行Runnable对象
        //new Thread(runnable).start();


        class MyClass2 implements MyInterface {
            @Override
            public void lambda() {
                System.out.println("Hello Lambda2!");
            }
        }
        // 使用Lambda表达式创建一个函数式接口的实例
        MyInterface myFunc = new MyClass();
        myFunc.lambda();
        myFunc= new MyClass1();
        myFunc.lambda();
        myFunc = new MyClass2();
        myFunc.lambda();
        myFunc = new MyInterface() {
            @Override
            public void lambda() {
                System.out.println("Hello Lambda3!");
            }
        };
        myFunc.lambda();
        // 使用Lambda表达式创建一个函数式接口的实例
        myFunc = () -> {System.out.println("Hello, Lambda!4");};
        myFunc.lambda();

        // 调用函数式接口的方法
        //int result = myFunc.add(5, 10);
        //System.out.println("Result: " + result);
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        int add(int a, int b);
    }
}

interface MyInterface {
    void lambda();
}
class MyClass implements MyInterface {
    @Override
    public void lambda() {
        System.out.println("Hello Lambda!");
    }
}