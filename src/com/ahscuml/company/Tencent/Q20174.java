package com.ahscuml.company.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数组最大最小的对数
 * @author ahscuml
 * @date 2019/3/10
 * @time 10:55
 */
public class Q20174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int bigCount = 0;
        int smallCount = 1;
        int small = array[0], big = array[n - 1];
        for(int i = 0; i < n; i++) {
            if(array[i] == small) {
                smallCount++;
            }
            if(array[i] == big) {
                bigCount++;
            }
        }
        System.out.println(smallCount * bigCount);
    }
}
