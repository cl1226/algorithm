package searchInsert;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class Test {

    public static int p(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) continue;
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        int res = p(nums, target);
        System.out.println(res);
    }

}
