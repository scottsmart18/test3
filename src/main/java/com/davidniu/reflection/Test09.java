package com.davidniu.reflection;

import java.lang.annotation.*;

public class Test09 {
        public static void main(String[] args) throws ClassNotFoundException {
            // 获取 Class 对象
            Class clazz = Class.forName("com.davidniu.reflection.Student");
            // 通过反射获得注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("注解: " + annotation);
            }
            // 获取注解的value的值
            TableDavid tableDavid = (TableDavid) clazz.getAnnotation(TableDavid.class);
            if (tableDavid != null) {
                String value = tableDavid.value();
                System.out.println("TableDavid 注解的 value 值: " + value);
            }
            // 获取字段上的注解
            java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                ColumnDavid columnDavid = field.getAnnotation(ColumnDavid.class);
                if (columnDavid != null) {
                    System.out.println("字段: " + field.getName());
                    System.out.println("ColumnDavid 注解的 columnNme 值: " + columnDavid.columnNme());
                    System.out.println("ColumnDavid 注解的 type 值: " + columnDavid.type());
                    System.out.println("ColumnDavid 注解的 length 值: " + columnDavid.length());
                }
            }
        }
}
@TableDavid("db_student")
class Student{
    @ColumnDavid(columnNme = "db_id", type = "int", length = 10)
    private int id;
    @ColumnDavid(columnNme = "db_name", type = "varchar", length = 50)
    private String name;
    @ColumnDavid(columnNme = "db_age", type = "int", length = 3)
    private int age;

    public Student() {
        // 无参构造器
    }
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
}
//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableDavid {
    String value();
}
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnDavid {
    String columnNme();
    String type();
    int length() default 0;
}