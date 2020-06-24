package threeSumClosest;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class Test {

    public static int p(int[] nums, int target) {
        Arrays.sort(nums);

        int min = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int start = i+1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - min) > Math.abs(target - temp)) {
                    min = temp;
                }
                if (temp > target) {
                    end--;
                } else if (temp < target) {
                    start++;
                } else {
                    return min;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;

        int p = p(nums, target);
        System.out.println(p);
    }

}
