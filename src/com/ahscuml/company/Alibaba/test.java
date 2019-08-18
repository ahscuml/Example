package com.ahscuml.company.Alibaba;

import java.util.ArrayDeque;
import java.util.EmptyStackException;

/**
 * @author ahscuml
 * @date 2019/4/19
 * @time 14:50
 */
public class test<T> {
    ArrayDeque<T> s1 = new ArrayDeque<>();
    ArrayDeque<T> s2 = new ArrayDeque<>();

    public void push(T val) {
        s1.push(val);
    }

    public T pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            throw new EmptyStackException();
        }
        return s2.pop();
    }
}
