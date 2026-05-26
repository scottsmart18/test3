package com.davidniu.array;

import java.util.Arrays;

public class ArrayDemo06 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 11,18,5, 6, 7, 8, 9};
        Arrays.sort(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println("排序前的数组：" + Arrays.toString(arr));
        // 使用Arrays.sort()方法对数组进行排序
        Arrays.sort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));

    }
}
