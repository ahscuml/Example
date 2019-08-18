package com.ahscuml.company.Tencent;

/**
 * 改变字符串，小的在前，大的在后，不申请额外空间
 * @author ahscuml
 * @date 2019/3/10
 * @time 9:55
 */

import java.util.Scanner;

public class Q2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(res(s));
        }
    }

    protected static String res(String s) {
        StringBuilder big = new StringBuilder();
        StringBuilder small = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - 97) >= 0) {
                small.append(s.charAt(i));
            } else {
                big.append(s.charAt(i));
            }
        }
        return small.toString() + big.toString();
    }
}
