package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/15
 * @time 10:44
 */
public class QuickSort {
    public static void main(String[] args) {
        int N = 10000;
        int[] num = sortTestHelper.generateRandom(N, 0, 10 * N);
        int[] num1 = Arrays.copyOf(num, num.length);
        int[] num2 = sortTestHelper.genetateNearlySorted(N, 10);

        sortTestHelper.testSort("com.ahscuml.sort.QuickSort", "sort", num);
    }

    public static void sort(int[] num) {
        quickSort(num, 0, num.length - 1);
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] num, int left, int right) {
        if (left > right) {
            return;
        }
        int v = num[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (num[i] < v) {
                j++;
                swap(num, j, i);
            }
        }
        swap(num, left, j);

        // 递归
        quickSort(num, left, j - 1);
        quickSort(num, j + 1, right);
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
