package isValidBST;

import utils.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Test2 {

    static long min = Long.MIN_VALUE;

    public static boolean p(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!p(root.left)) {
            return false;
        }
        if (root.val <= min) {
           return false;
        }
        min = root.val;
        return p(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        boolean p = p(root);
        System.out.println(p);
    }

}
