package com.ahscuml.company.Tencent.Normal;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/4/5
 * @time 19:25
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] power = new int[n];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        // n是否等于0还要判断

        // 第一个必须买
        int res = 0, sum = 0;
        for (int num : power) {
            sum += num;
        }
        int[][] dp = new int[power.length][sum + 1];
        // 初始化
        dp[0][power[0]] = coin[0];
        for (int i = 1; i < power.length; i++) {
            for (int j = 0; j <= sum; j++) {
                // 上一个元素有值
                if (dp[i - 1][j] != 0) {
                    // 当前的力量可以直接过
                    if (j >= power[i]) {
                        // 不加钱，直接过
                        dp[i][j] = dp[i - 1][j];
                        // 或者可以加上当前的力量也能过
                        dp[i][j + power[i]] = dp[i - 1][j] + coin[i];
                    } else {
                        // 本身过不去，但是买了当前的可以过
                        dp[i][j + power[i]] = dp[i - 1][j] + coin[i];
                    }
                }
            }
        }
        for (int i = power[power.length - 1]; i <= sum; i++) {
            if (dp[power.length - 1][i] != 0) {
                if (res == 0) {
                    res = dp[power.length - 1][i];
                } else {
                    res = Math.min(res, dp[power.length - 1][i]);
                }
            }
        }
        System.out.println(res);
    }

}
