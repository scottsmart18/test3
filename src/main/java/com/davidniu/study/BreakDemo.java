package com.davidniu.study;

public class BreakDemo {
    public static void main(String[] args) {
        // 使用 break 语句跳出循环
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("i 等于 5，跳出循环");
                break; // 跳出循环
            }
            System.out.println("当前 i 的值为：" + i);
        }
        System.out.println("循环结束");

        // 使用 break 语句跳出嵌套循环
        outerLoop: // 标签，用于标识外层循环
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("跳出嵌套循环");
                    break outerLoop; // 跳出外层循环
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }
        System.out.println("嵌套循环结束");
    }
}
