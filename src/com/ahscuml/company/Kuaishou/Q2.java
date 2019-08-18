package com.ahscuml.company.Kuaishou;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/30
 * @time 20:24
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int k = sc.nextInt();
        // System.out.println(row + " " + col + " " + k);
        int[][] flag = new int[row][col];
        System.out.println(helper(0, 0, row, col, flag, k));
    }

    private static int helper(int i, int j, int row, int col, int[][] flag, int k) {
        if (i < 0 || i >= row || j < 0 || j >= col || sum(i) + sum(j) > k || flag[i][j] == 1) {
            return 0;
        }
        flag[i][j] = 1;
        return helper(i - 1, j, row, col, flag, k) + helper(i + 1, j, row, col, flag, k) + helper(i, j + 1, row, col,
                flag, k) + helper(i, j - 1, row, col, flag, k) + 1;
    }

    private static int sum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }
}
