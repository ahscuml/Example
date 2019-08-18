package com.ahscuml.example.Interface.dynamicproxy;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 0:09
 */
public class Bird3 implements Flyable {
    private Bird bird;

    public Bird3(Bird bird) {
        // 形参与成员重名，用this
        this.bird = bird;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        bird.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}