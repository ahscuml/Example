package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/13
 * @time 0:52
 */
public class SelectionSort {
    public static void main(String[] args) {
        int N = 10000;
        int[] num = sortTestHelper.generateRandom(N, 0, N * 10);
        int[] num1 = Arrays.copyOf(num, num.length);
        int[] num2 = sortTestHelper.genetateNearlySorted(N, 10);
        sortTestHelper.testSort("com.ahscuml.sort.SelectionSort", "selectionSort", num);
        sortTestHelper.testSort("com.ahscuml.sort.SelectionSort", "selectionSortIII", num1);
    }

    public static void selectionSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[swapIndex]) {
                    swapIndex = j;
                }
            }
            if (swapIndex != i) {
                int temp = num[swapIndex];
                num[swapIndex] = num[i];
                num[i] = temp;
            }
        }
    }

    /**
     * 对于选择排序的优化，一次遍历可以确定最大和最小两个值,因为判断，交换过程，时间并没有减少多少
     */
    public static void selectionSortII(int[] num) {
        int right = num.length - 1;
        int left = 0;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            if (num[minIndex] > num[maxIndex]) {
                swap(num, minIndex, maxIndex);
            }
            for (int i = left + 1; i < right; i++) {
                if (num[i] < num[minIndex]) {
                    minIndex = i;
                } else if (num[i] > num[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(num, left, minIndex);
            swap(num, right, maxIndex);
            right--;
            left++;
        }
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void selectionSortIII(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
}
