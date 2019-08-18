package com.ahscuml.company.ByteDance;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 11:45
 */
public class Q2test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(sc.hasNext()) {
            for (int i = 0; i < N; i++) {
                String s = sc.nextLine();
                int length = s.length();
                char[] sNew = new char[length];
                int index = 0;
                for(int m = 0; m < length; m++) {
                    index = 0;
                    int count = 1;
                    int j = m;
                    while(j + 1 < length && s.charAt(j + 1) == s.charAt(j)) {
                        count++;
                        j++;
                    }
                    if (count >=3) {
                        m = m + count - 2;
                        sNew[index++] = s.charAt(i);
                    } else if(count == 2) {
                        sNew[index++] = s.charAt(m);
                        sNew[index++] = s.charAt(m + 1);
                        if(m + 3 < length && s.charAt(m + 2) == s.charAt(m + 3)) {
                            sNew[index++] = s.charAt(m + 2);
                            m = m + 3;
                        }
                    }
                    else {
                        sNew[index++] = s.charAt(m);
                    }
                }
                for (int n = 0; n < index; n++) {
                    System.out.print(sNew[n]);
                    System.out.println();
                }
            }
        }
    }
}
