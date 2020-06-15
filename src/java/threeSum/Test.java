package threeSum;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入: [-1, 0, 1, 2, -1, -4]
 * 输出: [
 *          [-1, 0, 1],
 *          [-1, -1, 2]
 *      ]
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        int[] temp = {arr[i], arr[j], arr[k]};
                        list.add(temp);
                    }
                }
            }
        }
        list.stream().forEach((item) -> {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i]);
                System.out.print("\t");
            }
            System.out.println();
        });
    }

}
