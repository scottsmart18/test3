package com.davidniu.structure;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("结果"+f(4));
    }
    //2! 2*1
    //3! 3*2*1
    public static int f(int i) {
        if(i==1){
            return 1;// 这是一个测试方法
        } else{
            return i * f(i - 1); // 递归调用
        }

    }
}
