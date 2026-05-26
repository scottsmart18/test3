package com.davidniu.study;

public class DoWhileDemo02 {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while (i < 0) {
            System.out.println(i);
            i++; // 每次循环后，i 的值增加 1
        }
        System.out.println("===============================");
        do {
            System.out.println("i = " + i);
            i++; // 每次循环后，i 的值增加 1
        } while (i < 0);

        System.out.println("循环结束，i 的最终值为：" + i);
        System.out.println("循环结束，sum 的最终值为：" + sum);
    }
}
