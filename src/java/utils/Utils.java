package utils;

import java.util.*;

public class Utils {

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

}
