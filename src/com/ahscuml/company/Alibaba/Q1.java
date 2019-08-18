package com.ahscuml.company.Alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/4/12
 * @time 18:53
 */
public class Q1 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(getNumber(20));
        //System.out.println(pig(6));
        System.out.println(reverse(126));
        System.out.println(calculate(20, 3));
    }

    static String calculate(int m, int k) {
        // 三个问题，一个先求编号
        int year = 0;
        while (true) {
            if(pig(year) <= m)
                year++;
            else
                break;
        }
        year += 2018;
        int rewardNum = getMax(m, k);
        int num = getNumber(m);
        return num + "," + year + "," + rewardNum;
    }

    // 获取获奖的年份
    static int getMax(int m, int k) {
        // 放入的是原始编号
        for (int i = 1; i <= m; i++) {
            list.add(getNumber(i));
        }

        // 复制一个新的list
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tempList.add(list.get(i));
        }

        // 将这个list的值翻转
        for (int i = 0; i < m; i++) {
            list.set(i, reverse(list.get(i)));
        }
        // 排序
        Collections.sort(list);

        // temp是原始值
        int temp = reverse(list.get(m - k));
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (tempList.get(i) == temp) {
                res = i;
                break;
            }
        }
        return res + 1;
    }

    static int reverse(int num) {
        int temp = 0;
        while (num != 0) {
            temp = temp * 10 + num % 10;
            num /= 10;
        }
        return temp;
    }

    static int getNumber(int m) {
        if (m == 1) {
            return 2;
        } else if (m == 2) {
            return 3;
        } else if (m == 3) {
            return 4;
        } else if (m == 4) {
            return 5;
        } else {
            return getNumber(m - 2) + getNumber(m - 3);
        }
    }

    // 返回个数
    static int pig(int m) {
        m += 3;
        if (m < 3) {
            return 0;
        }
        if (m == 4 || m == 5 || m == 6) {
            return m;
        }
        return pig(m - 4) + pig(m - 6);
    }
}
