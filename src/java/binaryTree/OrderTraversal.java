package binaryTree;

import utils.Constants;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的先序、中序、后续遍历
 */
public class OrderTraversal {

    public static void printpre(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        printpre(list, root.left);
        printpre(list, root.right);
    }
    public static void print(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        print(list, root.left);
        list.add(root.val);
        print(list, root.right);
    }
    public static void printnext(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        printnext(list, root.left);
        printnext(list, root.right);
        list.add(root.val);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        printpre(list, root);
        return list;
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        print(list, root);
        return list;
    }
    public static List<Integer> nextorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        printnext(list, root);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> pre = preorderTraversal(Constants.root);
        System.out.println("先序遍历: " + pre.toString());
        List<Integer> mid = inorderTraversal(Constants.root);
        System.out.println("中序遍历: " + mid.toString());
        List<Integer> next = nextorderTraversal(Constants.root);
        System.out.println("后序遍历: " + next.toString());
    }

}
