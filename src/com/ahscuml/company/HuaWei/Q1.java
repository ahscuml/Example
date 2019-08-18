package com.ahscuml.company.HuaWei;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/4/24
 * @time 19:07
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 特殊情况，为空判断
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(helper(str));
            ;
        }
    }

    public static String helper(String str) {
        // 总共三个要求，分别满足这三个要求就可以了
        // 1. 顺序和逆序一样，双指针
        // 2. 字符串长度是偶数
        // 3. 前后两个一致，继续用双指针
        int n = str.length();
        // 满足第二点
        if (n % 2 != 0) {
            return "false";
        }
        // 解决第一点
        int i = 0, j = n - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return "false";
            }
            i++;
            j--;
        }
        // 解决第三点 同时解决输出问题
        StringBuffer sb = new StringBuffer();
        i = 0;
        j = 1;
        while (j < n) {
            if (str.charAt(i) != str.charAt(j)) {
                return "false";
            }
            sb.append(str.charAt(i));
            i += 2;
            j += 2;
        }
        // 输出结果，对称的单字符串
        return sb.toString();
    }
}
