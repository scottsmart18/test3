package com.davidniu.oop;
//静态导入包
import static java.lang.Math.random;
// 注意：在 Java 中，导入包时不能使用中文标点符号，应该使用英文标点符号。
import static java.lang.Math.PI;

public class Demo05 {

    public static void main(String[] args) {
        System.out.println("math random: " + random());
        System.out.println("math PI: " + PI);
    }
}
