package binaryTree;

import utils.TreeNode;

/**
 * leetcode 111. 二叉树的最小深度
 */
public class MinDepth {

    public static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + process(root.right);
        }
        if (root.right == null && root.left != null) {
            return 1 + process(root.left);
        }
        return Math.min(process(root.left), process(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int depth = process(root);
        System.out.println(depth);
    }

}
