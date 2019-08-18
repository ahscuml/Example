package com.ahscuml.company.Tencent.Normal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/4/5
 * @time 19:25
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[103];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        nums[n + 1] = m + 1;
        int res = 0;
        Arrays.sort(nums, 1, n + 2);
        if (nums[1] != 1) {
            System.out.println(-1);
            return;
        }
        for (int j = 2; j <= n + 1 && nums[j] <= m + 1; j++) {
            if (nums[j] - 1 <= max) {
                continue;
            }
            int t = (int) Math.ceil(1.0 * (nums[j] - 1 - max) / (nums[j - 1]));
            res += t;
            max += nums[j - 1] * t;
        }
        System.out.println(res);
    }
}
