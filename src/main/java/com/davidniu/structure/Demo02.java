package com.davidniu.structure;

public class Demo02 {
    public static void main(String[] args) {
        int result =0;
        result = max(10, 20); // 调用 max 方法，传入两个整数
        System.out.println("较大的数是：" + result); // 输出结果
        result = max(20, 20); // 调用 max 方法，传入两个相等的整数
        System.out.println("较大的数是：" + result); // 输出结果
    }
    public static int max(int a, int b) {
        if (a == b) {
            return 0;
        }
        return a > b ? a : b; // 返回较大的数
    }
}
