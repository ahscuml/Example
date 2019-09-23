package com.ahscuml.company.NetEase;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/9/21
 * @time 14:57
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int target = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if(target < 9) {
                    sb.append(target);
                    sb.reverse();
                    System.out.println(sb.toString());
                    break;
                } else {
                    sb.append(9);
                    target -= 9;
                    if (target == 0) {
                        break;
                    }
                }
            }
        }
    }
}
