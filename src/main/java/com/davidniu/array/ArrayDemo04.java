package com.davidniu.array;

public class ArrayDemo04 {
    public static void main(String[] args) {
        // 定义一个数组，包含 5 个整数
        int[] numbers = {10, 20, 30, 40, 50};

        // 使用 for 循环遍历数组
        System.out.println("使用 for 循环遍历数组：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("索引 " + i + ": " + numbers[i]);
        }

        // 使用增强的 for 循环遍历数组
        System.out.println("\n使用增强的 for 循环遍历数组：");
        for (int number : numbers) {
            System.out.println("元素: " + number);
        }
        System.out.println("===========================================");
        printArray(numbers);
        System.out.println("****************");
        printArray(reverse(numbers));
    }
    //打印数组
    public static void  printArray (int[] arr) {
        System.out.print("数组元素为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //反转数组
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // 交换元素
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] reverse(int[] arr) {
        int[] result = new int[arr.length];
        for (int i=0,j=arr.length-1;i<arr.length;i++,j--) {;
            result[j] = arr[i];
        }
        return result;
        }

}
