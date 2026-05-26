package com.davidniu.study;

import java.util.Scanner;

public class Demo04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int number = 0;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            System.out.println("您输入的整数是：" + number);
        } else {
            System.out.println("输入的不是一个有效的整数。");
        }
        System.out.print("请输入一个浮点数：");
        float floatNumber = 0.0f;
        if (scanner.hasNextFloat()) {
            floatNumber = scanner.nextFloat();
            System.out.println("您输入的浮点数是：" + floatNumber);
        } else {
            System.out.println("输入的不是一个有效的浮点数。");
        }

        scanner.close();

    }
}
