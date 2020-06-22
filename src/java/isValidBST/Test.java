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
public class Test {

    static class Info {
        boolean isBST;
        public int min;
        public int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static Info p(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = p(root.left);
        Info rightInfo = p(root.right);
        int min = root.val;
        int max = root.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isBST = false;
        if ((leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < root.val))
         && (rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > root.val))) {
            isBST = true;
        }
        return new Info(isBST, min, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        Info info = p(root);
        System.out.println(info.isBST);
    }

}
