package com.davidniu.study;

import java.util.Scanner;

public class IfDemo01 {


    public static void main(String[] args) {
        // 使用Scanner类获取用户输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入考试分数
        System.out.print("请输入分数：");

        // 检查是否有下一个分数输入
        int score= scanner.nextInt();
        if (score==100) {
            System.out.println("恭喜您获得了满分！");
        } else if (score<100 && score >= 90) {
            System.out.println("恭喜您的成绩是A等！");
        } else if (score < 90 && score >= 80) {
            System.out.println("恭喜您的成绩是B等！");
        } else if (score < 80 && score >= 70) {
            System.out.println("恭喜您的成绩是C等！");
        } else if (score < 70 && score >= 60) {
            System.out.println("恭喜您的成绩是D等！");
        } else if (score < 60 && score >= 0) {
            System.out.println("很遗憾，您没有及格。");
        } else {
            System.out.println("输入的分数不合法，请输入0-100之间的整数。");
        }

        // 关闭Scanner对象
        scanner.close();
    }
}
