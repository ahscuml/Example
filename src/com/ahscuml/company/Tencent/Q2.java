package com.ahscuml.company.Tencent;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/10
 * @time 19:31
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
        }
    }

    //public static int res(int[] array) {
    //    int res = 0;
    //
    //}
}
