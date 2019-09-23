package com.ahscuml.company.Baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/9/17
 * @time 20:05
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int T = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> list1 = new ArrayList();
            ArrayList<Integer> list2 = new ArrayList();
            list1.add(1);
            list2.add(n);
            int start, end;
            while (m-- > 0) {
                start = sc.nextInt();
                end = sc.nextInt();
                if (start == 1 || end == 1) {
                    list1.add(start == 1 ? end : start);
                }
                if (start == n || end == n) {
                    list2.add(start == n ? end : start);
                }
            }
            Boolean isPossible = false;
            for (int mid : list1) {
                if (list2.contains(mid)) {
                    isPossible = true;
                    continue;
                }
            }
            if (isPossible) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

    }
}
