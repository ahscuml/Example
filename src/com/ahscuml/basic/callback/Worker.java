package com.ahscuml.basic.callback;

/**
 * @author ahscuml
 * @date 2019/3/30
 * @time 11:08
 */
public class Worker implements Calculator {
    private String name = null;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void fillBlank(int a, int b) {
        System.out.println("callback: " + a + " + " + b + " = " + calculate(a, b, this));
    }

    @Override
    public int calculate(int a, int b, Calculator calculator) {
        return a + b;
    }
}
