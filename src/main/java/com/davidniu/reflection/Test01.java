package com.davidniu.reflection;

public class Test01  extends Object{
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("com.davidniu.reflection.User");
        Class c2 = Class.forName("com.davidniu.reflection.User");
        Class c3 = Class.forName("com.davidniu.reflection.User");
        Class c4 = Class.forName("com.davidniu.reflection.User");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        User u1 = null;
        try {
            u1 = (User)c1.getDeclaredConstructor().newInstance();
            u1.setId(1);
            u1.setName("David");
            u1.setAge(30);
            System.out.println(u1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class User {
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void test() {
        System.out.println(" private test");
    }



    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age +"', id=" +id+ "}";
    }
}