package com.ahscuml.sort;

import com.ahscuml.util.sortTestHelper;

import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 15:52
 */
public class test {
    public static void main(String[] args) {
        int N = 10000;
        int[] num = sortTestHelper.generateRandom(N, 0, N);
        int[] num1 = Arrays.copyOf(num, num.length);
        int[] num2 = Arrays.copyOf(num, num.length);
        int[] num3 = Arrays.copyOf(num, num.length);
        sortTestHelper.testSort("com.ahscuml.sort.test", "bubble", num);
        sortTestHelper.testSort("com.ahscuml.sort.test", "bubbleIV", num1);
        sortTestHelper.testSort("com.ahscuml.sort.test", "mergeSort", num2);
        sortTestHelper.testSort("com.ahscuml.sort.test", "quickSort", num3);
    }

    public static void bubble(int[] num) {
        int n = num.length;

        for (int j = 1; j < n; j++) {
            boolean isSorted = true;
            for (int i = 0; i < n - j; i++) {
                if (num[i] > num[i + 1]) {
                    isSorted = false;
                    int temp = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = temp;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void bubbleII(int[] num) {
        int n = num.length;
        boolean swaped = false;
        do {
            swaped = false;
            for (int i = 1; i < n; i++) {
                if (num[i] < num[i - 1]) {
                    int temp = num[i];
                    num[i] = num[i - 1];
                    num[i - 1] = temp;
                    swaped = true;
                }
            }
            n--;
        } while (swaped);
    }

    public static void bubbleIV(int[] nums) {
        int n = nums.length;
        boolean isSwaped = false;
        do {
            isSwaped = false;
            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) {
                    isSwaped = true;
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
            n--;
        } while (isSwaped);
    }

    public static void mergeSort(int[] num) {
        sortS(num, 0, num.length - 1);
    }

    public static void merge(int[] num, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(num, left, right + 1);
        int i = 0, j = mid - left + 1, k = left;
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

    public static void sort(int[] num, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(num, left, mid);
            sort(num, mid + 1, right);
            merge(num, left, mid, right);
        }
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int j = left;
        int v = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < v) {
                j++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[j];
        nums[j] = v;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);

    }

    public static void mergeS(int[] nums, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);
        int i = 0, j = mid - left + 1, k = left;
        while (i <= mid - left && j < right - left) {
            if (temp[i] < temp[j]) {
                nums[k++] = nums[i++];
            } else {
                nums[k++] = nums[j++];
            }
        }
        while (i <= mid - left) {
            nums[k++] = nums[i++];
        }
        while (j <= right - left) {
            nums[k++] = nums[j++];
        }
    }

    public static void sortS(int[] nums, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (left < right) {
            sortS(nums, left, mid);
            sortS(nums, mid + 1, right);
            mergeS(nums, left, mid, right);
        }
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
     * 堆排序，下标从0开始, 按照最大堆来进行排序
     *
     * @param arr 数组
     * @param r   右边排序的边界
     */
    public void heapSort(int[] arr, int r) {
        if (r == 1) {
            return;
        }
        // 针对数组进行建堆的操作
        int temp = arr[0];
        for (int i = (r - 1) / 2; i >= 1; i--) {

        }
        // 针对建堆完成的数组进行数值的交换
    }
}