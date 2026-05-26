package com.davidniu.reflection;

import java.lang.reflect.Method;

//分析性能问题
public class Test07 {
        public static void main(String[] args) {
            try {
                test01();
                test02();
                test03();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void test01() {
            User user = new User();
            Long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                user.getName();
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("普通方式调用getName方法的时间: " + (endTime - startTime) + "ms");
        }
        // 反射方式调用getName方法
        public static void test02() {
            try {
                Class<?> clazz = Class.forName("com.davidniu.reflection.User");
                User user = (User)clazz.getDeclaredConstructor().newInstance();
                Method method = clazz.getMethod("getName", null);
                Long startTime = System.currentTimeMillis();
                for (int i = 0; i < 100000000; i++) {
                    method.invoke(user,null);
                }
                Long endTime = System.currentTimeMillis();
                System.out.println("反射方式调用getName方法的时间: " + (endTime - startTime) + "ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 反射方式调用getName方法，关闭访问检查
        public static void test03() {
            try {
                Class clazz = Class.forName("com.davidniu.reflection.User");
                User user = (User)clazz.getDeclaredConstructor().newInstance();
                Method method = clazz.getMethod("getName", null);
                method.setAccessible(true);
                Long startTime = System.currentTimeMillis();
                for (int i = 0; i < 100000000; i++) {
                    method.invoke(user,null);
                }
                Long endTime = System.currentTimeMillis();
                System.out.println("反射方式调用getName方法（关闭访问检查）的时间: " + (endTime - startTime) + "ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
