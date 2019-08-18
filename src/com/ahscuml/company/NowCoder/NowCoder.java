package com.ahscuml.company.NowCoder;

/**
 * 回文字符串
 *
 * @author ahscuml
 * @date 2019/3/4
 * @time 20:48
 */
public class NowCoder {
    public static void main(String[] args) {
        String str = "a car race";
        System.out.println(isP(str));
    }

    public static boolean isP(String str) {
        if (str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                sb.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        sb.toString();
        int n = sb.length() - 1, i = 0;
        while (i < n) {
            if (sb.charAt(i) != sb.charAt(n)) {
                return false;
            }
            i++;
            n--;
        }
        return true;
    }

}
