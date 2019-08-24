package com.ahscuml.company.Yuanfudao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/8/24
 * @time 15:59
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            // 把种类读取到一个列表中
            int count = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                int num = sc.nextInt();
                if (num > 0) {
                    list.add(num);
                }
            }
            // 对这个列表进行排序
            int res = 0;
            while (list.size() >= 3) {
                Collections.sort(list);
                int lastIndex = list.size() - 1;
                list.set(lastIndex, list.get(lastIndex) - list.get(0));
                list.set(lastIndex - 1, list.get(lastIndex - 1) - list.get(0));
                res += list.get(0);
                list.remove(0);
            }
            System.out.println(res);
        }
    }
}
