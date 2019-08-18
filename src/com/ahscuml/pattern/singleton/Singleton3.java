package com.ahscuml.pattern.singleton;

/**
 * @author ahscuml
 * @date 2019/3/8
 * @time 16:30
 */
public class Singleton3 {
    /**
     * 饿汉式
     * 采用内部类的方法，在外部类加载的时候内部类不会加载，当调用的时候，第一次加载，同时确保了线程安全
     */
    private Singleton3() {
    }

    ;

    public Singleton3 getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private static class SingletonInstance {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
}
