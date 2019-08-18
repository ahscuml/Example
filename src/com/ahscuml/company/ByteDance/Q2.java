package com.ahscuml.company.ByteDance;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 10:40
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (sc.hasNext()) {
            String s = sc.next();
            // 从头至尾判断
            // 首先要判断是不是两个连续，然后分类，是两对还是三个联系
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < s.length(); j++) {

                // 两个连续是所有基础的前提
                if (j < s.length() - 1) {
                    if (s.charAt(j) == s.charAt(j + 1)) {
                        // 判断前三个是不是相等 aaa
                        if (j < s.length() - 2 && s.charAt(j + 1) == s.charAt(j + 2)) {

                        }
                        // 判断aabb
                        else if (j < s.length() - 3 && s.charAt(j + 2) == s.charAt(j + 3)) {
                            sb.append(s, j, j + 2);
                            int tempj = j + 4;
                            while (tempj < s.length() && s.charAt(tempj) == s.charAt(j + 1)) {
                                tempj++;
                            }
                            j = tempj + 1;
                        } else {
                            sb.append(s.charAt(j));
                        }
                    } else {
                        sb.append(s.charAt(j));
                    }
                } else {
                    sb.append(s.charAt(j));
                }
            }
            System.out.println(sb.toString());
        }
    }
}

