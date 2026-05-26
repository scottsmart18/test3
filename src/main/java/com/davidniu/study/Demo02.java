package com.davidniu.study;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String str = scanner.next();
            System.out.print("输入的内容：" +str);

        }

        scanner.close();


    }
}