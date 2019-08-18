package com.ahscuml.company.ZhaoShangBank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/17
 * @time 19:52
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] length = new int[n];
        int[] energy = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(length[i], energy[i]);
        }
        Arrays.sort(length);
        int maxLength = length[(length.length - 1) / 2];
        int res = 0;
        for (int i = (length.length - 1) / 2; i < length.length - 1; i++) {
            if (length[i] > maxLength) {
                res += map.get(length[i]);
            }
        }
    }
}
