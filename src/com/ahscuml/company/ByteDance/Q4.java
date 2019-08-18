package com.ahscuml.company.ByteDance;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 11:16
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (sc.hasNext()) {
            int M = sc.nextInt();
            int[] num = new int[N];

            for (int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
            }
            int count = M - N;
            quickSort(num, 0, num.length - 1);
            double res;
            if (M <= N) {
                res = num[num.length - M] * 1.0;
            } else {
                res = num[num.length - count] / 2.0;
            }
            System.out.println(String.format("%.2f" , res));
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        // 递归的基准情况
        if (l >= r) {
            return;
        }
        // partion操作，移动元素，找到中值的位置
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        j--;
        // 进行递归
        quickSort(arr, l, j);
        quickSort(arr, j + 2, r);

    }

    // 交换函数
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
