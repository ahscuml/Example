package com.ahscuml.spring;

import org.springframework.stereotype.Component;

/**
 * @author ahscuml
 * @date 2019/5/10
 * @time 18:29
 */
@Component
public class Lesson {
    private String name;

    Lesson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
