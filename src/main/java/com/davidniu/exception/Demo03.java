package com.davidniu.exception;

public class Demo03 {

    static void test(int a) throws Demo02 {
        // 这是一个测试方法,IDEA中：alt+enter 可以快速修复异常
        if (a > 10) {
            throw new Demo02(a); // 修改参数 a 的值
        }
        System.out.println("test 方法中的 a 的值为：" + a); // 输出原始值
    }

    public static void main(String[] args) {
        try {
            test(1); // 调用 test 方法，传递一个大于 10 的值
        } catch (Demo02 e) {
            System.out.println("捕获到异常： " + e.toString()); // 捕获并处理异常
        }
        System.out.println("程序继续执行...");
    }
}
