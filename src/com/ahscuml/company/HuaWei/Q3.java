package com.ahscuml.company.HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/4/24
 * @time 19:18
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] charNum = new int[26];
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            charNum[(str.charAt(i) - 97)]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(list);
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                for (int j = 0; j < charNum[25]; j++) {
                    list.add(i);
                }
            } else if (i == 1) {
                for (int j = 0; j < charNum[14] - charNum[22] - charNum[20] - charNum[25]; j++) {
                    list.add(i);
                }
            } else if (i == 2) {
                for (int j = 0; j < charNum[22]; j++) {
                    list.add(i);
                }
            } else if (i == 3) {
                for (int j = 0; j < charNum[17] - charNum[20] - charNum[25]; j++) {
                    list.add(i);
                }
            } else if (i == 4) {
                for (int j = 0; j < charNum[20]; j++) {
                    list.add(i);
                }
            } else if (i == 5) {
                for (int j = 0; j < charNum[5] - charNum[20]; j++) {
                    list.add(i);
                }
            } else if (i == 6) {
                for (int j = 0; j < charNum[23]; j++) {
                    list.add(i);
                }
            } else if (i == 7) {
                for (int j = 0; j < charNum[18] - charNum[23]; j++) {
                    list.add(i);
                }
            } else if (i == 8) {
                for (int j = 0; j < charNum[6]; j++) {
                    list.add(i);
                }
            } else if (i == 9) {
                for (int j = 0; j < charNum[8] - charNum[23] - charNum[6] - charNum[5] + charNum[20]; j++) {
                    list.add(i);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}
