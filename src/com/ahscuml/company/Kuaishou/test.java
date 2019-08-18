package com.ahscuml.company.Kuaishou;

import java.util.*;

/**
 * @author ahscuml
 * @date 2019/3/30
 * @time 20:04
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s2 = s.split(" ");
        for (String str: s2) {
            System.out.println(str);
        }
        Queue queue = new LinkedList();
        Queue queue1 = new PriorityQueue();
        queue.offer(1);
        queue.poll();
        System.out.println(queue.isEmpty());
        ArrayDeque stack = new ArrayDeque();
    }
}
