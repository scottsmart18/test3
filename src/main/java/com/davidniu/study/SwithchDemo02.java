package com.davidniu.study;

public class SwithchDemo02 {
    public static void main(String[] args) {
        int month = 2; // 假设月份为2月
        String season;

        switch (month) {
            case 12: case 1: case 2:
                season = "冬季";
                break;
            case 3: case 4: case 5:
                season = "春季";
                break;
            case 6: case 7: case 8:
                season = "夏季";
                break;
            case 9: case 10: case 11:
                season = "秋季";
                break;
            default:
                season = "未知季节";
        }

        System.out.println("月份：" + month + " 对应的季节是：" + season);
    }
}
