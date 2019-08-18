package com.ahscuml.company.s360;

import java.util.Scanner;

/**
 * 求知道所有元素值的最小的花费
 *
 * @author ahscuml
 * @date 2019/3/7
 * @time 20:19
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] num = new int[N][N];
        int i = 0, j = 0, k = N;
        while (in.hasNext()) {
            if (i < N) {
                num[i][j] = in.nextInt();
                i++;
            } else {
                k--;
                i = N - k;
                j++;
            }

        }
        System.out.println(find(N, num));
    }

    public static int find(int N, int[][] num) {
        int temp = Integer.MAX_VALUE;
        int res1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                temp = Math.min(temp, num[i][j]);
            }
            res1 += temp;
            temp = Integer.MAX_VALUE;
        }
        temp = Integer.MAX_VALUE;
        int res2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                temp = Math.min(temp, num[j][i]);
            }
            res2 += temp;
            temp = Integer.MAX_VALUE;
        }
        return Math.min(res1, res2);
    }
}
