package com.davidniu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//通过反射，动态地获得对象
public class Test06 {
        public static void main(String[] args) throws ClassNotFoundException {
            Class c1 = Class.forName("com.davidniu.reflection.User");
            System.out.println(c1);
            //通过反射，动态地获得对象
            try {
                Object obj = c1.newInstance();
                User user = (User) obj;
                System.out.println(user);
                //通过构造器创建对象
                Constructor declaredConstructor = c1.getDeclaredConstructor(int.class, String.class, int.class);
                User user2 = (User)declaredConstructor.newInstance(1, "张三", 20);
                System.out.println(user2);
                //通过反射调用普通方法
                User user3 = (User) c1.newInstance();
                c1.getMethod("setName", String.class).invoke(user3, "李四");
                System.out.println(user3.getName());
                //通过反射调用属性
                User user4 = (User) c1.newInstance();

                Field age = c1.getDeclaredField("age");
                age.setAccessible(true);//暴力反射，解除私有限定
                age.set(user4, 30);
                System.out.println(user4.getAge());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
