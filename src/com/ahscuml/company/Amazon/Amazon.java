package com.ahscuml.company.Amazon;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/2
 * @time 16:28
 */
public class Amazon {
    public static void main(String[] args) {
        int n = 0;
        while (true) {
            System.out.print("请输入n的值:");
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
            if(n == 1 || n == 4) {
                System.out.println("别拿了，你输了");
            } else if (!isWin(n - 1)) {
                System.out.println("拿一个球");
            } else if (!isWin(n - 2)) {
                System.out.println("拿两个球");
            } else if (!isWin(n - 4)) {
                System.out.println("拿四个球");
            } else {
                System.out.println("别拿了，你输了");
            }
        }

    }

    public static boolean isWin(int n) {
        if (n >= 1) {
            switch (n) {
                case 1:
                    return false;
                case 2:
                    return true;
                case 4:
                    return false;
                default:
                    return (!isWin(n - 1) || !isWin(n - 2) || !isWin(n - 4));
            }
        }
        return false;
    }
}
