package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/15
 * @time 10:46
 */
public class MergeSort {
    public static void main(String[] args) {
        int N = 10000;
        int[] num = sortTestHelper.generateRandom(N, 0, 10 * N);
        int[] num1 = Arrays.copyOf(num, num.length);
        int[] num2 = sortTestHelper.genetateNearlySorted(N, 10);

        sortTestHelper.testSort("com.ahscuml.sort.MergeSort", "mergeSort", num);
        sortTestHelper.testSort("com.ahscuml.sort.MergeSort", "mergeSort", num2);
    }

    /**
     * 进行归并的过程，需要创建一个额外的数组，利用这个额外的数组来完成赋值工作
     */
    public static void merge(int[] num, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(num, left, right + 1);
        int i = 0, j = mid + 1 - left, k = left;
        while (i <= mid - left && j <= right - left) {
            if (temp[i] < temp[j]) {
                num[k++] = temp[i++];
            } else {
                num[k++] = temp[j++];
            }
        }
        while (i <= mid - left) {
            num[k++] = temp[i++];
        }
        while (j <= right - left) {
            num[k++] = temp[j++];
        }
    }

    /**
     * 排序的过程,对l到r进行排序
     */
    public static void sort(int[] num, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(num, left, mid);
            sort(num, mid + 1, right);
            merge(num, left, mid, right);
        }
    }

    public static void mergeSort(int[] num) {
        sort(num, 0, num.length - 1);
    }
}
