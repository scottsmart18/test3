package com.davidniu.exception;

public class Demo02 extends Exception {
    private int detail;

    // 自定义异常类Demo02，继承自Exception类
    public Demo02(int a) {
        // super(); // 调用父类的构造方法
        detail = a;
    }

    public Demo02(String message) {
        super(message); // 调用父类的构造方法，并传入异常信息
    }

    @Override
    public String toString() {
        return "My Exception { detail =" + detail+'}'; // 重写toString方法，返回异常信息
    }

}
