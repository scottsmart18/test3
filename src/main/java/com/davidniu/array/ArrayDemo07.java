package com.davidniu.array;

public class ArrayDemo07 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 11,18,5, 6, 7, 8, 9};
        System.out.println("排序前的数组：" + java.util.Arrays.toString(arr));
        // 使用冒泡排序对数组进行排序
        bubbleSort(arr);
        System.out.println("排序后的数组：" + java.util.Arrays.toString(arr));
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // 每次外层循环开始时，假设没有交换
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // 标记为已交换
                }
            }
            // 如果没有交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }
}
