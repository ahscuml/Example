package com.ahscuml.basic;

/**
 * @author ahscuml
 * @date 2019/3/28
 * @time 9:30
 */
public class test {
    public static void main(String[] args) {
        lambda la = (String a,String b) -> {return a + b;};
        la.test("a","b");
        System.out.println(la.lambda("a","b"));
    }
}
