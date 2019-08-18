package com.ahscuml.sort;

/**
 * @author ahscuml
 * @date 2019/3/24
 * @time 22:48
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {};
        int[] nums1 = {1,2,3,4,5,6,7,8,9};
        int[] nums2 = {1};
        System.out.println(binarySearch(nums, 0));
        System.out.println(binarySearch(nums1, 3));
        System.out.println(binarySearch(nums2, 1));
    }

    public static int binarySearch(int[] nums, int n) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        int lo = 0, high = len - 1;
        // 要考虑到长度是1的问题
        while (lo <= high) {
            int mid = (high - lo) / 2 + lo;
            if (n == nums[mid]) {
                return mid;
            } else if(n > nums[mid]) {
                lo = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
