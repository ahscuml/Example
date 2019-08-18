package com.ahscuml.pattern.singleton;

/**
 * @author ahscuml
 * @date 2019/3/8
 * @time 16:21
 */
public class Singleton6 {
    private static volatile Singleton6 singleton;

    private Singleton6() {
    }

    /**
     * 懒汉式
     * 采用双重检查的方法
     * 既保证了同步，同时又确保了实例只被创建一次，提高效率
     */
    public static Singleton6 getInstance() {
        if (singleton == null) {
            synchronized (Singleton6.class) {
                if (singleton == null) {
                    singleton = new Singleton6();
                }
            }
        }
        return singleton;
    }
}
