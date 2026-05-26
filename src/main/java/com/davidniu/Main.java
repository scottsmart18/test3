package com.davidniu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        //for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
          //  System.out.println("i = " + i);
        //}
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一行：");
        //int num = scanner.nextInt();
        //System.out.println("输入的数字是：" + num);
        if(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println("输入的行是：" + line);
        }
        scanner.close();
        */
        System.out.println("2^3="+Math.pow(2,3));
        System.out.println("2<<3="+(2<<3)); // 左移3位，相当于乘以2的3次方，结果是16
        System.out.println("16>>>3="+(16>>>3)); // 右移3位，相当于除以2的3次方，结果是0
        System.out.println("阶乘 = "+test(100)); // 右移3位，相当于除以2的3次方，结果是2 大递归要用BigInteger
    }

    public static int test(int i) {
        if(i==1){
            return 1;
        } else {
            int result = i*test(i-1);
            System.out.println(i + "! = " + result);
            return result;
        }
    }
}