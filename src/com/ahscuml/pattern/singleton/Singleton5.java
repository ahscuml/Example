package com.ahscuml.pattern.singleton;

/**
 * @author ahscuml
 * @date 2019/3/8
 * @time 16:19
 */
public class Singleton5 {

    private static Singleton5 singleton;

    private Singleton5() {
    }

    /**
     * 懒汉，增加了线程安全的synchronized
     * 但是每一次获取实例都要加锁，降低了效率，其实实例只要创建一次就好了
     */
    public static synchronized Singleton5 getInstance() {
        if (singleton == null) {
            singleton = new Singleton5();
        }
        return singleton;
    }
}
