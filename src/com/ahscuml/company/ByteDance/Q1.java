package com.ahscuml.company.ByteDance;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 9:26
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int res = 0;
            int num = sc.nextInt();
            int leave = 1024 - num;
            if (leave != 0) {
                if (leave > 64) {
                    res += leave / 64;
                    leave = leave % 64;
                }
                if (leave > 16) {
                    res += leave / 16;
                    leave = leave % 16;
                }
                if (leave > 4) {
                    res += leave / 4;
                    leave = leave % 4;
                }
                if (leave > 1) {
                    res += leave / 1;
                    leave = leave % 64;
                }
            }
            System.out.println(res);
        }
    }
}
