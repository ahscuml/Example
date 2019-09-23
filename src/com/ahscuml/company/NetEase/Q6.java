package com.ahscuml.company.NetEase;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/9/21
 * @time 16:06
 */
public class Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] > num[i]) {
                    res += i - j;
                }
            }
        }
        System.out.println(res);
    }
}
