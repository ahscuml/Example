package com.ahscuml.company.Didi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/9/19
 * @time 19:50
 */
public class Didi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            map.getOrDefault(i, new ArrayList<>()).add(j);
            map.getOrDefault(j, new ArrayList<>()).add(i);
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = map.containsKey(i) ? map.get(i).size() : 0;
        }
        System.out.println();
    }
}
