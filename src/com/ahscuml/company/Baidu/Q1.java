package com.ahscuml.company.Baidu;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/9/17
 * @time 18:48
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();
        if ((m * n - k ) % m ==0) {
            System.out.println((m * n - k) / m);
        } else {
            System.out.println(((m * n - k) / m) + 1);
        }
    }
}
