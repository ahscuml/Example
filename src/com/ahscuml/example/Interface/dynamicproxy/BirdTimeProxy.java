package com.ahscuml.example.Interface.dynamicproxy;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 0:16
 */

/**
 * 时间代理函数，用来计算小鸟飞行的时间
 */
public class BirdTimeProxy implements Flyable {
    /**
     * flyable指代实现了Flyable接口的类的对象
     */
    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        flyable.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
