package com.davidniu.study;

public class SwitchDemo03 {
    public static void main(String[] args) {
        String name = "牛力";
        switch (name) {
            case "牛力":
                System.out.println("你好，牛力！");
                break;
            case "牛二":
                System.out.println("你好，牛二！");
                break;
            case "牛三":
                System.out.println("你好，牛三！");
                break;
            default:
                System.out.println("你好，陌生人！");
                break;
        }
    }
}
