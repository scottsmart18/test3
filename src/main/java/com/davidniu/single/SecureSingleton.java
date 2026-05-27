package com.davidniu.single;

import java.lang.reflect.Constructor;

/**
 * 演示不同场景下的枚举单例
 */
public enum SecureSingleton {

    INSTANCE;

    // 模拟你代码中的 flag 和懒加载逻辑
    private volatile boolean flag = false;
    private volatile String data;

    // 枚举构造器（只会执行一次）
    SecureSingleton() {
        System.out.println("枚举构造器执行 - 天然线程安全");
        init();
    }

    private void init() {
        synchronized (SecureSingleton.class) {
            if (!flag) {
                flag = true;
                data = "initialized";
                System.out.println("初始化完成，flag=" + flag);
            }
        }
    }

    // 你的业务方法
    public void process() {
        System.out.println(Thread.currentThread().getName() + " 处理业务，data=" + data);
    }

    // 防止反射攻击（枚举天然防止，这里只是演示）
    public static void preventReflection() {
        try {
            // 枚举类没有无参构造器，反射无法创建新实例
            Constructor<?>[] constructors = SecureSingleton.class.getDeclaredConstructors();
            System.out.println("枚举类构造器数量：" + constructors.length);
            for (Constructor<?> constructor : constructors) {
                System.out.println("构造器参数类型：" + java.util.Arrays.toString(constructor.getParameterTypes()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 正常获取 ==========");
        SecureSingleton instance1 = SecureSingleton.INSTANCE;
        SecureSingleton instance2 = SecureSingleton.INSTANCE;
        System.out.println("是否单例: " + (instance1 == instance2));

        System.out.println("\n========== 多线程测试 ==========");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SecureSingleton.INSTANCE.process();
            }, "Thread-" + i).start();
        }

        System.out.println("\n========== 反射攻击测试 ==========");
        preventReflection();

        try {
            // 尝试反射创建（会失败）
            Constructor<SecureSingleton> constructor = SecureSingleton.class.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            SecureSingleton newInstance = constructor.newInstance("ATTACK", 1);
            System.out.println("反射创建成功（不应该执行到这行）");
        } catch (Exception e) {
            System.out.println("✅ 反射攻击被阻止：" + e.getClass().getSimpleName());
            System.out.println("   原因：" + e.getMessage());
        }

        System.out.println("\n========== 序列化测试 ==========");
        try {
            // 序列化
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
            oos.writeObject(SecureSingleton.INSTANCE);
            oos.close();

            // 反序列化
            java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
            SecureSingleton deserialized = (SecureSingleton) ois.readObject();
            ois.close();

            System.out.println("原始实例：" + SecureSingleton.INSTANCE.hashCode());
            System.out.println("反序列化实例：" + deserialized.hashCode());
            System.out.println("✅ 同一个实例：" + (SecureSingleton.INSTANCE == deserialized));
        } catch (Exception e) {
            System.out.println("序列化测试失败：" + e.getMessage());
        }
    }
}
