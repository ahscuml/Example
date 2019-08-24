package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 20:03
 */
public class HeapSort {
    public static void main(String[] args) {
        int N = 10000;
        int[] num = sortTestHelper.generateRandom(N, 0, 10 * N);
        int[] num1 = Arrays.copyOf(num, num.length);
        int[] num2 = sortTestHelper.genetateNearlySorted(N, 10);

        sortTestHelper.testSort("com.ahscuml.sort.HeapSort", "heapSort", num);
        sortTestHelper.testSort("com.ahscuml.sort.HeapSort", "heapSort2", num);
    }

    /**
     * 优化后的shiftDown，通过赋值替代每次的交换
     * 数组下标从0开始，要明白原理，这样子方便操作。
     *
     * @param arr 要排序的数组
     * @param n   数组总长度
     * @param k   下标K的元素下移
     */
    public static void shiftDown(int[] arr, int n, int k) {
        int temp = arr[k];
        // 与左右的元素相比较，与更大的交换，没有就返回
        // 下标从0开始的话左子树是2k + 1, 右子树是(2k + 2)
        // 这个while循环的意思是如果左子树还在，就继续循环
        // 内部通过一个变量j记录左右两个子树中大的那一个，然后将这个值，赋给下标k,再把k变成j。
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j += 1;
            }
            if (temp >= arr[j]) break;
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = temp;
    }

    /**
     * 建堆和堆排序的过程合并到了一起
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 初始建堆过程，输入是一个无序数组
        // 由于是节点和自己的子树进行交换，所以要找到第一个有子树的节点，也就是最后一个元素的父节点
        // !!!关于i的值，首先最后一个元素下标是n-1,父节点是((n - 1) - 1) / 2
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        // 排序的过程利用了堆的性质，第一个元素是最大的，把第一个元素与最后一个元素交换，然后最后一个元素最大，对第一个元素进行
        // shiftDown操作，记住不包括最后一个元素，这样子逐渐完成所有的操作。
        // 最终结束的地方是i > 0
        for (int i = n - 1; i > 0; i--) {
            // 先交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            shiftDown(arr, i, 0);
        }
    }

    /**
     * 下标从1开始的堆排序
     * *//*
    public static void shiftDown(int[] nums, int n, int k) {
        int temp = nums[k];
        while (2 * k < n) {
            int j = 2 * k;
            if (j + 1 < n && nums[j + 1] > nums[j]) {
                j += 1;
            }
            if (temp >= nums[j]) break;
            nums[k] = nums[j];

            k = j;
        }
        nums[k] = temp;
    }

    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = (n - 1) / 2; i > 0; i--) {
            shiftDown(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = nums[1];
            nums[1] = nums[i];
            nums[i] = temp;
            shiftDown(nums, i, 1);
        }
    }*/
}
