package com.davidniu.single;

import java.lang.reflect.Constructor;

// 枚举单例 enum单例是最安全的单例模式，枚举类型的实例在类加载时就创建好了，
// 并且JVM保证了它们的唯一性和线程安全性。枚举单例还可以防止反序列化攻击，
// 因为枚举类型的实例在反序列化过程中会被重新创建，而不是从序列化数据中恢复。
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {

        return INSTANCE;
    }

}

class TestEnumSingle {
    public static void main(String[] args) {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;
        System.out.println(instance1 == instance2); // 输出 true

        try {
            Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            EnumSingle instance3 = constructor.newInstance();
            System.out.println(instance1 == instance3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}