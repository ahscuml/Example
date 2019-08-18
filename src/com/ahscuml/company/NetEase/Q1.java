package com.ahscuml.company.NetEase;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/9
 * @time 9:39
 */
public class Q1 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        //for(int i = 0; i < n; i++) {
        //    int width = scanner.nextInt();
        //    int length = scanner.nextInt();
        //    String s = scanner.nextLine();
        //    int temp = res(width,length,s);
        //    if(temp == -1) {
        //        System.out.println("impossible");
        //    } else {
        //        System.out.println(temp);
        //    }
        //}


        int width = 2;
        int length = 5;
        String s = new String("hello,world!");
        System.out.println(res(width, length, s));
        int w = 3;
        int l = 10;
        String s1 = "NoNewLine\nNew!\nLine";
        System.out.println(res(w, l, s1));
        int w1 = 1;
        int l1 = 1;
        System.out.println(res(w1,l1,s));
    }

    public static int res(int width, int length, String s) {
        int n = s.length();
        int curLen = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 判断是不是/n,考虑好换行
            if (s.charAt(i) == '\\' && i < n - 1 && s.charAt(i + 1) == 'n') {
                curLen = 0;
                res++;
            } else if (curLen + width > length) {
                // 只能放在开头，那么如果是标点符号，还要考虑不可能的事情
                if (s.charAt(i) == ',' || s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
                    // 换行开头是标点符号
                    // 回退，直到上一个不是标点符号，但是不能无限回退，还要考虑impossible
                    // impossible的情况只能是，开头遇到标点符号，然后只能回退，把标点符号放到上一行，那么就需要对上一行进行分行
                    // 这样子还要保证上一行可以分行，这一点就要求上一行的倒数第一个字母加上剩下的字符少于一行的长度
                    int temp = 1;
                    int tempi = i;
                    while (!Character.isLetter(s.charAt(tempi))) {
                        tempi--;
                        temp++;
                        if (temp * width > length) {
                            return -1;
                        }
                    }
                    // 换到新的一行，长度为变了，结果加1
                    curLen = temp * width;
                    res++;
                } else {
                    // 换行开头不是标点符号
                    curLen = width;
                    res++;
                }
            } else {
                curLen += width;
            }
        }
        return res + 1;
    }

}
