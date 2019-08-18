package com.ahscuml.company.NetEase;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/9
 * @time 10:42
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // T代码点的个数
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {

            // 对应关系的个数
            int N = scanner.nextInt();
            // 存储当前的对应关系
            char[] first = new char[N];
            char[] second = new char[N];
            for (int j = 0; j < N; j++) {
                String s = scanner.nextLine();
                first[j] = s.charAt(0);
                second[j] = s.charAt(2);
            }
            // M失灵按键的个数
            int M = scanner.nextInt();
            // bad需不需要按照空格分开？？  失灵按键
            String bad = scanner.next();
            char[] un = bad.toCharArray();
            // test 测试的稿件
            String test = scanner.next();
            System.out.println(isMatch(first, second, un, test));
        }


        /*char[] first = {'a', 'b', 'x', 'e', 'f'};
        char[] second = {'b', 'c', 'c', 'f', 'x'};
        char[] un = {'b', 'c'};
        String test = "helloworldabc";
        System.out.println(isMatch(first, second, un, test));*/
    }

    /**
     * 如果可以打出来所有的稿件
     * 那么稿件中的每个字符都得有相应的对应
     * 将可以打印出来的字符设置为一个数组
     * 遍历稿件，查找字符集
     * <p>
     * <p>
     * 维护一个字符数组(或者HashMap)，26个字符下标是INDEX，里面填的是最少寻找的次数
     * 然后遍历这个字符串，加起来最少的和。
     */
    public static int isMatch(char[] first, char[] second, char[] un, String test) {
        // 对次数数组进行初始化
        int[] times = new int[26];
        for (int i = 0; i < 26; i++) {
            times[i] = 1;
        }
        for (int i = 0; i < un.length; i++) {
            times[un[i] - 97] = Integer.MAX_VALUE;
        }

        // 找到失灵按键的解决方法
        for (int s = 0; s < 25; s++) {
            for (int i = 0; i < un.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    if (second[j] == un[i]) {
                        // 如果前面的没失灵
                        if (times[first[j] - 97] != Integer.MAX_VALUE) {
                            times[un[i] - 97] = Math.min(times[first[j] - 97] + 1, times[un[i] - 97]);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < test.length(); i++) {
            if (times[test.charAt(i) - 97] != Integer.MAX_VALUE) {
                res += times[test.charAt(i) - 97];
            } else {
                return -1;
            }
        }
        return res;
    }
}
