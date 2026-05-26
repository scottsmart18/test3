package com.davidniu.oop;

public class DEmo02 {
    /*
    public static void main(String[] args) {
        int a = 1;
        //System.out.println("a 的值为：" + a); // 输出 a 的值
        //test(a); // 调用 test 方法，传递 a 的值
        //System.out.println("调用 test 方法后，a 的值仍然为：" + a); // 输出 a 的值，仍然是 1
        DEmo02 demo = new DEmo02(a); // 创建 DEmo02 的实例，传递 a 的值
    }

    public static void test(int a) {
        // 这是一个测试方法
        a=10;
    }
*/
    public DEmo02(int a) {
        // 构造方法，接收一个整数参数 a
        System.out.println("构造方法被调用，a 的值为：" + a);
    }
}
