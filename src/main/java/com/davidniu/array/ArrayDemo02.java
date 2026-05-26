package com.davidniu.array;

public class ArrayDemo02 {
    public static void main(String[] args) {
        // 定义一个整数数组,静态初始化，创建+赋值
        int[] numbers = {10, 20, 30, 40, 50};
        //引用类型，也是静态初始化
        Man[] men = {new Man(),new Man(),new Man(),new Man()};

        //动态初始化,包含默认初始化
        int[] nums = new int[10]; // 定义一个长度为 10 的整数数组

        // 使用 for 循环遍历数组
        System.out.println("使用 for 循环遍历数组：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("索引 " + i + ": " + numbers[i]);
        }

        // 使用增强 for 循环遍历数组
        System.out.println("\n使用增强 for 循环遍历数组：");
        for (int number : numbers) {
            System.out.println("元素: " + number);
        }
    }
}
