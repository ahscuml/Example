package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/15
 * @time 10:14
 */
public class BubbleSort {
    public static void main(String[] args) {
        int N = 10000;
        int[] num = sortTestHelper.generateRandom(N, 0, 10 * N);
        int[] num1 = Arrays.copyOf(num, num.length);
        int[] num2 = sortTestHelper.genetateNearlySorted(N, 10);
        int[] num3 = new int[N];
        for (int i = 0; i < N; i++) {
            num3[i] = i;
        }
        sortTestHelper.testSort("com.ahscuml.sort.BubbleSort", "bubbleSort", num);
        sortTestHelper.testSort("com.ahscuml.sort.BubbleSort", "bubbleSortII", num1);
        // 近乎有序的数组
        sortTestHelper.testSort("com.ahscuml.sort.BubbleSort", "bubbleSortII", num2);
        // 完全有序的数组
        sortTestHelper.testSort("com.ahscuml.sort.BubbleSort", "bubbleSort", num3);
    }

    /**
     * 遍历一遍数组，交换相邻的两个元素(每一次最后一个元素可以确定)
     */
    public static void bubbleSort(int[] num) {
        int n = num.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序的优化，遍历一遍之后看是否已经有序，如果有序，直接退出。
     */
    public static void bubbleSortII(int[] num) {
        int n = num.length;
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (num[i - 1] > num[i]) {
                    swap(num, i - 1, i);
                    swapped = true;
                }
            }
            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n--;
        } while (swapped);
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
