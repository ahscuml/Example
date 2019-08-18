package com.ahscuml.dynamicprograming;

/**
 * @author ahscuml
 * @date 2019/4/2
 * @time 23:22
 */
public class KnapsackAll {
    /**
     * 测试函数，花费和背包第一项都是0，否则还需要对后面进行处理
     */
    public static void main(String[] args) {
        //花费
        int[] Cost = {0, 2, 5, 3, 10, 4};
        //物体体积
        int[] Vol = {0, 1, 3, 2, 6, 2};
        int bag = 12;
        System.out.println(knap(Cost, Vol, bag));
        System.out.println(knapII(Cost, Vol, bag));
    }

    /**
     * 通过二维数组来实现这个想法
     */
    public static int knap(int[] cost, int[] vol, int bag) {
        int cols = bag + 1;
        int rows = cost.length;
        int[][] dp = new int[rows][cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (j >= vol[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - vol[i]] + cost[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 通过一维数组来解决这个问题
     * */
    public static int knapII(int[] cost, int[] vol, int bag) {
        int[] dp = new int[bag + 1];
        // 注意完全背包问题的遍历顺序是顺序遍历的，都是从1开始的
        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < bag + 1; j++) {
                if (j >= vol[i]) {
                    // 注意递推关系式不再是dp[j - 1],因为采用一维数组，上一层的dp[j - 1],在一维数组里就是dp[j]
                    dp[j] = Math.max(dp[j], dp[j - vol[i]] + cost[i]);
                } else {
                    // 这里和上面同样的问题，也要注意
                    dp[j] = dp[j];
                }
                System.out.print(dp[j] + " ");
            }
            System.out.println(" ");
        }
        return dp[bag];
    }
}
