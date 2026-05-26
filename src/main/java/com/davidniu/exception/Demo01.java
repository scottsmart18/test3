package com.davidniu.exception;

public class Demo01 {

    public static void main(String[] args) {
        // 1. 创建一个整数数组
        int[] numbers = {1, 2, 3, 4, 5};

        // 2. 尝试访问一个超出范围的索引
        try {
            System.out.println(numbers[5]); // 这将抛出 ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("发生异常: " + e.getMessage());
        }

        // 3. 打印结束语
        System.out.println("程序结束");
        // new Demo01().a();
        System.out.println(11/0);
    }

    public void a(){
        b();
    }
    public void b(){
        a();
    }
}
