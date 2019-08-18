package com.ahscuml.basic;

/**
 * @author ahscuml
 * @date 2019/3/28
 * @time 9:28
 */
@FunctionalInterface
public interface lambda {
    public String  lambda(String a, String b);

    public default String test(String a, String b) {
        return a + b;
    }
}

