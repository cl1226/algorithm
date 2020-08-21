package minDepth;

import utils.TreeNode;
import utils.Utils;

public class Test {

    public static int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right != null) {
            return 1 + process(node.right);
        }
        if (node.right == null && node.left != null) {
            return 1 + process(node.left);
        }
        return Math.min(process(node.left)+1, process(node.right)+1);
    }

    public static void main(String[] args) {
        TreeNode root = Utils.buildTreeNode(5);
        Utils.printTreeNode(root);
        int process = process(root);
        System.out.println(process);
    }

}
