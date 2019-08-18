package com.ahscuml.company.NetEase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/8/3
 * @time 14:56
 */
public class SpringQ4 {
    public static void main(String[] args) {
        // 数据的读入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<Integer> number = new ArrayList();
        for (int i = 0; i < n; i++) {
            number.add(sc.nextInt());
        }
        ArrayList<Integer> target = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            target.add(sc.nextInt());
        }
        // 对list中的元素进行排序
        Collections.sort(number);
        for (int i = 0; i < q; i++) {
            for (int index = 0; index < n; index++) {
                if (number.get(index) >= target.get(i)) {
                    System.out.println(n - index);
                    for (int j = index; j < n; j++) {
                        number.set(j, number.get(j) - 1);
                    }
                    break;
                }
                if (index == n - 1) {
                    System.out.println(0);
                }
            }
        }

    }
}
