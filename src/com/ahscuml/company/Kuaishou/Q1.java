package com.ahscuml.company.Kuaishou;

import java.util.*;

/**
 * @author ahscuml
 * @date 2019/3/30
 * @time 19:38
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s2 = s.split(",");
        if (s2[0].equals("None")) {
            System.out.println("True");
            return;
        }
        int[] nums = new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }
        int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        i++;
        while (i < nums.length) {
            TreeNode left = new TreeNode(nums[i]);
            queue.offer(left);
            queue.peek().left = left;
            i++;
            TreeNode right = new TreeNode(nums[i]);
            queue.offer(right);
            queue.peek().right = right;
            queue.poll();
            i++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        //inOrderRec(root);
        inOrderRec(root, list);
        Collections.sort(list);
        //System.out.println(list);
        for (int j = 1; j < list.size(); j++) {
            if (list.get(j) <= list.get(j - 1)) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }

    private static void inOrderRec(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left, list);
        list.add(root.val);
        inOrderRec(root.right, list);
    }

    private static void inOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.val);
        inOrderRec(root.right);
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
