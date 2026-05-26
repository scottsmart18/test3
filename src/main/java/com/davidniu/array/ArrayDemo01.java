package com.davidniu.array;

public class ArrayDemo01 {
    public static void main(String[] args) {
        // 定义一个整数数组
        int[] numbers = {10, 20, 30, 40, 50};
        int[] nums = new int[10]; // 定义一个长度为 10 的整数数组
         //int numbers[];均可
        int sum = 0;
        // 使用 for 循环遍历数组
        System.out.println("使用 for 循环遍历数组:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("索引 " + i + ": " + numbers[i]);
            sum += numbers[i];
             }

        System.out.println("数组元素的总和: " + sum);

        // 使用增强 for 循环遍历数组
        System.out.println("\n使用增强 for 循环遍历数组:");
        for (int number : numbers) {
            System.out.println("元素: " + number);
        }
    }

}
