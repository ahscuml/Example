/*
package com.ahscuml.company.ByteDance;

*/
/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 9:37
 *//*


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int x = sc.nextInt() - 1;
            long[] room = new long[n];
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                room[i] = sc.nextInt();
                if (room[i] < min)
                    min = room[i];
            }
            //get min_index
            int minIndex = x;
            while (room[minIndex] != min) {
                minIndex = minIndex > 0 ? minIndex - 1 : n - 1;
            }
            // remove the round number.
            for (int i = 0; i < n; i++) {
                room[i] -= min;
            }
            // remove the tail
            int remain = 0;
            for (int i = x; i != minIndex; i = i > 0 ? i - 1 : n - 1) {
                room[i] -= 1;
                remain += 1;
            }
            room[minIndex] += remain + n * min;
            //print the result
            for (int i = 0; i < n; i++) {
                System.out.print(room[i] + " ");
            }
        }
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        long[] room = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            room[i] = scanner.nextInt();
            if (room[i] < min)
                min = room[i];
        }
        //get min_index
        int minIndex = x;
        while (room[minIndex] != min) {
            minIndex = minIndex > 0 ? minIndex - 1 : n - 1;
        }
        // remove the round number.
        for (int i = 0; i < n; i++) {
            room[i] -= min;
        }
        // remove the tail
        int remain = 0;
        for (int i = x; i != minIndex; i = i > 0 ? i - 1 : n - 1) {
            room[i] -= 1;
            remain += 1;
        }
        room[minIndex] += remain + n * min;
        //print the result
        for (int i = 0; i < n; i++) {
            System.out.print(room[i] + " ");
        }
    }
}*/
