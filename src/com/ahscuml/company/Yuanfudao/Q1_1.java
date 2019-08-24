package com.ahscuml.company.Yuanfudao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/8/24
 * @time 17:08
 */
public class Q1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int count = sc.nextInt();
            int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(getRes(nums));
        }
    }

    public static int getRes(int[] nums) {
        boolean hasRole = true;
        int total = 0;
        while (hasRole) {
            int[] temp = new int[3];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    temp[index] = i;
                    index++;
                    if (index == 3) break;
                }
            }
            if (index < 3) break;
            for (int i = 0; i < 3; i++) {
                nums[temp[i]]--;
            }
            total++;
        }
        return total;
    }
}
