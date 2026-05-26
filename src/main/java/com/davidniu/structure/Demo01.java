package com.davidniu.structure;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        int a = sc.nextInt();
        int b = sc.nextInt();
                sum = add(a,b);
        System.out.println("输入两数之和 = " + sum);

    }
    public static int add(int a, int b) {
        return a + b;
    }
}
