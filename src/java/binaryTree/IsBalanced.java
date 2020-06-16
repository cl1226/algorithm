package binaryTree;

import utils.TreeNode;

/**
 * leetcode 110. 是否平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
class Info {
    boolean isBalanced;
    int height;

    public Info(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}
public class IsBalanced {

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 1);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        if (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1) {
            return new Info(true, Math.max(left.height, right.height) + 1);
        }
        return new Info(false, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        Info process = process(root);
        System.out.println(process.isBalanced);

    }

}
