package com.davidniu.study;

public class ForDemo03 {
    public static void main(String[] args) {

        int sum = 0;
        for (int i = 0; i <= 1000; i++) {

            if (i%5 == 0) {
                System.out.print(i +"\t");
            }
            if (i%(5*3) == 0) {
                //System.out.println();//换行
                System.out.print("\n");//换行
            }
        }
        System.out.print("\n");//换行
        System.out.println("循环结束");
    }
}
