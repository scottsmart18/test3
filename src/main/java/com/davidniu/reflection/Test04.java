package com.davidniu.reflection;

public class Test04 {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        //获取系统加载器的父类加载器
        ClassLoader parentClassLoader = classLoader.getParent();
        System.out.println(parentClassLoader);
        //获取系统加载器的父类加载器的父类加载器
        ClassLoader grandParentClassLoader = parentClassLoader.getParent();
        System.out.println(grandParentClassLoader);

        //测试当前类是哪个加载器加载的
        ClassLoader testClassLoader = Test04.class.getClassLoader();
        System.out.println(testClassLoader);

        try {
            ClassLoader loader = Class.forName("java.lang.Object").getClassLoader();
            System.out.println(loader);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //如何获得系统类加载器可以加载的路径
            String classpath = System.getProperty("java.class.path");
            System.out.println(classpath);
    }
}
