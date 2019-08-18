package com.ahscuml.company.NetEase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/8/3
 * @time 14:44
 */
public class SpringQ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] number = new int[num];
        for (int i = 0; i < num; i++) {
            number[i] = sc.nextInt();
        }
        int count1 = 0, count2 = 0, count3 = 0;
        for (int i = 0; i < num; i++) {
            int temp = number[i];
            if (temp == 0) {
                count1++;
            }
            if (temp % 2 == 0) {
                count2++;
            } else {
                count3++;
            }
        }
        int[] arrayA = new int[count2];
        int[] arrayB = new int[count3];
        int indexA = 0, indexB = 0;
        for (int i = 0; i < num; i++) {
            int temp = number[i];
            if (temp % 2 == 0) {
                arrayA[indexA++] = temp;
            } else {
                arrayB[indexB++] = temp;
            }
        }
        if (arrayA.length == 0) {
            for (int i = 0; i < arrayB.length; i++) {
                System.out.print(arrayB[i] + " ");
            }
        } else if (arrayB.length == 0) {
            for (int i = 0; i < arrayA.length; i++) {
                System.out.print(arrayA[i] + " ");
            }
        } else {
            Arrays.sort(number);
            for (int i = 0; i < number.length; i++) {
                System.out.print(number[i] + " ");
            }
        }
    }
}
