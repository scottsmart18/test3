package com.davidniu.study;

public class ForDemo05 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 使用增强for循环遍历数组
        for (int number : numbers) {
            System.out.println("当前数字是：" + number);
        }
    }
}
