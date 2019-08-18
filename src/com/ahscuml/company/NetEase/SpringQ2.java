package com.ahscuml.company.NetEase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/8/3
 * @time 14:44
 */
public class SpringQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            Arrays.sort(array);
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                int sum;
                if (j == 0) {
                    sum = array[1] + array[n - 1];
                    if (sum <= array[i]) {
                        flag = false;
                        break;
                    }
                }
                if (j == n - 1) {
                    sum = array[n - 2] + array[0];
                    if (sum <= array[j]) {
                        flag = false;
                        break;
                    }
                }
                if (j > 0 && j < n - 1) {
                    sum = array[j - 1] + array[j + 1];
                    if (sum <= array[j]) {
                        flag=false;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
