package com.ahscuml.company.ZhaoShangBank;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/17
 * @time 20:49
 */
public class Q3 {
    public static void main(String[] args) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE, total = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            min = Math.min(cur, min);
            max = Math.max(cur, max);
        }
    }
}
