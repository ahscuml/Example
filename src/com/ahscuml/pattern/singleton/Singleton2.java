package com.ahscuml.pattern.singleton;

/**
 * @author ahscuml
 * @date 2019/3/8
 * @time 16:13
 */
public class Singleton2 {
    /**
     * 通过静态代码块来完成初始化，优缺点和第一个一样
     * 不推荐
     */
    private static Singleton2 singleton2;

    static {
        singleton2 = new Singleton2();
    }

    private Singleton2() {
    }

    public Singleton2 getSingleton2() {
        return singleton2;
    }
}
