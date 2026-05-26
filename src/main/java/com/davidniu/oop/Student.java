package com.davidniu.oop;

public class Student extends Person {
    private String name;
    private int age;

    // 构造方法 ctr+h 打开继承树
    public Student() {
        this.name = "未知";
        this.age = 0;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println(name + " is studying.");
    }
    // Getter 方法
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter 方法
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
