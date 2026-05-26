package com.davidniu.study;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double sum = 0.0;
        int x= 0;
        while (sc.hasNextDouble()) {
            Double d = sc.nextDouble();
            x++;
            sum += d;
            System.out.println("你输入了第"+x+"个数据，当前结果是："+sum);
        }
        System.out.println("输入的数字个数为：" + x);
        System.out.println("输入的数字之和为：" + sum);
        System.out.println("输入的数字平均值为：" + (sum / x));
        sc.close();
    }



    }

