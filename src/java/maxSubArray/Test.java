package maxSubArray;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Test {


    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int n = nums.length;
        int[] dp = new int[nums.length];
        dp[n - 1] = nums[n - 1];
        int max = nums[n - 1];
        for (int i=n-2;i>=0;i--) {
            dp[i] = nums[i] + (dp[i+1] > 0 ? dp[i+1] : 0);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
