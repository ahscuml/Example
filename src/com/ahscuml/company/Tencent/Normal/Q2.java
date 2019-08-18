package com.ahscuml.company.Tencent.Normal;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ahscuml
 * @date 2019/4/5
 * @time 19:25
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int res = helper(s);
            System.out.println(res);
        }
    }

    public static int helper(String s) {
        int res = 0;
        if (s == null) {
            return 0;
        } else if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] temp = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(temp[0]);
        for (int i = 1; i < temp.length; i++) {
            String s1 = "";
            String s2 = "";
            if (stack.size() > 0) {
                s1 = s1 + stack.peek();
                s2 = s2 + temp[i];
                if (!s1.equals(s2)) {
                    stack.pop();
                } else {
                    stack.push(temp[i]);
                }
            } else {
                stack.push(temp[i]);
            }
        }
        res = stack.size();
        return res;
    }
}
