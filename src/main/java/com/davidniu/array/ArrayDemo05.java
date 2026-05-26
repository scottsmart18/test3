package com.davidniu.array;

public class ArrayDemo05 {
    public static void main(String[] args) {
        //二维数组的定义和初始化
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        //遍历二维数组
        for (int i = 0; i < arr.length; i++) { // 遍历行
            for (int j = 0; j < arr[i].length; j++) { // 遍历列
                System.out.print(arr[i][j] + " "); // 打印当前元素
            }
            System.out.println(); // 换行
        }
        System.out.println("------------------");
        ArrayDemo04.printArray(arr[0]);
        System.out.println("========================");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
                           }
        }

    }
}
