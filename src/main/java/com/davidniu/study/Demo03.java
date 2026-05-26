package com.davidniu.study;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.print("输入的内容为：" + str);
        }
        scanner.close();
    }
}
