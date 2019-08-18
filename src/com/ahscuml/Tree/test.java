package com.ahscuml.Tree;

import com.ahscuml.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ahscuml
 * @date 2019/4/1
 * @time 10:28
 */
public class test {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        PreOrderRec(treeNode1);
        System.out.println("");
        PreOrderIte(treeNode1);

        System.out.println(" ");

        inOrderRec(treeNode1);
        System.out.println("");
        inOrderIte(treeNode1);

        System.out.println(" ");

        PostOrderRec(treeNode1);
        System.out.println(" ");
        PostOrderRec(treeNode1);

        System.out.println(" ");

        LevelOrderIte(treeNode1);
        System.out.println(" ");
        LevelOrderRec(treeNode1);
        System.out.println(" ");
        System.out.println(depthIte(treeNode1));
        System.out.println(depthRec(treeNode1));
    }

    public static void inOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }

    public static void inOrderIte(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.val + " ");
            inOrderRec(root.right);
        }
    }

    public static void PreOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        PreOrderRec(root.left);
        PreOrderRec(root.right);
    }

    public static void PreOrderIte(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    public static void PostOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        PostOrderRec(root.left);
        PostOrderRec(root.right);
        System.out.print(root.val + " ");
    }

    public static void PostOrderIte(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                output.push(cur);
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        while (!output.isEmpty()) {
            System.out.println(output.pop().val + " ");
        }
    }

    /**
     * 层序遍历
     * 首先是递归的方法，递归的方法需要确定层数，层数的确定有递归和循环两种方法
     * 其次的遍历的方法。
     */

    public static void LevelOrderRec(TreeNode root) {
        for (int i = 1; i <= depthIte(root); i++) {
            LevelOrderHelper(root, i);
        }
    }

    public static void LevelOrderHelper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.val + " ");
        }
        LevelOrderHelper(root.left, level - 1);
        LevelOrderHelper(root.right, level - 1);
    }

    public static int depthIte(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int last, level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        queue.offer(root);
        while (!queue.isEmpty()) {
            last = queue.size();
            while (last > 0) {
                cur = queue.poll();
                last--;
                if (cur.left != null) {
                    queue.offer(cur.left);

                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }
        return level;
    }

    public static int depthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depthRec(root.left);
        int r = depthRec(root.right);
        return Math.max(l, r) + 1;
    }

    public static void LevelOrderIte(TreeNode root) {
       if (root == null) {
           return;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       TreeNode cur;
       queue.offer(root);
       while (!queue.isEmpty()) {
           cur = queue.poll();
           System.out.print(cur.val + " ");
           if (cur.left != null) {
               queue.offer(cur.left);
           }
           if (cur.right != null) {
               queue.offer(cur.right);
           }
       }
    }
}
