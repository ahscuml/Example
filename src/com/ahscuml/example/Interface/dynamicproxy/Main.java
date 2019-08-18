package com.ahscuml.example.Interface.dynamicproxy;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 0:18
 */
public class Main {
    /**
     * 先打印日志，再打印时间
     * Proxy和普通的类的区别就是它传入的是类对象
     * 利用聚合的想法，其实和继承的区别就是，聚合采用了接口的对象这种形式
     * 接口对象中，两个类实现了同一个接口，那么这两个类的对象是平等的，都可以赋给类对象
     * 但是在继承的关系中，有着明确的包含关系，所以无法交换顺序调用
     */
    public static void main(String[] args) {
        Bird bird = new Bird();
        BirdLogProxy p1 = new BirdLogProxy(bird);
        BirdTimeProxy p2 = new BirdTimeProxy(p1);

        p2.fly();
    }

    /**
     * 先打印时间，再打印日志
     * */
    /*public static void main(String[] args) {
        Bird bird = new Bird();
        BirdTimeProxy p2 = new BirdTimeProxy(bird);
        BirdLogProxy p1 = new BirdLogProxy(p2);

        p1.fly();
    }*/
}
