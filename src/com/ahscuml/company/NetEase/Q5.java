package com.ahscuml.company.NetEase;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/9/21
 * @time 15:39
 */
public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int res = 0;
            int[] num = new int[n];
            int[] sum = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = scanner.nextInt();
            }
            for (int end = 0; end < n; end++) {
                for (int start = 0; start < end; start++) {
                    int temp = 0;
                    sum[start] = 0;
                    int i = start;
                    while (i <= end && num[i] > sum[i]) {
                        if (i < n - 1) {
                            sum[i + 1] = sum[i] + num[i];
                        }
                        temp++;
                        i++;
                    }
                    res = Math.max(temp, res);
                    if (i == end) {
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
