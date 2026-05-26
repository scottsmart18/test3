package com.davidniu.array;

public class ArrayDemo03 {
    public static void main(String[] args) {
        // 定义一个整数数组
        int[] numbers = {10, 20, 30, 40, 50};

        // 使用 for 循环遍历数组
        System.out.println("使用 for 循环遍历数组：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("索引 " + i + " 的值是：" + numbers[i]);
        }
        //查找最大元素
        int max = numbers[0]; // 假设第一个元素是最大值
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i]; // 更新最大值
            }
        }
        System.out.println("数组中的最大值是：" + max);

        // 使用增强 for 循环遍历数组
        System.out.println("使用增强 for 循环遍历数组：");
        for (int number : numbers) {
            System.out.println("当前值是：" + number);
        }
    }
}
