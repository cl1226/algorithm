package recoverFromPreorder;

import utils.TreeNode;
import utils.Utils;

import java.util.*;

/**
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 */
public class Test {

    public static void main(String[] args) {
        String S = "10-7--8";
        if (S == null || S.equals("")) {
            return;
        }
        char[] arr = S.toCharArray();
        if (arr[0] == '-') {
            return;
        }
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();

        int k = 0;
        List<Character> x = new ArrayList<>();
        x.add(arr[k]);
        k = k+1;
        while (k < arr.length && arr[k] != '-') {
            x.add(arr[k]);
            k++;
        }

        TreeNode root = Utils.buildTreeNode(Arrays.toString(x.toArray()));
        list.add(root);
        map.put(1, list);

        int num = 1;
        for (int i = k; i < arr.length; i++) {
            if (arr[i] == '-') {
                num++;
            } else {
                List<Character> l = new ArrayList<>();
                l.add(arr[i]);
                int index = i+1;
                while (index < arr.length && arr[index] != '-') {
                    l.add(arr[index]);
                    index++;
                }
                i = index-1;
                TreeNode node = Utils.buildTreeNode(Arrays.toString(l.toArray()));
                List<TreeNode> treeNodes = map.get(num - 1);
                TreeNode parent = null;
                if (treeNodes.size() > 0) {
                    parent = map.get(num - 1).get(treeNodes.size() - 1);
                }
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
                if (map.containsKey(num)) {
                    map.get(num).add(node);
                } else {
                    List<TreeNode> temp = new ArrayList<>();
                    temp.add(node);
                    map.put(num, temp);
                }
                num = 1;
            }
        }
        System.out.println(map);
        Utils.printTreeNode(root);
    }

}
