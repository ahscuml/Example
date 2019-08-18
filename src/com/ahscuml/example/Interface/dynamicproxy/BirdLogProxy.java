package com.ahscuml.example.Interface.dynamicproxy;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 0:15
 */

/**
 * 日志输出函数，用来输出日志
 * */
public class BirdLogProxy implements Flyable {
    /**
     * 指代一个实现了Flyable接口的类的对象
     * */
    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }
}