package com.davidniu.structure;

import java.util.Scanner;

public class Calculator {
    // 计算器类，包含加、减、乘、除四个方法
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("除数不能为零");
        }
        return (double) a / b;
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 5;
        Scanner scanner = new Scanner(System.in);
        //不断接受用户输入的两个整数，并进行加、减、乘、除运算
        switch (args.length) {
            case 2:
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
                break;
            default:
                System.out.println("请提供两个整数作为参数");
                return;
        }

        System.out.println("加法: " + calculator.add(a, b));
        System.out.println("减法: " + calculator.subtract(a, b));
        System.out.println("乘法: " + calculator.multiply(a, b));
        System.out.println("除法: " + calculator.divide(a, b));
    }
}
