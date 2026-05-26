package com.davidniu.structure;

public class Demo03 {
    public static void main(String[] args) {
             Demo03 d3 = new Demo03();
             d3.test(2);

    }

    public void test(int... i) {
        // 这是一个测试方法
        System.out.println("i"+i[0]);
        printMax(1,2,3,25,5,6,7,8,9,10);
        printMax();
    }

    public static void printMax(double... nums) {
        // 这是一个测试方法
        if (nums.length == 0) {
            System.out.println("你没有输入参数");
        }
        double result = nums[0];
        for (double num : nums) {
            if (num > result) {
                result = num;
            }
        }
        System.out.println("最大数是"+result);
    }
}
