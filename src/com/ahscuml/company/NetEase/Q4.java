package com.ahscuml.company.NetEase;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/9/21
 * @time 15:28
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long p = scanner.nextLong();
            int q = scanner.nextInt();
            int res = 0;
            while (A + p < B) {
                res += 1;
                p *= q;
            }
            System.out.println(res);
        }
    }
}
