package com.davidniu.single;
//静态内部类实现单例模式
public class Holder {

    private Holder() {
    }

    private static class HolderInstance {
        private static final Holder INSTANCE = new Holder();
    }

    public static Holder getInstance() {
        return HolderInstance.INSTANCE;
    }

}
