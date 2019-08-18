package com.ahscuml.basic.callback;

/**
 * @author ahscuml
 * @date 2019/3/30
 * @time 11:08
 */
public class Student implements Calculator {
    private String name = null;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int calculate(int a, int b, Calculator calculator) {
        return a + b;
    }

    public void fillBlank(int a, int b) {
        System.out.println("callback: " + a + " + " + b + " = " + calculate(a, b, this));
    }
}
