package maxDepth;

import utils.TreeNode;
import utils.Utils;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Test {

    public static int p(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(p(root.left) + 1, p(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);

        Utils.printTreeNode(root);

        int p = p(root);
        System.out.println(p);
    }

}
