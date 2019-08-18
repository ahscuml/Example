package com.ahscuml.company.ByteDance;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 10:12
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int minIndex = 0;
            int[] number = new int[num];
            // 找到最小值的下标
            for (int j = 0; j < num; j++) {
                number[j] = sc.nextInt();
                if (number[j] < number[minIndex]) {
                    minIndex = j;
                }
            }
            int res = 0;
            int[] count = new int[num];
            count[minIndex] = 1;

            // 从最小的开始找
            for (int j = minIndex; j < minIndex + num; j++) {
                int index = (j) % num;
                if (number[index] > number[(num + j - 1) % num]) {
                    count[index] = count[(num + j - 1) % num] + 1;
                } else {
                    count[index] = 1;
                }
                if (j == (minIndex + num - 1) % num) {
                    if (number[index] > number[(j + 1) % num]) {
                        count[index] = Math.min(count[(num + j - 1) % num], count[j + 1] % num) + 1;
                    }
                }
                res += count[index];
            }
            System.out.println(res);
        }
    }
}
