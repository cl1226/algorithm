package maxScoreSightseeingPair;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 * 思路：
 * 对于j位置的数来说，要想求最大值 则是A[i]+i的最大值和A[j]-j的最大值之和
 */
public class Test {

    public static int p1(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i+1; j < A.length; j++) {
                if ((A[i] + A[j] + i - j) > max) {
                    max = A[i] + A[j] + i - j;
                }
            }
        }
        return max;
    }

    public static int p2(int[] A) {
        int m = A[0];
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, m + A[i] - i);
            m = Math.max(m, A[i] + i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {8, 1, 5, 2, 6};

        int max = p1(A);
        System.out.println(max);

        int max2 = p2(A);
        System.out.println(max2);
    }

}
