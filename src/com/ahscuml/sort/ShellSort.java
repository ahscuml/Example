package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/13
 * @time 20:16
 */
public class ShellSort {
    public static void main(String[] args) {
        int N = 1000000;
        int[] num = sortTestHelper.generateRandom(N, 0, N * 10);
        int[] num1 = Arrays.copyOf(num, num.length);
        int[] num2 = Arrays.copyOf(num, num.length);
        sortTestHelper.testSort("com.ahscuml.sort.ShellSort", "shellSort", num);
        sortTestHelper.testSort("com.ahscuml.sort.ShellSort", "shellSortII", num1);
        sortTestHelper.testSort("com.ahscuml.sort.ShellSort", "test", num2);
    }

    /**
     * 速度稍快， h的选择不太一样
     */
    public static void shellSort(int[] num) {
        int h = 1, n = num.length;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < n; i++) {
                int temp = num[i];
                int j = i;
                for (; j >= h && temp < num[j - h]; j -= h) {
                    num[j] = num[j - h];
                }
                num[j] = temp;
            }
            h /= 3;
        }
    }

    /**
     * 速度稍慢，gap选择为2的倍数
     */
    public static void shellSortII(int[] num) {
        int j;
        for (int gap = num.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < num.length; i++) {
                int temp = num[i];
                for (j = i; j >= gap && temp < num[j - gap]; j -= gap) {
                    num[j] = num[j - gap];
                }
                num[j] = temp;
            }
        }
    }

    public static void test(int[] num) {
        int h = 1, n = num.length;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            int j;
            for (int i = h; i < n; i++) {
                int temp = num[i];
                for (j = i; j >= h && temp < num[j - h]; j -= h) {
                    num[j] = num[j - h];
                }
                num[j] = temp;
            }
            h /= 3;
        }
    }
}
