package sumNumbers;

import utils.TreeNode;

public class Demo {

    public static int process(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return process(root.left, temp) + process(root.right, temp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(1);
        int res = process(root, 0);
        System.out.println("result: " + res);
    }

}
