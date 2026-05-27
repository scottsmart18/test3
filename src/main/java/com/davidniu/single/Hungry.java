package com.davidniu.single;
// 饿汉式单例模式
public class Hungry {

    private static final Hungry HUNGRY = new Hungry();

    private Hungry() {
    }

    private byte[] data1 = new byte[1024 * 1024 ];
    private byte[] data2 = new byte[1024 * 1024 ];
    private byte[] data3 = new byte[1024 * 1024 ];
    private byte[] data4 = new byte[1024 * 1024 ];

    public static Hungry getInstance() {
        return HUNGRY;
    }
}
