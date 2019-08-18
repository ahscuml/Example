package com.ahscuml.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ahscuml
 * @date 2019/5/10
 * @time 18:37
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = (Student) context.getBean("ming");
        Food food = (Food) context.getBean("baicai");
        student.Eat(food);
    }
}
