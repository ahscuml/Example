package com.ahscuml.spring;

/**
 * @author ahscuml
 * @date 2019/5/10
 * @time 18:39
 */
public class Student implements Person {
    private String name;

    // 构造函数
    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void Study(Lesson lesson) {
        System.out.println(name + lesson.getName());
    }

    @Override
    public void Sleep() {
        System.out.println(name + " 睡觉");
    }

    @Override
    public void Eat(Food food) {
        System.out.println(name + " 吃 " + food.getName());
    }
}
