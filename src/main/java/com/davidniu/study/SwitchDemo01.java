package com.davidniu.study;

public class SwitchDemo01 {
    public static void main(String[] args) {
        int day = 3; // 假设今天是星期三
        String dayName;

        switch (day) {
            case 1:
                dayName = "星期一";
                break;
            case 2:
                dayName = "星期二";
                break;
            case 3:
                dayName = "星期三";
                break;
            case 4:
                dayName = "星期四";
                break;
            case 5:
                dayName = "星期五";
                break;
            case 6:
                dayName = "星期六";
                break;
            case 7:
                dayName = "星期日";
                break;
            default:
                dayName = "无效的输入";
        }

        System.out.println("今天是：" + dayName);
    }
}
