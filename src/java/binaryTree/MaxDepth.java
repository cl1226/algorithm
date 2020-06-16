package binaryTree;

import utils.Constants;
import utils.TreeNode;

/**
 * leetcode 104 二叉树的最大深度
 */
public class MaxDepth {

    public static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(process(root.left) + 1, process(root.right) + 1);
    }

    public static void main(String[] args) {
        int depth = process(Constants.root);
        System.out.println(depth);
    }

}
