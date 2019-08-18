package com.ahscuml.dynamicprograming;

/**
 * @author ahscuml
 * @date 2018/11/28
 * @time 20:13
 */
public class Knapsack01 {
    public static void main(String[] args) {
        //花费
        int[] Cost = {1, 2, 5, 3, 10, 4};
        //物体体积
        int[] Vol = {2, 1, 3, 2, 6, 2};
        int bag = 12;
        System.out.println(knap(Cost, Vol, bag));
        // System.out.println(knapII(Cost, Vol, bag));
    }

    public static int knap(int[] cost, int[] vol, int bag) {
        // 初始化的长度要根据题意确定
        int cols = bag + 1;
        int rows = cost.length;
        int[][] dp = new int[rows][cols];


        // j是容量，i是物品，dp[i][j]是价值
        // 注意数组的起始，i和j都是从1开始的(因为数组的起始是从1开始的，这一点在初始化的时候还要注意)
        // 另外一种方法是J直接从vol[i]开始 但是这个方法到底对不对???
        for (int i = 1; i < rows; i++) {
            for (int j = vol[i]; j < cols; j++) {
                /*if (j - vol[i] >= 0) {
                    // 由于是01背包问题，每个物品只有一个，所以如果放了，后面就不能再放
                    // 所以当前的最大价值，是前一容量的最大价值(这个容量不进行操作)与放当前物品的最大价值(也就是前一容量不放当前物品的价值加上物品的价值)

                    // 也可以这么理解，多于dp[i][j]，总共有两种情况
                    // 1. 不放i,那么就是dp[i - 1][j]
                    // 2. 放i，那么就是要留出j - vol[i]的空间放i,但是由于01背包问题只可以放一个元素，所以要是dp[i - 1][j - vol[i]] + cost[i](重点是i - 1)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vol[i]] + cost[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }*/
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vol[i]] + cost[i]);
            }
        }
        // 打印dp的过程
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
                if (j == cols - 1) {
                    System.out.println(" ");
                }
            }

        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 通过一个一维数组来解决01背包问题
     */
    public static int knapII(int[] cost, int[] vol, int bag) {
        int rows = cost.length;
        int cols = bag + 1;
        int[] dp = new int[cols];
        dp[0] = 0;
        for (int i = 1; i < rows; i++) {
            // 主要不同的点在于这个背包从后面开始计算
            for (int j = cols - 1; j > 0; j--) {
                if (j - vol[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - vol[i]] + cost[i]);
                } else {
                    dp[j] = dp[j - 1];
                }
                System.out.print(dp[j] + " ");
            }
            System.out.println(" ");
        }
        return dp[cols - 1];
    }
}
