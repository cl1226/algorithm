package binaryTree;

import utils.Constants;
import utils.TreeNode;

import java.util.*;

import static utils.Utils.printTreeNode;

/**
 * 二叉树的序列化和反序列化
 * 使用二叉树的宽度优先遍历
 * leetcode 297
 */
public class CodeS {

    // Encodes a tree to a single string.
    // 宽度优先遍历
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return "[null]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                list.add(String.valueOf(cur.val));
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                list.add("null");
            }
        }
        return Arrays.toString(list.toArray());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String ss = data.substring(1, data.length() - 1);
        System.out.println(ss);
        String[] splits = ss.split(",");
        if (splits.length <= 0) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < splits.length; i++) {
            queue.add(splits[i]);
        }
        TreeNode root = buildTreeNode(queue.poll());

        Queue<TreeNode> head = new LinkedList<>();
        head.add(root);

        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = head.poll();
            node.left = buildTreeNode(queue.poll());
            node.right = buildTreeNode(queue.poll());
            if (node.left != null) {
                head.add(node.left);
            }
            if (node.right != null) {
                head.add(node.right);
            }
        }
        return root;
    }

    public static TreeNode buildTreeNode(String s) {
        if (s.trim().equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(s.trim()));
    }

    public static void main(String[] args) {
        CodeS codeS = new CodeS();
        String s = codeS.serialize(Constants.root);
        TreeNode r = codeS.deserialize(s);
        printTreeNode(r);
    }

}
