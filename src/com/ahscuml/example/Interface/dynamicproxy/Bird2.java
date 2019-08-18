package com.ahscuml.example.Interface.dynamicproxy;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 0:03
 */
public class Bird2 extends Bird {
    /**
     * 如果Bird是源码，无法修改
     * 同样目标是记录时间差，继承可以实现这个功能
     * */
    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        super.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}