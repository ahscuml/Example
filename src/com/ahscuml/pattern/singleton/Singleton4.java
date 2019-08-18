package com.ahscuml.pattern.singleton;

/**
 * @author ahscuml
 * @date 2019/3/8
 * @time 16:15
 */
public class Singleton4 {
    /**
     * 懒汉式(不推荐)
     * 线程不安全(if null判断那里容易产生多个实例)
     */
    private static Singleton4 instance;

    private Singleton4() {
    }

    // 使用的时候才初始化
    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
