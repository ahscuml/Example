package com.ahscuml.company.ZhaoShangBank;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/17
 * @time 20:10
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int total = 0;
        for(int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            min = Math.min(min,cur);
            total += cur;
        }
        if((total - n * min) % k == 0) {
            System.out.println((total - n * min) / k);
        } else {
            System.out.println((total - n * min) / k + 1);
        }
    }
}
