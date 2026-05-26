package com.davidniu.exception;

public class test {

    public static void main(String[] args) {
        int a=1;
        int b = 0;
        try{
            //System.out.println(a/b);
        new test().a();


        } catch (ArithmeticException e) {
            // 捕获运行时异常;
            System.out.println("发生了运行时异常：" + e.getMessage());

        } catch (Exception e) {
            // 捕获其他异常
            System.out.println("发生了其他异常：" + e.getMessage());
        } catch (Throwable e) {
            // 捕获所有错误和异常;
            System.out.println("发生了错误或异常：" + e.getMessage());
        }
        finally {
            // 无论是否发生异常，都会执行的代码块
            System.out.println("这是 finally 块，无论如何都会执行。");
        }
    }
    public void a(){b();}
    public void b(){a();}

    }

