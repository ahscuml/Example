package com.ahscuml.basic.callback;

/**
 * 回调机制实例
 * @author ahscuml
 * @date 2019/3/30
 * @time 11:09
 */
public interface Calculator {
    public int calculate(int a, int b, Calculator calculator);
}
