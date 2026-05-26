package com.davidniu.oop;

public class Person {
    private String name;//encapsulation
    private int age;
    private String gender;

    public void sayHello() {
           System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        System.out.println("Person() constructor called");
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age,String sex) {
        this.name = name;
        this.age = age;
        this.gender = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String s)  {
        this.gender = s;
    }

    @Override
    public String toString() {
        char c = '}';
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +" sex="+gender+
                '}';
    };


}

