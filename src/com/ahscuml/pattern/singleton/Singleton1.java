package com.ahscuml.pattern.singleton;

/**
 * 八种单例模式的写法，分为两大类，懒汉式和饿汉式
 *
 * @author ahscuml
 * @date 2019/3/8
 * @time 15:46
 */
public class Singleton1 {
    /**
     * 饿汉式(不推荐 )
     * 优点：类装载就完成实例化，避免线程同步问题
     * 缺点：如果从未使用会造成资源浪费
     */
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public Singleton1 getSingleton() {
        return INSTANCE;
    }
}
