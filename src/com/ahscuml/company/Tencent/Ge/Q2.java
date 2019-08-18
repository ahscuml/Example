package com.ahscuml.company.Tencent.Ge;

/**
 * @author ahscuml
 * @date 2019/4/7
 * @time 20:55
 */
public class Q2 {
    public static void main(String[] args) {
        int[] nums = {5, -4, 1, -3, 1};
        System.out.println(test(5, nums));
    }

    public static int test(int n, int[] nums) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 只有小于0才进行补给,补给就是从前往后筛选，然后选出可以补给这个位置的元素
            // 选元素的时候同时更改这个值
            if (nums[i] < 0) {
                for (int j = 0; j < n; j++) {
                    if (nums[j] > 0) {
                        // 这一个村子不够
                        if (Math.abs(nums[i]) > nums[j]) {
                            res += (nums[j] * Math.abs(j - i));
                            nums[i] += nums[j];
                            nums[j] = 0;
                        } else {
                            // 这一个村子够了
                            res += (Math.abs(nums[i]) * Math.abs(j - i));
                            // 注意nums[i]是负的
                            nums[j] = nums[i] + nums[j];
                            nums[i] = 0;
                            break;
                        }
                    }
                }
            }

        }
        return res;
    }
}
