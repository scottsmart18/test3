package com.davidniu.structure;

public class TestDemo {
    public static void main(String[] args) {
        // 打印三角形
        for (int i = 1; i <= 5; i++) {
            // 打印空格
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            // 打印星号
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // 换行
            System.out.println();
        }
    }
}
