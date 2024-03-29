package com.ahscuml.Tree;

import com.ahscuml.util.TreeNode;

import java.util.Stack;

/**
 * 树的中序遍历，首先遍历左子树然后访问根节点，最后访问右子树
 *
 * @author ahscuml
 * @date 2018/11/17
 * @time 14:14
 */
public class InOrder {
    /**
     * 测试函数
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     */
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

        inOrderRec(treeNode1);
        System.out.println("");
        inOrderIte(treeNode1);
    }

    /**
     * 中序遍历， 递归
     */
    private static void inOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.val);
        inOrderRec(root.right);
    }

    /**
     * 中序遍历，循环
     */
    private static void inOrderIte(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                // 先是左子树
                cur = cur.left;
            } else {
                // 到达叶子节点，弹出栈，输出，在遍历右子树
                cur = stack.pop();
                // 跟前序遍历相反，这个是出栈输出
                System.out.print(cur.val);
                cur = cur.right;
            }
        }
    }
}
