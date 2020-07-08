package utils;

import java.util.*;

public class Utils {

    public static ListNode buildRandomList(int len) {
        int size = len;
        if (size == 0) {
            return null;
        }
        size--;
        ListNode head = new ListNode((int) (new Random().nextInt(9)));
        ListNode pre = head;
        while (size != 0) {
            ListNode cur = new ListNode((int) (new Random().nextInt(9)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static void printDP(int[][] dp) {
        int m = dp.length;
        int n = dp[0].length;
        System.out.println("---------------------------");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void printTreeNode(TreeNode root) {
        if (root == null) {
            System.out.println("");
        }
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                list.add(String.valueOf(cur.val));
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static TreeNode buildTreeNode(Object val) {
        val = String.valueOf(val).replaceAll(",", "")
                .replace("[", "")
                .replace("]", "")
                .replaceAll(" ", "");
        TreeNode node = new TreeNode(Integer.valueOf(String.valueOf(val)));
        return node;
    }

    public static ListNode buildListNode(int n) {
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode root = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(i);
            head.next = node;
            head = head.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = buildListNode(5);
        printList(root);
    }
}
