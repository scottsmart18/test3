package com.davidniu.study;

import java.util.Scanner;

public class IfDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       //考试分数大于等于60分就是及格，小于60分就是不及格；
        System.out.println("请输入考试分数：");
        int score = sc.nextInt();
        if (score >= 60) {
            System.out.println("恭喜你，考试及格了！");
        } else {
            System.out.println("很遗憾，考试不及格。");
        }
        sc.close();
    }

}
