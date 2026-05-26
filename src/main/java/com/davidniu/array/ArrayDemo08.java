package com.davidniu.array;

public class ArrayDemo08 {
    public static void main(String[] args) {
        // 定义一个数组
        int[][] numbers = new int[11][11];
        numbers[1][2] = 1;
        numbers[2][3] = 2;

        // 打印numbers
        System.out.println("二维数组 numbers 的内容:");
        System.out.println("使用传统的 for 循环遍历数组:");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println(); // 换行
        }

        //转换为稀疏数组
        System.out.println("转换为稀疏数组:");
        int count = 0; // 用于计数非零元素
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] != 0) {
                    count++;
                }
            }
        }
        // 创建稀疏数组
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = numbers.length; // 原数组的行数
        sparseArray[0][1] = numbers[0].length; // 原数组的列数
        sparseArray[0][2] = count; // 非零元素的个数
        // 填充稀疏数组
        int index = 1; // 稀疏数组的索引
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] != 0) {
                    sparseArray[index][0] = i; // 行索引
                    sparseArray[index][1] = j; // 列索引
                    sparseArray[index][2] = numbers[i][j]; // 值
                    index++;
                }
            }
        }
        //打印稀疏数组
        System.out.println("稀疏数组的内容:");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(sparseArray[i][j] + " ");
            }
            System.out.println(); // 换行
        }
        // 将稀疏数组转换回原数组
        System.out.println("将稀疏数组转换回原数组:");
        int[][] originalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            int row = sparseArray[i][0]; // 行索引
            int col = sparseArray[i][1]; // 列索引
            int value = sparseArray[i][2]; // 值
            originalArray[row][col] = value; // 恢复原数组的值
        }
        // 打印恢复后的原数组
        System.out.println("恢复后的原数组内容:");
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                System.out.print(originalArray[i][j] + " ");
            }
            System.out.println(); // 换行
        }

    }
}
