package com.davidniu.study;

public class LabelDemo {
    public static void main(String[] args) {
      //打印质数
        outer: // 外层标签
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue outer; // 跳过外层循环的当前迭代
                }
            }
            System.out.println(i + " 是质数");
        }

        System.out.println("质数打印完毕");
    }
}
