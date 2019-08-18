package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/12
 * @time 20:30
 */
public class InsertionSort {
    public static void main(String[] args) {
        final int N = 10000;
        int[] num = sortTestHelper.generateRandom(N, 0, N * 10);
        int[] num2 = Arrays.copyOf(num, num.length);
        sortTestHelper.testSort("com.ahscuml.sort.InsertionSort", "insertionSort", num);
        sortTestHelper.testSort("com.ahscuml.sort.InsertionSort", "insertionSortII", num2);
        int[] num3 = sortTestHelper.genetateNearlySorted(N, 10);
        // 近乎有序的数组
        sortTestHelper.testSort("com.ahscuml.sort.InsertionSort", "insertionSort", num3);
    }

    /**
     * 插入排序算法
     * 每次交换相邻的两个元素
     */
    public static void insertionSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j > 0; j--) {
                if (num[j] < num[j - 1]) {
                    int temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 对插入排序的优化，先将要排序的那个元素移动出来，保存到temp中，并不交换，直到找到自己应该存放的位置
     */
    public static void insertionSortII(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int temp = num[i];
            int j = i;
            for (; j > 0; j--) {
                if (temp < num[j - 1])
                    num[j] = num[j - 1];
                else
                    break;
            }
            num[j] = temp;
        }
    }
}
