package com.ahscuml.company.Kuaishou;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/30
 * @time 20:37
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1)
                count++;
            n /= 2;
        }
        System.out.println(count);
    }
}
