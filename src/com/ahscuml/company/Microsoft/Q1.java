package com.ahscuml.company.Microsoft;

/**
 * @author ahscuml
 * @date 2019/4/3
 * @time 21:44
 */
public class Q1 {
    public static void main(String[] args) {
        int input1 = 5, input2 = 2, input3 = 2;
        System.out.println(test(input1, input2, input3));
    }

    public static int test(int input1, int input2, int input3) {
        int[][] dp = new int[input3 + 1][input1 + 1];
        dp[0][input2] = 1;
        for (int i = 0; i < input3; i++) {
            for (int j = 1; j <= input1; j++) {
                if (dp[i][j] != 0) {
                    for (int k = 1; k <= input1; k++) {
                        if (k != j && (k % j == 0 || j % k == 0)) {
                            dp[i + 1][k] += dp[i][j];
                        }
                    }
                }
                 System.out.print(dp[i][j] + " ");
            }
             System.out.println(" ");
        }
        for (int j = 1; j <= input1; j++) {
            System.out.print(dp[input3][j] + " ");
        }
        System.out.println(" ");
        int res = 0;
        for (int i = 1; i <= input3; i++) {
            res += dp[i][input2];
        }
        return res;
    }
}
