package com.ahscuml.company.Tencent;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/10
 * @time 10:15
 */
public class Q20172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(res(s));
        }
    }

    private static String res(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {

                if ((array[j + 1] - 97) >= 0 && (array[j] - 97) < 0) {
                    swap(j, j + 1, array);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char a : array) {
            sb.append(a);
        }
        return sb.toString();
    }

    private static void swap(int i, int j, char[] array) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
