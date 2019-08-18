package com.ahscuml.syn;

/**
 * synchronized 修饰方法时锁定的是调用该方法的对象。它并不能使调用该方法的多个对象在执行顺序上互斥。
 *
 * @author ahscuml
 * @date 2019/3/24
 * @time 19:09
 */
public class Test implements Runnable {
    private String name;
    //private static MethodSync methodSync = new MethodSync();
    private MethodSync methodSync = new MethodSync();

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Test("test 1"));
        Thread t2 = new Thread(new Test("test 2"));
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        methodSync.method(name);
    }
}
