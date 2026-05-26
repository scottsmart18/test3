package com.davidniu.study;

public class ForDemo01 {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        // for 循环的语法：for (初始化; 条件; 更新) { 代码块 }
        for (; i < 100; i++) {
            // sum = sum + ++i; // 每次循环后，i 的值增加 1
            sum += ++i; // 每次循环后，i 的值增加 1
            System.out.println("i = " + i);
        }
        System.out.println("循环结束，i 的最终值为：" + i);
        System.out.println("循环结束，sum 的最终值为：" + sum);
    }
}
