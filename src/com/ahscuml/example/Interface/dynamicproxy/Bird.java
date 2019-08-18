package com.ahscuml.example.Interface.dynamicproxy;

import java.util.Random;

/**
 * @author ahscuml
 * @date 2019/1/4
 * @time 23:48
 */

/**
 * 要做的事情就是记录小鸟飞行的时间差
 */
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
