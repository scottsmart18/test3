package com.davidniu.exception;

public class Test2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {
            new Test2().test(a, b); // 调用 test 方法，传递 a 和 b 的值
        } catch (ArithmeticException e) {
                e.printStackTrace();
        }
       /*
        // ctrl+alt+t,自动包裹
        try {
            if (b == 0) {
                throw new ArithmeticException("除数不能为0"); // 手动抛出异常
            }
            System.out.println("a/b = "+ a/b); // 这行代码会抛出异常，因为除数为0
        } catch (Exception e) {
            e.printStackTrace();//打印错误的栈信息
            //System.exit(1);
        } finally {
        }*/
    }

    public void test(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("除数不能为0"); // 手动抛出异常
        }
        System.out.println("a/b = " + a / b); // 这行代码会抛出异常，因为除数为0
    }
}
