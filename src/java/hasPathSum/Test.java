package hasPathSum;

import utils.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class Test {

    public static boolean p(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return p(root.left, sum - root.val) || p(root.right, sum - root.val);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(3);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        int sum = 22;

        if (root == null) {
            System.out.println(false);
            System.exit(0);
        }
        boolean res = p(root, sum);
        System.out.println(res);
    }

}
