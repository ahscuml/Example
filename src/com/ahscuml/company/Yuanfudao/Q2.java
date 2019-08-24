package com.ahscuml.company.Yuanfudao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/8/24
 * @time 16:27
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(sc.nextInt());
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : list) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        for(int i: list) {
            if (map.get(i) <= count) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }
}
