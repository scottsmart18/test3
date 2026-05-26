package com.davidniu.study;

public class ContinueDemo {
    public static void main(String[] args) {
        // 使用 continue 跳过当前循环的剩余部分，直接进入下一次循环
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                // System.out.println("跳过数字 5");
                 System.out.println();
                continue; // 跳过当前循环，直接进入下一次循环
            }
            System.out.println("当前数字: " + i);
        }
        System.out.println("循环结束");
    }
}
