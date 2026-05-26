package com.davidniu.study;

public class ForDemo02 {
    public static void main(String[] args) {
        //分别计算0-100之间所有奇数和偶数的和
        int i = 0;
        int oddSum = 0;
        int evenSum = 0;
        // for 循环的语法：for (初始化; 条件; 更新) { 代码块 }
        for (; i <= 100; i++) {
            // sum = sum + ++i; // 每次循环后，i 的值增加 1
            if (i %2 != 0){
                oddSum += i; // 如果是奇数，累加到 oddSum
            } else {
                evenSum += i; // 如果是偶数，累加到 evenSum
            }
            System.out.println("i = " + i);
        }
        System.out.println("循环结束，oddSum 的最终值为：" + oddSum);
        System.out.println("循环结束，evenSum 的最终值为：" + evenSum);
    }
}
