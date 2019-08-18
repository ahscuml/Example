package com.ahscuml.util;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 19:33
 */
public class swap {
    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
