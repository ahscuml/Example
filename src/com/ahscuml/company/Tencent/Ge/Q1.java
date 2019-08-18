package com.ahscuml.company.Tencent.Ge;

/**
 * @author ahscuml
 * @date 2019/4/7
 * @time 19:30
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(DP(15, 4));
    }

    public static int test(int n, int p) {
        int i = 0;
        while ((int) Math.pow(2, i) < p) {

        }
        return 0;
    }

    public static int DP(int n, int p) {
        // 行是这个数，列是拆分的次数，里面的值是最小值
        int[][] dp = new int[n + 1][p + 1];
        // 数组初始化
        // 如果不能裁剪，那么就只能不断减1了
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        // 如果值是0，那么就直接返回0
        for (int j = 1; j <= p; j++) {
            dp[0][j] = 0;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                if (i == 1) {
                    dp[1][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i / 2][j - 1] + dp[i - (i / 2)][j - 1]);
                }
            }
        }
        return dp[n][p];
    }
}
