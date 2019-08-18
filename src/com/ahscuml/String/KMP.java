package com.ahscuml.String;

/**
 * @author ahscuml
 * @date 2019/3/15
 * @time 18:35
 */
public class KMP {
    public static void main(String[] args) {
        String s1 = "abdabcabc";
        String s2 = "abc";
        System.out.println(KMP(s1, s2));
        plain(s1, s2);
        stringMatch(s1, s2);
    }

    /**
     * KMP算法
     */
    public static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0;
        int j = 0;
        // next中存储的是j要去的位置
        int[] next = getNext(p);
        while (i < t.length && j < p.length) {
            // 当j为-1时，要移动的是i，当然j也要归0
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                // j回到指定位置
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 求出一个字符数组的next数组
     *
     * @param t 字符数组
     * @return next数组
     */
    public static int[] getNext(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
                next[j] = 0;
            }
        }
        return next;
    }


    /**
     * 经典字符串匹配
     * 输出所有的匹配起始点的下标
     *
     * @param source  目标串
     * @param pattern 模式串
     */
    private static void plain(String source, String pattern) {
        int sourceLength = source.length();
        int patternLength = pattern.length();
        for (int i = 0; i <= (sourceLength - patternLength); i++) {
            String str = source.substring(i, i + patternLength);
            if (str.equals(pattern)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 没有用subString这个函数的简单筛选子串函数
     */
    private static void stringMatch(String souce, String pattern) {
        int souurceLength = souce.length();
        int patternLength = pattern.length();
        for (int i = 0; i <= (souurceLength - patternLength); i++) {
            int tempi = i;
            boolean isMathc = false;
            for (int j = 0; j < patternLength; j++) {
                if (souce.charAt(tempi) == pattern.charAt(j)) {
                    tempi++;
                    isMathc = true;
                } else {
                    isMathc = false;
                    break;
                }
            }
            if (isMathc) {
                System.out.println(i);
            }
        }
    }
}
