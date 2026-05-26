package com.davidniu.oop;

public class Demo01 {
    public static void main(String[] args) {
        // 创建一个 Person 对象
        Person person = new Person("牛力", 18, "男");

        // 调用 Person 类的方法
        //person.introduce();
        //person.haveBirthday();
        //person.introduce();
        System.out.println("姓名: " + person.getName());
        System.out.println("年龄: " + person.getAge());
        System.out.println("性别: " + person.getGender());
        System.out.println("===============================");
        System.out.println("输出person信息: " + person.toString());

    }
}
