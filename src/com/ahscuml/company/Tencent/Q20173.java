package com.ahscuml.company.Tencent;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/10
 * @time 10:44
 */
public class Q20173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(res(s));
        }
    }

    private static String res(String s) {
        char[] array = s.toCharArray();
        for (int i = array.length; i >= 0; i--) {

        }
        return s;
    }

    private static void swap(int i, int j, char[] array) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
