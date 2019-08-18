package com.ahscuml.company.s360;

import java.util.*;

/**
 * 一堆小胖子N，坐M个椅子，求最小淘气值的最大值。
 * @author ahscuml
 * @date 2019/3/7
 * @time 19:35
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] num = new int[N];
        int i = 0;
        while (in.hasNext()) {
            num[i] = in.nextInt();
            i++;
        }
        System.out.println(find(N,M,num));
    }

    public static int find(int N, int M, int[] num) {
        Arrays.sort(num);
        int res = 0;
        if(N < M) {
            res = 0;
        } else {
            int left = 0, right = 2 * (N - M) - 1;
            while(left < right) {
                res = Math.max(num[left] + num[right], res);

            }
        }
        return res;
    }
}
