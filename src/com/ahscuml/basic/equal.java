package com.ahscuml.basic;

/**
 * 只有一个等号的作用
 *
 * @author ahscuml
 * @date 2019/3/7
 * @time 16:34
 */
public class equal {
    public static void main(String[] args) {
        Boolean flag = false;
        System.out.println(flag = true);
        System.out.println(flag = false);
        // 只有一个等号
        if (flag = false) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(flag = true);
        System.out.println(flag = false);
    }
}
