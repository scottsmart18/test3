package com.davidniu.reflection;
//获得类的信息
public class Test05 {
    public static void main(String[] args) {
        try {
            Class c1 = Class.forName("com.davidniu.reflection.User");
            User user = new User();
            c1 = user.getClass();
            //获得类的名字
            System.out.println(c1.getName());
            //获得类的简单名字
            System.out.println(c1.getSimpleName());
            //获得类的属性
            System.out.println("************");
            java.lang.reflect.Field[] fields = c1.getFields();//只能找到public属性
            for (java.lang.reflect.Field field : fields) {
                System.out.println(field);
            }
                System.out.println("************");
            java.lang.reflect.Field[] declaredFields = c1.getDeclaredFields();//可以找到所有属性
            for (java.lang.reflect.Field field : declaredFields) {
                System.out.println(field);
            }
            //获得指定属性的值
            java.lang.reflect.Field name = c1.getDeclaredField("name");
            //name.setAccessible(true);//暴力反射，解除私有限定
            System.out.println(name);
            //获得类的方法
            System.out.println("************");
            java.lang.reflect.Method[] methods = c1.getMethods();//只能找到public方法
            for (java.lang.reflect.Method method : methods) {
                System.out.println(method);
            }
                System.out.println("************");
            java.lang.reflect.Method[] declaredMethods = c1.getDeclaredMethods();//获得本类的所有方法
            for (java.lang.reflect.Method method : declaredMethods) {
                System.out.println(method);
            }
             //获得指定方法
            java.lang.reflect.Method getName = c1.getDeclaredMethod("getName", null);
            System.out.println(getName);
             //获得类的构造器
            System.out.println("************");
            java.lang.reflect.Constructor[] constructors = c1.getConstructors();//只能找到public构造器
            for (java.lang.reflect.Constructor constructor : constructors) {
                System.out.println(constructor);
            }
                System.out.println("************");
            java.lang.reflect.Constructor[] declaredConstructors = c1.getDeclaredConstructors();//获得本类的所有构造器
            for (java.lang.reflect.Constructor constructor : declaredConstructors) {
                System.out.println(constructor);
            }
             //获得指定构造器
            java.lang.reflect.Constructor declaredConstructor = c1.getDeclaredConstructor(int.class, String.class,  int.class);
            System.out.println(declaredConstructor);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
